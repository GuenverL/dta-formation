package dta.chat.model;

import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatClientException;
import dta.chat.model.socket.ChatSocket;

public class ChatConversationModel extends ChatObservable<ChatMessage> implements ChatSocket {
	private ChatSocket socket;
	private String login;

	public ChatConversationModel(ChatSocket socket) {
		this.socket = socket;
	}

	public void setLogin(String login) {
		this.login = login;
		notifyObservers(new ChatMessage("Welcome", login));
	}


	public void sendMessage(String msg) {
		ChatMessage cmsg = new ChatMessage(login, msg);
		notifyObservers(cmsg);
		try {
			this.sendMessage(cmsg);
		} catch (ChatClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws Exception {
		socket.close();

	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		socket.sendMessage(msg);

	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		return socket.readMessage();
	}
}
