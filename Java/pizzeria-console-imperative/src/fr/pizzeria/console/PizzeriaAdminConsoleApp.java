package fr.pizzeria.console;

import java.util.*;

public class PizzeriaAdminConsoleApp {
	public static void main(String args[]){		
		Scanner sc = new Scanner(System.in);
		
		int choix = 0; 
		int indice = 0;

		String[] nouvellePizza = new String[3];
		
		String[][] pizzas = {	{"PEP","Pépéroni",		"12.50"},
								{"MAR","Margherita",	"14.00"},
								{"REI","La Reine",		"11.50"},
								{"FRO","La 4 Fromages",	"12.00"},
								{"CAN","La cannibale",	"12.50"},
								{"SAV","La savoyarde",	"13.00"},
								{"ORI","L'orientale",	"13.50"},
								{"IND","L'indienne",	"14.50"}};
		
		int taille = pizzas.length;

		System.out.println("\n***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. sortir");
		
		
		while( (choix = sc.nextInt())!= 99 ){			
			
			switch(choix){
				case 1:
					System.out.println("\n");
					
					for(String[] pizza : pizzas){
						System.out.println(pizza[0]+" -> "+pizza[1]+" ("+pizza[2]+")");
					}
					
					break;
				case 2:				
					System.out.println("Veuiller saisir le code");
					nouvellePizza[0] = sc.nextLine(); 
					System.out.println("Veuiller saisir le nom (sans espace)");
					nouvellePizza[1] = sc.nextLine(); 		
					System.out.println("Veuiller saisir le prix");
					nouvellePizza[2] = sc.nextLine(); 
					
					String[][] pizzass = Arrays.copyOf(pizzas,taille+1);
					pizzass[taille]=nouvellePizza;
					pizzas = pizzass;
					taille++;
					break;
					
				case 3:
					for(String[] pizza : pizzas){
						System.out.println(pizza[0]+" -> "+pizza[1]+" ("+pizza[2]+")");
					}					
					
					System.out.println("Veuiller choisir la pizza à modifier.\n(99 pour abandonner).");		
					
					if ((indice = sc.nextInt()) == 99){
						break;
					}
					
					System.out.println("Veuiller saisir le code");
					nouvellePizza[0] = sc.nextLine(); 
					System.out.println("Veuiller saisir le nom (sans espace)");
					nouvellePizza[1] = sc.nextLine(); 		
					System.out.println("Veuiller saisir le prix");
					nouvellePizza[2] = sc.nextLine(); 
					
					pizzas[indice]=nouvellePizza;	
					
					break;
					
				case 4:
					String[][] nouvellesPizzas = new String[taille-1][3];
					for(String[] pizza : pizzas){
						System.out.println(pizza[0]+" -> "+pizza[1]+" ("+pizza[2]+")");
					}					
					
					System.out.println("Veuiller choisir la pizza à supprimer.\n(99 pour abandonner).");		
					
					if ((indice = sc.nextInt()) == 99){
						break;
					} 
					
					
					System.arraycopy(pizzas, 0, nouvellesPizzas, 0, indice);
					System.arraycopy(pizzas, indice+1, nouvellesPizzas, indice, taille-1-indice);
					pizzas = nouvellesPizzas;
					taille--;
					break;					
			}
			
			System.out.println("\n***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. sortir");
			
		}
		sc.close();
	}
	
	private static String[][] MajPizza(Scanner sc, String[][] pizzas){
		sc.nextLine();
			
		
		return pizzas;
		
	}
	
}
