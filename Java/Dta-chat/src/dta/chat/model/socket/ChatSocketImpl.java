package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket{
	private ClientSocket client;

	public ChatSocketImpl(String ip) throws ChatClientException {
		try {
			client = new ClientSocket(ip, 1800);
		} catch (IOException e) {
			throw new ChatClientException("creation problem", e);
		}
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			client.sendObject(msg);
		} catch (IOException e) {
			throw new ChatClientException("read problem", e);
		}

	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		try {
			return (ChatMessage) client.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new ChatClientException("read problem", e);
		}

	}

	@Override
	public void close() throws Exception {
		client.close();
	}
	
}
