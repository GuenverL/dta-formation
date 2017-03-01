package dta.chat.model;

import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatClientException;
import dta.chat.model.socket.ChatSocket;

public class ChatConversationModel extends ChatObservable<ChatMessage> implements ChatSocket {
	private String login;
	public void setLogin(String login) {
		this.login = login;
		notifyObservers(new ChatMessage("Welcome", login));
	}


	public void sendMessage(String msg) {
		notifyObservers(new ChatMessage(login, msg));
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		// TODO Auto-generated method stub
		return null;
	}
}
