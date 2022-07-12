package terminalApp.model;

import java.sql.Date;

public class Tweet {
	private String id;
	private String owner;
	private String body;
	private Date date;

	public Tweet(String id, String owner, String body, Date date) {
		super();
		this.id = id;
		this.owner = owner;
		this.body = body;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
