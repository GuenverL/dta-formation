package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket{
	private ClientSocket client;

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			client.sendObject(msg);
		} catch (IOException e) {
			throw new ChatClientException();
		}

	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		try {
			return ((ChatMessage) client.readObject());
		} catch (ClassNotFoundException | IOException e) {
			throw new ChatClientException();
		}

	}

	@Override
	public void close() throws Exception {

	}
	
}
