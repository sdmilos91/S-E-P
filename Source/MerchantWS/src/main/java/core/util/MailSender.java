package core.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	public static void sendMail(String titlep,String messageTextp,String addressp){
		final String title=titlep;
		final String messageText=messageTextp;
		final String address=addressp;
		Thread smt=new Thread(new Runnable() {
			public void run() {
				final String username = "kodzoteam@gmail.com";
				final String password = "sepkodzoteam";
		 
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
		 
				Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		 
				try {
		 
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(username));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(address));
					message.setSubject(title);
					message.setText(messageText);
		 
					Transport.send(message);
		 					
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		});
		smt.run();
		
	}
}
