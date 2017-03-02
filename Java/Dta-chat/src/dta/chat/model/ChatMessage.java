package dta.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	private String login;
	private String text;
	private static final long serialVersionUID = 12L;

	public ChatMessage(String login, String msg) {
		this.login = login;
		this.text = msg;
	}

	public String getLogin() {
		return login;
	}

	public String getMsg() {
		return text;
	}

}
