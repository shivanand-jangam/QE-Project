package com.base;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OutlookTest {

	// "outlook.office365.com", "qatest1258@outlook.com", "TestAutomation@11"
	static final String username = "qatest1258@outlook.com";
	static final String password = "TestAutomation@11";
	static Properties props = new Properties();

	public static void main(String[] args) throws MessagingException {
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		getOTPFromEmail();
		getOtpFromBody();

	}

	public static void sendEmail() {
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("shivanand.jangam@gmail.com")); // Replace
																													// with
																													// recipient
			message.setSubject("Test Email");
			message.setText("Hello,\n\nThis is a test email from Java using javax.mail API.");

			Transport.send(message);

			System.out.println("Email sent successfully.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void getOTPFromEmail() {

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Store store = session.getStore("imap");
			store.connect();

			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);

			Message[] messages = inbox.getMessages();

			for (Message message : messages) {
				if (message instanceof MimeMessage) {
					MimeMessage mimeMessage = (MimeMessage) message;
					System.out.println("Subject: " + mimeMessage.getSubject());
					System.out.println("From: " + mimeMessage.getFrom()[0]);
					System.out.println("Date: " + mimeMessage.getSentDate());
					System.out.println("Content: " + mimeMessage.getContent().toString());
					System.out.println("-----------------------------------");
				}
			}

			inbox.close(false);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getOtpFromBody() {
		String body = "Dear Valued Customer,\r\n"
				+ "The OTP for availing the benefits of Babyhug Smart Buyer Club at the store is 8230. Please share this OTP with the Store Manager. Kindly note that the OTP is valid for 5 minutes.";

		System.out.println("The OTP is: "+body.split("store is")[1].substring(0, 4));
		return body.split("store is")[1].substring(0, 4);
	}
}
