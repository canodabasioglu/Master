/**
 * @author Can Odabasioglu
 * Created on 27.Þub.2005
 * @version 1.02
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.odabasioglu.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.ParseException;

import org.apache.log4j.Logger;

import com.odabasioglu.data.TbParameters;
import com.odabasioglu.manager.LogManager;
import com.odabasioglu.manager.ParametersManager;
import com.sun.mail.pop3.POP3Store;

public class MailUtility {

	private Session session = null;

	private Store store = null;

	private String username, password;

	private Folder folder;

	private static String indentStr = "                                      ";

	private boolean debug = false;
	private static String adminEmail1 = ParametersManager.parameterValueByName("AdminEmail1");
	private static String adminEmail2 = ParametersManager.parameterValueByName("AdminEmail2");	

	private static final String[] adminMails = new String[]{adminEmail1,adminEmail2};

	private void setUserPass(String username, String password) {
		this.username = username;
		this.password = password;
	}

	private void connect() throws Exception {

		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties pop3Props = new Properties();
		pop3Props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
		pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
		pop3Props.setProperty("mail.pop3.port", "995");
		pop3Props.setProperty("mail.pop3.socketFactory.port", "995");
		URLName url = new URLName("pop3", "pop.gmail.com", 995, "", username,
				password);

		session = Session.getInstance(pop3Props, null);
		store = new POP3Store(session, url);
		store.connect();

	}

	private void openFolder(String folderName) throws Exception {

		// Open the Folder
		folder = store.getDefaultFolder();
		folder = folder.getFolder(folderName);

		if (folder == null) {
			throw new Exception("Invalid folder");
		}

		// try to open read/write and if that fails try read-only
		try {
			folder.open(Folder.READ_WRITE);
		} catch (MessagingException ex) {
			folder.open(Folder.READ_ONLY);
		}
	}

	private void closeFolder() throws Exception {
		folder.close(false);
	}

	private int getMessageCount() throws Exception {
		return folder.getMessageCount();
	}

	private int getNewMessageCount() throws Exception {
		return folder.getNewMessageCount();
	}

	private void disconnect() throws Exception {
		store.close();
	}

	private void printMessage(int messageNo) throws Exception {
		

		Message m = null;

		try {
			m = folder.getMessage(messageNo);
			dumpPart(m);
		} catch (IndexOutOfBoundsException iex) {
			Logger.getLogger("Message Number Out Of"+iex);
		}
	}

	private void printAllMessageEnvelopes() throws Exception {

		// Attributes & Flags for all messages ..
		Message[] msgs = folder.getMessages();
		// Use a suitable FetchProfile
		FetchProfile fp = new FetchProfile();
		fp.add(FetchProfile.Item.ENVELOPE);
		folder.fetch(msgs, fp);

		for (int i = 0; i < msgs.length; i++) {
			Logger.getLogger("MESSAGE #" + (i + 1) + ":");
	
			dumpEnvelope(msgs[i]);
		}

	}

	private void printAllMessages() throws Exception {

		// Attributes & Flags for all messages ..
		Message[] msgs = folder.getMessages();

		// Use a suitable FetchProfile
		FetchProfile fp = new FetchProfile();
		fp.add(FetchProfile.Item.ENVELOPE);
		folder.fetch(msgs, fp);

		for (int i = 0; i < msgs.length; i++) {
			Logger.getLogger("MESSAGE #" + (i + 1) + ":");
			dumpPart(msgs[i]);
		}

	}

	private static void dumpPart(Part p) throws Exception {
		if (p instanceof Message)
			dumpEnvelope((Message) p);

		String ct = p.getContentType();
		try {
			print("CONTENT-TYPE: " + (new ContentType(ct)).toString());
		} catch (ParseException e) {
		e.printStackTrace();
		}

		/*
		 * Using isMimeType to determine the content type avoids fetching the
		 * actual content data until we need it.
		 */
		if (p.isMimeType("text/plain")) {
			print("This is plain text");
			print("---------------------------");
			System.err.println((String) p.getContent());
		}

	}

	private static void dumpEnvelope(Message m) throws Exception {
		print(" ");
		Address[] a;
		// FROM
		if ((a = m.getFrom()) != null) {
			for (int j = 0; j < a.length; j++)
				print("FROM: " + a[j].toString());
		}

		// TO
		if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
			for (int j = 0; j < a.length; j++) {
				print("TO: " + a[j].toString());
			}
		}

		// SUBJECT
		print("SUBJECT: " + m.getSubject());

		// DATE
		Date d = m.getSentDate();
		print("SendDate: " + (d != null ? d.toString() : "UNKNOWN"));

	}

	/**
	 * Print a, possibly indented, string.
	 */
	private static void print(String s) {

		System.err.print(indentStr.substring(0, 0 * 2));
		System.err.println(s);
	}

	public void sendPasswordMail(String recipientsTo[], ArrayList message) throws Exception {

		String messageContent="<html><meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-9'/><TABLE border='0'><TBODY><TR><TD colspan='2'><FONT color='#004080'></FONT><FONT color='#000040'>Sayin <I>"+message.get(0)+" "+message.get(1)+"</I> <B>yatmarketi.com </B> Üyelik Bilgileriniz asagidaki gibidir.</FONT><BR></TD></TR><TR><TD height='32' width='142'><FONT color='#004080'><B>E-Posta Adresiniz :</B></FONT></TD><TD height='32' width='379'><FONT color='#004080'>"+message.get(2)+"</FONT></TD></TR><TR><TD height='29' width='142'><FONT color='#004080'><B>Sifreniz :</B></FONT></TD><TD height='29' width='379'><FONT color='#004080'>"+message.get(3)+"</FONT></TD></TR><TR><TD colspan='2' height='54' align='center'><FONT color='#004080'>Bu e-posta yatmarketi.com üzerinden sifremi hatirlamiyorum servisi tarafindan gönderilmistir.<BR><BR></FONT><FONT color='#ff8000'><A href='http://www.yatmarketi.com' target='_blank'>www.yatmarketi.com </A></FONT></TD></TR></TBODY></TABLE></html>";
		String flag = ParametersManager.parameterValueByName("PasswordMail");
		if(flag.equals("enable")){
		sendMail(messageContent, "Yatmarketi Þifre Hatýrlatma", recipientsTo,adminMails);
		}

	}

	public void sendNewUserMail(ArrayList message) throws Exception {

		String messageContent="<HTML><meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-9'/>"+
		"<BODY><TABLE><TBODY><TR><TD colspan='2'>Yatmarketi.com'a hosgeldiniz. Sitedeki üyelik bilgileriz asagidaki daki gibidir.</TD></TR><TR>"+
		"<TD>E-Posta Adresi:</TD><TD>"+message.get(0)+"</TD></TR><TR><TD>Adi Soyadi</TD><TD>"+message.get(3)+" "+message.get(4)+"</TD>"+
		"</TR><TR><TD>Kullanici Adi</TD><TD>"+message.get(1)+"</TD></TR><TR><TD>Sifre:</TD><TD>"+message.get(2)+"</TD></TR><TR><TD>Dogum Yeri:</TD><TD>"+message.get(10)+"</TD>"+
        "</TR><TR><TD>Dogum Tarihi:</TD><TD>"+message.get(11)+"</TD></TR><TR><TD>Telefon:</TD><TD>"+message.get(5)+"</TD></TR><TR><TD>Faks:</TD><TD>"+message.get(6)+"</TD>"+
        "</TR><TR><TD>Cep Telefonu:</TD><TD>"+message.get(7)+"</TD></TR><TR><TD>\u00DCyelik Tarihi:</TD><TD>"+message.get(8)+"</TD></TR><TR><TD>IP:</TD><TD>"+message.get(9)+"</TD></TR><TR><TD colspan='2' align='center'>Bu e-posta yatmarketi.com uzerinden gönderilmistir.</TD>"+
    	"</TR><TR><TD colspan='2' align='center'><A href='http://www.yatmarketi.com' target='_blank'>www.yatmarketi.com</A></TD></TR></TBODY></TABLE></BODY></HTML>";
		String flag = ParametersManager.parameterValueByName("NewUserMail");
		if(flag.equals("enable")){
		sendMail(messageContent, "Yatmarketi yeni üyelik",new String[]{(String) message.get(0)},adminMails);
		}

	}
	
	public void sendNewOrderMail(ArrayList message) throws Exception {

		String messageContent="<HTML><meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-9'/><BODY><TABLE><TBODY><TR><TD colspan='2'>Yatmarketi.com a vermis olduðunuz siparis  bize ulasmistir. Tesekkürler...</TD></TR><TR><TD colspan='2' align='center'>Bu e-posta yatmarketi.com üzerinden gönderilmistir.</TD></TR><TR><TD colspan='2' align='center'><A href='http://www.yatmarketi.com' target='_blank'>www.yatmarketi.com</A></TD></TR></TBODY></TABLE></BODY></HTML>";
		String flag = ParametersManager.parameterValueByName("NewOrderMail");
		if(flag.equals("enable")){
		sendMail(messageContent, "Yatmarketi sipariþiniz bize ulaþtý.",new String[]{(String) message.get(0)},adminMails);
		}

	}
	
	public void sendFeedbackFormMail(ArrayList message) throws Exception {

		String messageContent="<HTML><meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-9'/><BODY><TABLE><TBODY><TR><TD colspan='2'>Yatmarketi.com’a asagidaki ileti gonderildi.</TD></TR><TR><TD colspan='2'>"+message.get(1)+"</TD></TR><TR><TD colspan='2' align='center'>Bu e-posta yatmarketi.com üzerinden gönderilmistir.</TD></TR><TR><TD colspan='2' align='center'><A href='http://www.yatmarketi.com' target='_blank'>www.yatmarketi.com</A></TD></TR></TBODY></TABLE></BODY></HTML>";
		String flag = ParametersManager.parameterValueByName("FeedbackFormMail");
		if(flag.equals("enable")){
		sendMail(messageContent, "Yatmarketine ileti geldi: "+message.get(0),adminMails,null);
		}

	}
	
	public void sendFatalError(String error) throws Exception{
		String flag = ParametersManager.parameterValueByName("FatalErrorMail");
		if(flag.equals("enable")){
			sendMail(error, "Yatmarketi crash oldu!! ",adminMails,null);
		}
			
		}

	public void sendCurrencyWarning(Date time) throws Exception{
		String messageContent="<HTML><meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-9'/><BODY><TABLE><TBODY><TR><TD colspan='2'>Yatmarketi.com da kullanilan dolar ve euro kuru 2 gunden ("+time+") daha eskidir. Lutfen en kisa sürede güncelleyiniz.</TD></TR><TR><TD colspan='2' align='center'>Bu e-posta yatmarketi.com üzerinden gönderilmistir.</TD></TR><TR><TD colspan='2' align='center'><A href='http://www.yatmarketi.com' target='_blank'>www.yatmarketi.com</A></TD></TR></TBODY></TABLE></BODY></HTML>";
		String flag = ParametersManager.parameterValueByName("CurrencyWarningMail");
		if(flag.equals("enable")){
		sendMail(messageContent, "Döviz kuru çok eski !! ",adminMails,null);
		}

	}
	
	private class SMTPAuthenticatorGmail extends Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			String username = "yatmarketi@gmail.com";
			String password = "odinpark";
			return new PasswordAuthentication(username, password);
		}
	}

	private boolean sendMail(String messageContent,String subject,String recipientsTo[],String recipientsBCC[]) throws Exception {
		boolean sendSuccess = false;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.user", "yatmarketi@gmail.com");
		props.put("mail.smtp.password", "odinpark");
		
		try {
			Authenticator auth = new SMTPAuthenticatorGmail();
			Session session = Session.getInstance(props, auth);
			session.setDebug(debug);			
			
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("yatmarketi", "www.yatmarketi.com");	
			
			InternetAddress addressFrom = new InternetAddress(
					"yatmarketi@gmail.com");
			msg.setFrom(addressFrom);

			InternetAddress[] addressTo = new InternetAddress[recipientsTo.length];
			for (int i = 0; i < recipientsTo.length; i++) {
				addressTo[i] = new InternetAddress(recipientsTo[i]);
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			
			if(recipientsBCC!=null){
			InternetAddress[] addressBCC = new InternetAddress[recipientsBCC.length];
			for (int i = 0; i < recipientsBCC.length; i++) {
				addressBCC[i] = new InternetAddress(recipientsBCC[i]);
			}
			msg.setRecipients(Message.RecipientType.BCC, addressBCC);
			}
			msg.setSubject(subject,"ISO-8859-9");
			msg.setContent(messageContent, "text/html");		
			String flag =ParametersManager.parameterValueByName("EmailStatus");
			if(flag.equals("enable")){
				Transport.send(msg);
				LogManager.logOperations("E-posta basariyla gönderildi. ");
				sendSuccess = true;			
			}
			
			
		} catch (Exception e) {
			sendSuccess = false;
			Logger.getLogger(e.getMessage());
		}
	
		return sendSuccess;

	}

	



}
