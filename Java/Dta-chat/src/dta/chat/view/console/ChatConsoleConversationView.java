package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatConsoleConversationView extends ViewComposite {

	Scanner sc;

	public ChatConsoleConversationView(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void print() {
		System.out.println("== Conversations ==");
	}

	@Override
	public void update(ChatObservable<ChatMessage> obs, ChatMessage msg) {
		System.out.println(msg.getLogin() + " : " + msg.getMsg());
	}
}
