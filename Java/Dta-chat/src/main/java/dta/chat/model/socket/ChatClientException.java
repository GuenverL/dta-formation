package dta.chat.model.socket;

public class ChatClientException extends Exception {

	private static final long serialVersionUID = 1L;

	public ChatClientException(String error, Throwable throwable) {
		super(error, throwable);
	}
}
