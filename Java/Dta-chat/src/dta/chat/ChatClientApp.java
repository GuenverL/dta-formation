package dta.chat;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dta.chat.model.ChatConversationModel;
import dta.chat.model.socket.ChatClientException;
import dta.chat.model.socket.ChatSocketImpl;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) throws ChatClientException {

		try (Scanner sc = new Scanner(System.in)) {
			ChatConversationModel model;
			model = new ChatConversationModel(new ChatSocketImpl("192.168.99.31"));

			final ChatConsoleView view = new ChatConsoleView(sc);
			ExecutorService es = Executors.newFixedThreadPool(1);

			view.setAuthController((login) -> {
				model.setLogin(login);
			});

			model.addObserver(view);
			view.print();
			es.execute(() -> {
				while (true) {
					try {
						model.readMessage();
					} catch (ChatClientException e) {
						e.printStackTrace();
					}
				}
			});

			String msg = sc.nextLine();
			while (true) {
				model.sendMessage(msg);
				msg = sc.nextLine();
				if(msg.equals("exit")){
					es.shutdown();
					break;
				}
			}

			try {
				model.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
