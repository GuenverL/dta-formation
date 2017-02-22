package fr.pizzeria;

import java.util.Scanner;

public class Pizzeria {
	public static void main(String args[]) {
		Menu menu = new Menu();
		menu.afficher();

		Scanner sc = new Scanner(System.in);

		int choix = sc.nextInt();

		while (choix != 99) {
			menu.faire(choix);
			choix = sc.nextInt();
		}

		sc.close();
	}
}
