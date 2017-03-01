package dta.chat.view.console;

public class ChatConsoleView extends ViewComposite {

	public ChatConsoleView() {
		this.views.add(new ChatConsoleTitleView());
		this.views.add(new ChatConsoleLoginView());
		this.views.add(new ChatConsoleConversationView());
	}

}
