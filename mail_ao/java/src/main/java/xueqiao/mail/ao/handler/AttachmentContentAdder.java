package xueqiao.mail.ao.handler;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;

/**
 * 邮件附件添加器
 * */
public class AttachmentContentAdder {

    public void add(Multipart mp, String attachmentPath) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(attachmentPath);
        mimeBodyPart.setDataHandler(new DataHandler(fds));
        mimeBodyPart.setFileName(fds.getName());
        mp.addBodyPart(mimeBodyPart);
    }
}
