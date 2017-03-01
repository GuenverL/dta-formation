package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleConversationView extends ViewComposite {

	Scanner sc;

	public ChatConsoleConversationView(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void print() {
		System.out.println("== Conversations ==");
		while (true) {
			if (sc.nextLine().equals("exit"))
				break;
		}
	}

}
