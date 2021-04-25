package xueqiao.mail.ao.test;

import org.soldier.base.logger.AppLog;
import xueqiao.mail.ao.authenticator.EmailAuthenticator;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

public class test {

	public static void sendMailWithText(String to) {

		AppLog.i("test ---- sendMailWithText ---- to : " + to);
		// SUBSTITUTE YOUR EMAIL ADDRESSES HERE!
//		String to = "sendToMailAddress";
//		String from = "lijianqiang@xueqiao.cn";
		String from = "service@xueqiao.cn";
		// SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!
		String host = "smtp.xueqiao.cn";
		String port = "465";

		// Create properties, get Session
		Properties props = new Properties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// If using static Transport.send(),
		// need to specify which host to send it to
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		// To see what is going on behind the scene
		props.put("mail.debug", "true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.fallback", "false");

		// auth
		props.put("mail.smtp.auth", "true");
		EmailAuthenticator authentication = new EmailAuthenticator(from, "SerVice1919");

		Session session = Session.getInstance(props, authentication);

		try {

//			Transport bus = session.getTransport("smtp");
//			bus.connect();
			// Instantiate a message
			Message msg = new MimeMessage(session);

			//Set message attributes
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject("雪橇测试邮件");
			msg.setSentDate(new Date());

			// Set message content
//			msg.setText("这是一封来自雪橇后台的测试邮件" +
//				"你好\n" +
//				"来自雪橇");
			/*
			* 发出的邮件，有可能会被放到垃圾箱中
			* */
//			msg.setText("这是一封来自雪橇后台的测试邮件 " +
//				"这是一封来自雪橇后台的测试邮件\n" +
//				"雪橇");
//			msg.setText("This is a test of sending a " +
//				"plain text e-mail through Java.\n" +
//				"Here is line 2.");
//			setTextContent(msg);
			setHtmlContext(msg);
//			setFileAsAttachment(msg, "F:\\dapaul.jpg");

			//Send the message
			Transport.send(msg);
//			bus.sendMessage(msg, address);
//			bus.close();
		} catch (MessagingException mex) {
			// Prints all nested (chained) exceptions as well
			mex.printStackTrace();
            AppLog.e("send mail error", mex);
		}
	}

	private static void setTextContent(Message msg) throws MessagingException {
		String mytxt = "Hello, I am dapaul";

//		// Set message content
//		String mytxt = "This is a test of sending a " +
//			"plain text e-mail through Java.\n" +
//			"Here is line 2.";
		msg.setText(mytxt);

		// Alternate form
//		msg.setContent(mytxt, "text/plain");
	}

	private static void setHtmlContext(Message msg) throws MessagingException {

		String html = "<html><head><title>" +
			msg.getSubject() +
			"</title></head><body><h1>" +
			msg.getSubject() +
			"</h1><p>This is a test of sending an HTML e-mail" +
			" through Java.</body></html>";

		// HTMLDataSource is a static nested class
		msg.setDataHandler(new DataHandler(new HTMLDataSource(html)));
	}

	public static void setFileAsAttachment(Message msg, String filename)
		throws MessagingException {

		// Create and fill first part
		MimeBodyPart p1 = new MimeBodyPart();
		p1.setText("This is part one of a test multipart e-mail." +
			"The second part is file as an attachment");

		// Create second part
		MimeBodyPart p2 = new MimeBodyPart();

		// Put a file in the second part
		FileDataSource fds = new FileDataSource(filename);
		p2.setDataHandler(new DataHandler(fds));
		p2.setFileName(fds.getName());

		// Create the Multipart.  Add BodyParts to it.
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(p1);
		mp.addBodyPart(p2);

		// Set Multipart as the message's content
		msg.setContent(mp);
	}

	static class HTMLDataSource implements DataSource {
		private String html;

		public HTMLDataSource(String htmlString) {
			html = htmlString;
		}

		// Return html string in an InputStream.
		// A new stream must be returned each time.
		public InputStream getInputStream() throws IOException {
			if (html == null) throw new IOException("Null HTML");
			return new ByteArrayInputStream(html.getBytes());
		}

		public OutputStream getOutputStream() throws IOException {
			throw new IOException("This DataHandler cannot write HTML");
		}

		public String getContentType() {
			return "text/html";
		}

		public String getName() {
			return "JAF text/html dataSource to send e-mail only";
		}
	}
}
