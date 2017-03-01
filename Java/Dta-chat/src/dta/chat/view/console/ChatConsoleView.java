package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleView extends ViewComposite {

	public ChatConsoleView(Scanner sc) {
		this.add(new ChatConsoleTitleView());
		this.add(new ChatConsoleLoginView(sc));
		this.add(new ChatConsoleConversationView(sc));
	}

	/*
	 * @Override public void update(ChatObservable<ChatMessage> obs, ChatMessage
	 * msg) { super }
	 */

}
