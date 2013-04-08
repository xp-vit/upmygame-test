package com.upmygame.test.utils;

import java.util.Date;

public class Mail {

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public String getBody() {
		return body;
	}

	public Mail(String from, String subject, Date sendDate, String body) {
		super();
		this.from = from;
		this.subject = subject;
		this.sendDate = sendDate;
		this.body = body;
	}

	private String from;
	private String subject;
	private Date sendDate;
	private String body;

}
