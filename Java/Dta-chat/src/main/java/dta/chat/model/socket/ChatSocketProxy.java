package dta.chat.model.socket;

public class ChatSocketProxy {
	@SuppressWarnings("resource")
	public ChatSocketProxy(String ip, int port) throws ChatClientException {
		new ChatSocketImpl(ip, port);
	}
}
