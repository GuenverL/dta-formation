package dta.chat.model.socket;

public class ChatSocketProxy {
	private ChatSocket socket;

	public ChatSocketProxy(String ip, int port) throws ChatClientException {
		this.socket = new ChatSocketImpl(ip, port);
	}
}
