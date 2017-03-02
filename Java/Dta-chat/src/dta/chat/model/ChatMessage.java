package dta.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	private String login;
	private String msg;

	public ChatMessage(String login, String msg) {
		this.login = login;
		this.msg = msg;
	}

	public String getLogin() {
		return login;
	}

	public String getMsg() {
		return msg;
	}

}
