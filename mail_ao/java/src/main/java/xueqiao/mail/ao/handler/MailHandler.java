package xueqiao.mail.ao.handler;

import com.antiy.error_code.ErrorCodeInner;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mail.ContentType;
import xueqiao.mail.MailEntity;
import xueqiao.mail.MailSettings;
import xueqiao.mail.ao.authenticator.EmailAuthenticator;
import xueqiao.mail.ao.config.Config;
import xueqiao.mail.ao.monitor.PlatformMonitor;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MailHandler {
    public void checkParams(MailSettings settings, MailEntity mailEntity) throws ErrorInfo {
        if (settings == null) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "settings should not be null");
        }
        if (StringUtils.isBlank(settings.getSmtpHost())) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "smtpHost should not be blank");
        }
        if (StringUtils.isBlank(settings.getSender())) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "sender should not be blank");
        }
        if (StringUtils.isBlank(settings.getPasswd())) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "passwd should not be blank");
        }

        if (mailEntity == null) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "mailEntity should not be null");
        }
        if (mailEntity.getReceivers() == null || mailEntity.getReceiversSize() < 1) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "receivers should not be empty");
        }
        if (mailEntity.getContent() == null) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "content should not be null");
        }
        if (StringUtils.isBlank(mailEntity.getSubject())) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "subject should not be blank");
        }
    }

    public void sendMail(MailSettings settings, MailEntity mailEntity) {
//        AppLog.i("MailHandler ---- sendMail ---- settings : " + settings.toString() + ", mailEntity : " + mailEntity.toString());
        Properties props = new Properties();
        props.put("mail.smtp.host", settings.getSmtpHost());
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.auth", "true");

        if (Config.DEBUG) {
            props.put("mail.smtp.debug", "true");
            props.put("mail.debug", "true");
        }

        EmailAuthenticator emailAuthenticator = new EmailAuthenticator(settings.getSender(), settings.getPasswd());
        Session session = Session.getInstance(props, emailAuthenticator);

        String senderAlias = null;
        if (StringUtils.isNotBlank(settings.getSenderAlias())) {
            try {
                senderAlias = javax.mail.internet.MimeUtility.encodeText(settings.getSenderAlias());
            } catch (UnsupportedEncodingException e) {
                AppLog.e("MailHandler ---- get alias UnsupportedEncodingException", e);
            }
        }

        try {
            Message msg = new MimeMessage(session);
            if (senderAlias == null) {
                msg.setFrom(new InternetAddress(settings.getSender()));
            } else {
                msg.setFrom(new InternetAddress(senderAlias + "<" + settings.getSender() + ">"));
            }

            msg.setSubject(mailEntity.getSubject());
            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, initAddressList(mailEntity.getReceivers()));
            /*
            * 设置抄送及秘密抄送人
            * */
            if (mailEntity.isSetCc() && mailEntity.getCcSize() > 0) {
                msg.setRecipients(Message.RecipientType.CC, initAddressList(mailEntity.getCc()));
            }
            if (mailEntity.isSetBcc() && mailEntity.getBccSize() > 0) {
                msg.setRecipients(Message.RecipientType.BCC,  initAddressList(mailEntity.getBcc()));
            }

            /*
            * 设置邮件正文内容
            * */
            ContentAdder contentAdder = null;
            Multipart mp = new MimeMultipart();
            if (mailEntity.getContent().getContentType() == ContentType.TEXT) {
                contentAdder = new TextContentAdder();
            } else if (mailEntity.getContent().getContentType() == ContentType.HTML) {
                contentAdder = new HtmlContentAdder();
            }
            contentAdder.add(mp, mailEntity.getContent());

            /*
            * 添加附件
            * */
            if (mailEntity.isSetAttachments() && mailEntity.getAttachmentsSize() > 0) {
                for (String attachmentPath : mailEntity.getAttachments()) {
                    AttachmentContentAdder attachmentContentAdder = new AttachmentContentAdder();
                    attachmentContentAdder.add(mp, attachmentPath);
                }
            }
            msg.setContent(mp);
            msg.saveChanges();

            Transport.send(msg);
        } catch (MessagingException mex) {
            PlatformMonitor.reportSendMailException();
            AppLog.e("MailHandler ---- sendMail exception ---- settings : " + settings.toString() + ", mailEntity : " + mailEntity.toString(), mex);
            /*
            * 输出嵌套的异常
            * */
            while (mex.getNextException() != null) {
                Exception ex = mex.getNextException();
                AppLog.e("MailHandler ---- send mail nested exception", ex);
                if (!(ex instanceof MessagingException)) break;
                else mex = (MessagingException) ex;
            }
        }
    }

    private Address[] initAddressList(List<String> addressStringList) throws AddressException {
        Address[] resultList = new Address[addressStringList.size()];
        for (int index = 0; index < addressStringList.size(); ++index) {
            resultList[index] = new InternetAddress(addressStringList.get(index));
        }
        return resultList;
    }
}
