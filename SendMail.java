
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail{
	
	public static void main(String[] args) throws Exception {
		sendEmail("sender user name");
	}		
	
	
	public static void sendEmail(String args) throws Exception {
		System.out.println("Preparing to send email....");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		String Myaccount = args;
		String Password = "password";
		String Receipnt = "receipnt mail";
		
		Session session = Session.getInstance(properties,new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			// TODO Auto-generated method stub
			System.out.println("entered authentication....");
			return new PasswordAuthentication(Myaccount, Password);
		}	
		});
		
		Message message = prepareMessage(session,Myaccount,Receipnt);
		
		Transport.send(message);
		System.out.println("message sent succesfully....");
	}

	private static Message prepareMessage(Session session , String Myaccount , String Receipnt) {
		Message msg = new MimeMessage(session);
		try {
	
			msg.setFrom(new InternetAddress(Myaccount));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(Receipnt));
			msg.setSubject("HI this is subject");
			msg.setText("hi mail this is ashish....");
			return msg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}