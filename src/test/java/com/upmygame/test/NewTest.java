package com.upmygame.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.upmygame.test.utils.EmailUtils;
import com.upmygame.test.utils.Mail;

public class NewTest {
	@Test
	public void gmailTest() throws Exception {
		EmailUtils email = new EmailUtils();
		email.setCredentials("Framework.EPAM@gmail.com", "Framework.EPAM");
		email.connect();
		email.openFolder("Inbox");
		email.getLastMail();
		List<Mail> mailList = email.getLastMessages(20);
		Assert.assertEquals(mailList.size(), 20);
		List<Mail> a = email.getMessagesByBodyPart("Google");
		for (Mail mail : a) {
			System.out.println(mail.getSubject());
			System.out.println(mail.getFrom());
			System.out.println(mail.getSendDate());
			System.out.println(mail.getBody());
		}
		List<Mail> mailListy = email.getMessagesBySubjectPart("Top 3 posts for you on Google+ this week");
		System.out.println("getMessagesBySubjectPart RETURN:  "+mailListy.size() +" elements");
		int totalMessages = email.getMessageCount();
		int newMessages = email.getNewMessageCount();
		System.out.println("Total messages: " + totalMessages);
		System.out.println("New message: " + newMessages);
		email.closeFolder();
		email.disconnect();
	}
}
