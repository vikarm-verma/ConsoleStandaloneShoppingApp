package bean;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveWhileIteratingArrayList {

	static ArrayList<String> a1 = new ArrayList<>();
	static ArrayList<String> a2 = new ArrayList<>();
	static String choice = "";

	static void adda1() {
		a1.add("1");
		a1.add("2");
		a1.add("1");
		a1.add("3");
		a1.add("1");
	}

	static void visita1() {
		// iterating ArrayList using enhanced for-loop
		for (String star : a1) {
			System.out.println(star);
		}
	}
	static void enterChoice() {
		
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.println("==enter no===");
		choice = s.next();
		if(choice.equals("1"))
		a1.remove(choice);
	}



	static void visita1Again() {
		for (String star : a1) {
			System.out.println(star);
		}
	}


	public static void main(String[] args) {
		System.out.println("adding into list \n");
		adda1();
		System.out.println("vising a1 first time \n");
		visita1();
		System.out.println("\n");
		enterChoice();
		System.out.println("vising a1 again \n");
		visita1Again();

	}

}