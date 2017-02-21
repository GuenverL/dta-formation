package fr.pizzeria.console;

import java.util.*;

public class PizzeriaAdminConsoleApp {
	public static void main(String args[]){		
		Scanner sc = new Scanner(System.in);
		
		String[][] pizzas = {	{"PEP","Pépéroni",		"12.50"},
								{"MAR","Margherita",	"14.00"},
								{"REI","La Reine",		"11.50"},
								{"FRO","La 4 Fromages",	"12.00"},
								{"CAN","La cannibale",	"12.50"},
								{"SAV","La savoyarde",	"13.00"},
								{"ORI","L'orientale",	"13.50"},
								{"IND","L'indienne",	"14.50"}};

		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. sortir\n");
		
		int choix = 0; 
		
		while( (choix = sc.nextInt())!= 99 ){			
			
			switch(choix){
				case 1:
					AfficherPizzas(pizzas);
					break;
				case 2:
					pizzas = AjouterPizza(pizzas);
					break;
			}
			
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. sortir\n");
			
		}
	}
	
	private static void AfficherPizzas(String[][] pizzas){
		for(String[] pizza : pizzas){
			System.out.println(pizza[0]+" -> "+pizza[1]+" ("+pizza[2]+")1");
		}
	}
	
	private static String[][] AjouterPizza(String[][] pizzas){
		Scanner sc = new Scanner(System.in);
		int taille = pizzas.length;
		String[] pizza = new String[3];
		
		System.out.println("Veuiller saisir le code");
		pizza[0] = sc.nextLine(); 
		System.out.println("Veuiller saisir le nom (sans espace)");
		pizza[1] = sc.nextLine(); 		
		System.out.println("Veuiller saisir le prix");
		pizza[2] = sc.nextLine(); 
		
		String[][] pizzass = Arrays.copyOf(pizzas,taille+1);
		pizzass[taille]=pizza;
		
		sc.close();
		
		return pizzass;
	}
	
	
	
}
