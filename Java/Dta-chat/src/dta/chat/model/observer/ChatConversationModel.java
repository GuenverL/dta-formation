package dta.chat.model.observer;

import dta.chat.model.ChatMessage;

public class ChatConversationModel extends ChatObservable<ChatMessage> {
	private String login;
	public void setLogin(String login) {
		this.login = login;
		notifyObservers(new ChatMessage("Welcome", login));
	}

	public void sendMessage(String msg) {
		notifyObservers(new ChatMessage(login, msg));
	}
}
