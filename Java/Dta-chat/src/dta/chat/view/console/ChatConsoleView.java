package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleView extends ViewComposite {

	public ChatConsoleView(Scanner sc) {
		this.views.add(new ChatConsoleTitleView());
		this.views.add(new ChatConsoleLoginView(sc));
		this.views.add(new ChatConsoleConversationView(sc));
	}

}
