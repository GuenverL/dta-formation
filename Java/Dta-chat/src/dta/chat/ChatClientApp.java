package dta.chat;

import java.util.Scanner;

import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			final ChatConsoleView view = new ChatConsoleView(sc);
			view.setAuthController((login) -> {
				view.setLogin(login);
			});
			view.print();
		}
	}
}
