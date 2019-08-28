
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 6
 * Date: March 17, 2019
 */

import java.util.Scanner;

/**
 * The purpose of Assign1 class is to hold method main, which has the user menu
 * options. Each option calls the appropriate method from Bank class.
 * 
 * @author Patrick Czermak
 * @version 1.1
 * @since JDK 1.8
 *
 */
public class Assign1 {

	/**
	 * Default Constructor
	 */
	public Assign1() {

	}

	/**
	 * Method main holds the user menu for the program. Each menu option calls a
	 * method from Bank class to execute.
	 * 
	 * @param args UNUSED - command line arguments.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Bank bank = new Bank(); 
		String employeeOption = null;
		boolean quit = false;

		while (!quit) {
			quit = false;
			System.out.println("--- MENU OPTIONS --- \n" + "a: Add new account \n" + "u: Update an account \n" +
					"d: Display an account \n"	+ "p: Print all accounts \n" + "m: Run monthly update \n" + 
					"q: Quit");
			System.out.println("Enter your option :");
			employeeOption = input.next();

			switch (employeeOption.toLowerCase()) {
			case "a":
				bank.addAccount();
				break;
			case "u":
				bank.updateAccount();
				break;
			case "d":
				bank.displayAccount();
				break;
			case "p":
				bank.printAccountDetails();
				break;
			case "m":
				bank.monthlyUpdate();
				break;
			case "q":
				System.out.println("You have successfully exited!");
				quit = true;
				break;
			default:
				System.out.println("ERROR...invalid menu option!");
				break;
			}
		}
		input.close(); // closes the scanner input.
	}
}
