package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleLoginView extends ViewComposite {
	Scanner sc;

	public ChatConsoleLoginView(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void print() {
		System.out.println("==Authentification ==");
		System.out.print("Veuillez saisir cotre login : ");
		String saisie = sc.nextLine();
		this.authController.authenticate(saisie);
	}

}
