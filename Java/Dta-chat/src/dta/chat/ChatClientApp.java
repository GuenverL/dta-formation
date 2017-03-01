package dta.chat;

import java.util.Scanner;

import dta.chat.model.observer.ChatConversationModel;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			ChatConversationModel model = new ChatConversationModel();
			final ChatConsoleView view = new ChatConsoleView(sc);
			view.setAuthController((login) -> {
				model.setLogin(login);
			});

			model.addObserver(view);

			view.print();

			model.sendMessage("Bonjour");
			model.sendMessage("C'est moi !");
		}
	}
}
