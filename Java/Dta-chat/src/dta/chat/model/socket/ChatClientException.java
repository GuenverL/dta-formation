package dta.chat.model.socket;

public class ChatClientException extends Exception {

	public ChatClientException(String error, Throwable throwable) {
		super(error, throwable);
	}
}
