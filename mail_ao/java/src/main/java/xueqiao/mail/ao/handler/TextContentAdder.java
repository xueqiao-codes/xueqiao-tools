package xueqiao.mail.ao.handler;

import xueqiao.mail.MailContent;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;

/**
 * 文本类型邮件内容添加器
 * */
public class TextContentAdder implements ContentAdder {
    @Override
    public void add(Multipart mp, MailContent content) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(content.getContent());
        mp.addBodyPart(mimeBodyPart);
    }
}
