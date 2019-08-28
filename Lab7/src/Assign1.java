
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 7
 * Date: March 31, 2019
 */

import java.util.Scanner;

/**
 * The purpose of Assign1 class is to hold method main, which has the user menu
 * options. Each menu option calls the appropriate method from Bank class.
 * 
 * @author Patrick Czermak
 * @version 1.2
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
			System.out.println("--- MENU OPTIONS ---\n" + "A: Add new account\n" + "D: Deposit into account\n"
					+ "W: Withdraw from account\n" + "E: Exhibit/Display an account\n" + "P: Print all accounts\n"
					+ "M: Run monthly update\n" + "R: Read records\n" + "Q: Quit");
			System.out.println("Enter your option :");
			employeeOption = input.nextLine();

			switch (employeeOption.toLowerCase()) {

			case "a":
				bank.addAccount();
				break;

			case "d":
				bank.deposit();
				break;

			case "w":
				bank.withdraw();
				break;

			case "e":
				bank.displayAccount();
				break;

			case "p":
				bank.printAccountDetails();
				break;

			case "m":
				bank.monthlyUpdate();
				break;

			case "r":
				bank.readRecords();
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
