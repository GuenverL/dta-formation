package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {
	public static void main(String args[]){
		int n1, n2;
		System.out.println("*****  Application Opérateurs *****\nVeuillez saisir le premier nombre...");
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();
		sc.nextLine();
		System.out.println("Veuillez saisir le second nombre...");
		n2 = sc.nextInt();
		System.out.println(n1+" + "+n2+" = "+(n1+n2));
		System.out.println(n1+" - "+n2+" = "+(n1-n2));
		System.out.println(n1+" * "+n2+" = "+(n1*n2));
		System.out.println(n1+" / "+n2+" = "+(n1/n2));
		System.out.println(n1+" % "+n2+" = "+(n1%n2));
		sc.close();
	}
}
