package xueqiao.mail.ao.handler;

import xueqiao.mail.MailContent;

import javax.mail.MessagingException;
import javax.mail.Multipart;

/**
 * 邮件内容添加器接口
 * */
public interface ContentAdder {
    void add(Multipart mp, MailContent content) throws MessagingException;
}
