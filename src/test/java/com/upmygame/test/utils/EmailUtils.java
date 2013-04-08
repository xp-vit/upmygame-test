package com.upmygame.test.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class EmailUtils {

	private Session session = null;
	private Store store = null;
	private String username, password;
	private Folder folder;

	public void setCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void connect() throws Exception {

		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

		Properties pop3Props = new Properties();

		pop3Props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
		pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
		pop3Props.setProperty("mail.pop3.port", "995");
		pop3Props.setProperty("mail.pop3.socketFactory.port", "995");

		Properties props = System.getProperties();
		props.setProperty("mail.imap.host", "imap.gmail.com");
		props.setProperty("mail.imap.port", "993");
		props.setProperty("mail.imap.connectiontimeout", "5000");
		props.setProperty("mail.imap.timeout", "5000");

		session = Session.getDefaultInstance(props, null);
		store = session.getStore("imaps");
		store.connect("imap.gmail.com", username, password);

	}

	public void disconnect() throws Exception {
		store.close();
	}

	public void openFolder(String folderName) throws Exception {

		folder = store.getDefaultFolder();

		folder = folder.getFolder(folderName);

		if (folder == null) {
			throw new Exception("Invalid folder");
		}

		try {

			folder.open(Folder.HOLDS_MESSAGES);

		} catch (MessagingException ex) {

			folder.open(Folder.READ_ONLY);

		}
	}

	public void closeFolder() throws Exception {
		folder.close(false);
	}

	public String getFolderName() {
		return folder.getFullName();
	}

	public ArrayList<Mail> getLastMessages(int count) throws Exception {
		Message[] m = null;
		ArrayList<Mail> mailList = new ArrayList<Mail>();
		try {
			m = folder.getMessages(folder.getMessageCount() - count + 1,
					folder.getMessageCount());
			for (Message message : m) {
				mailList.add(mailCreator(message));
			}
			return mailList;

		} catch (IndexOutOfBoundsException iex) {
			return mailList;
		}
	}

	public Mail getLastMail() throws MessagingException, IOException {
		Message m = null;
		try {
			m = folder.getMessage(folder.getMessageCount());
			return mailCreator(m);

		} catch (IndexOutOfBoundsException iex) {
			return null;
		}
	}

	public ArrayList<Mail> getMessagesBySubjectPart(String subject)
			throws MessagingException, IOException {
		Message[] m = folder.getMessages();
		ArrayList<Mail> mailList = new ArrayList<Mail>();
		for (Message message : m) {
			if (message.getSubject().contains(subject)) {
				mailList.add(mailCreator(message));
			}
		}

		return mailList;
	}

	public ArrayList<Mail> getMessagesByBodyPart(String part)
			throws MessagingException, IOException {
		Message[] messages = folder.getMessages();

		ArrayList<Mail> mailList = new ArrayList<Mail>();
		for (Message message : messages) {
			String body = getBody(message);
			if (body.contains(part)) {

				mailList.add(mailCreator(message));
			}
		}

		return mailList;

	}

	public int getMessageCount() throws Exception {
		return folder.getMessageCount();
	}

	public int getNewMessageCount() throws Exception {
		return folder.getNewMessageCount();
	}

	public Mail getMessage(int messageNo) throws Exception {

		Message m = null;
		try {
			m = folder.getMessage(messageNo);
			return mailCreator(m);
		} catch (IndexOutOfBoundsException iex) {
			return null;
		}
	}

	private static String getBody(Message message) throws MessagingException,
			IOException {

		Multipart multipart = (Multipart) message.getContent();
		BodyPart bodyPart = multipart.getBodyPart(0);

		return bodyPart.getContent().toString();
	}

	private static Mail mailCreator(Message m) throws MessagingException,
			IOException {

		return new Mail(m.getFrom()[0].toString(), m.getSubject(),
				m.getSentDate(), getBody(m));

	}

}
