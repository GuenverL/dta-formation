package dta.chat.view.console;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatConsoleTitleView extends ViewComposite {
	@Override
	public void print() {
		System.out.println("= CHAT APP =");
	}

	@Override
	public void update(ChatObservable<ChatMessage> obs, ChatMessage msg) {
		// TODO Auto-generated method stub

	}

}
