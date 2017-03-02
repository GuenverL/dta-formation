package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket{
	private ClientSocket client;

	public ChatSocketImpl() {
		try {
			client = new ClientSocket("localhost", 1800);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
			return (ChatMessage) client.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new ChatClientException();
		}

	}

	@Override
	public void close() throws Exception {

	}
	
}
