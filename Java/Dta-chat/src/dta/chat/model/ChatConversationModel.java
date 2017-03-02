package dta.chat.model;

import dta.chat.history.HistoryFacade;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatClientException;
import dta.chat.model.socket.ChatSocket;

public class ChatConversationModel extends ChatObservable<ChatMessage> implements ChatSocket {
	private ChatSocket socket;
	private String login;
	private HistoryFacade histo = new HistoryFacade();

	public ChatConversationModel(ChatSocket socket) {
		this.socket = socket;
	}

	public void setLogin(String login) throws ChatClientException {
		this.login = login;
		notifyObservers(new ChatMessage("Welcome", login));
		histo.findLastMessages().forEach(msg -> System.out.println(msg.getLogin() + " : " + msg.getMsg()));
	}


	public void sendMessage(String msg) throws ChatClientException {
		ChatMessage cmsg = new ChatMessage("\033[35m" + login + "\033[0m", msg);
		try {
			this.sendMessage(cmsg);
		} catch (ChatClientException e) {
			throw new ChatClientException("Message sending error", e);
		}
	}

	@Override
	public void close() throws Exception {
		socket.close();
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		socket.sendMessage(msg);
		histo.saveMessage(msg);
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		ChatMessage msg = socket.readMessage();
		histo.saveMessage(msg);
		notifyObservers(msg);
		return msg;
	}
}
