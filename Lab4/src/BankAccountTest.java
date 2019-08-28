
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 4
 * Date: February 16, 2019
 */

import java.util.Random;

/**
 * This class instantiates 3 chequing accounts and 2 saving accounts. Runs the
 * monthlyProcess and displays each; simulating a year of transactions.
 * 
 * @author Patrick Czermak
 * @version 1.0
 * @since JDK 1.8
 *
 */
public class BankAccountTest {
	/**
	 * Array "accounts" where all bank accounts are stored, both savings and chequing.
	 */
	protected BankAccount[] accounts;
	/**
	 * Random utilized in default constructor to generate balance for all accounts
	 * between($20 - $100), fee for Chequing accounts between($1 - $5), and interest
	 * rate for Savings accounts between (%.02 - %.10).
	 */
	private Random rand;

	/**
	 * Default Constructor which creates and initializes 3 chequing account arrays,
	 * and 2 savings account arrays. Randomly generated default balance for each
	 * account between($20 - $100). Randomly generated fee for Chequing Accounts
	 * between($1 - $5). Randomly generated interest rate for Savings Accounts
	 * between (%.02 - %.10).
	 * 
	 */
	public BankAccountTest() {
		rand = new Random();
		accounts = new BankAccount[5];
		accounts[0] = new ChequingAccount(rand.nextDouble() * 4 + 1, rand.nextDouble() * 80 + 20);
		accounts[1] = new ChequingAccount(rand.nextDouble() * 4 + 1, rand.nextDouble() * 80 + 20);
		accounts[2] = new ChequingAccount(rand.nextDouble() * 4 + 1, rand.nextDouble() * 80 + 20);
		accounts[3] = new SavingsAccount(rand.nextDouble() * 0.08 + 0.02, rand.nextDouble() * 80 + 20);
		accounts[4] = new SavingsAccount(rand.nextDouble() * 0.08 + 0.02, rand.nextDouble() * 80 + 20);
	}

	/**
	 * METHOD monthlyProcess which uses a enhanced for-loop to go through @accounts
	 * array indices and call calculateAndUpdateBalance method on each array.
	 * calculateAndUpdateBalance is an abstract method within class BankAccount, and
	 * within classes ChequingAccount and SavingsAccount these methods are
	 * "overridden". The calculateAndUpdateBalance logic is taken from either
	 * ChequingAccount or SavingsAccount.
	 * 
	 * @param accounts - Array of bank accounts to calculate and update balances.
	 * @returns void.
	 */
	public void monthlyProcess(BankAccount[] accounts) {
		for (BankAccount tempAccount : accounts) { // for each "BankAccount", calling them "tempAccount", in "accounts"
													// array...
			tempAccount.calculateAndUpdateBalance(); // run calculateAndUpdateBalance accordingly.
		}
	}

	/**
	 * METHOD to display the balance of each account. Enhanced for-loop used to pass
	 * through the entire @accounts array and displays via the toString methods held
	 * in class "BankAccount".
	 * 
	 * @param accounts - Array of bank accounts to display information.
	 * @return void.
	 */
	public void display(BankAccount[] accounts) {
		for (BankAccount tempAccount : accounts) { // for each "BankAccount", calling them "tempAccount", in "accounts"
													// array...
			System.out.println(tempAccount.toString()); // print out the accounts information.
		}
	}

	/**
	 * MAIN which calls "monthlyProcess" and "display" methods 12 times within a
	 * for-loop to simulate one year of processes and displays. The loop adds a
	 * header for each month with the corresponding interval number, and a line
	 * separating each month. Simulates 12 months of Bank Account transactions.
	 * 
	 * @param args UNUSED - command line arguments.
	 */
	public static void main(String[] args) {
		BankAccountTest bankAccTest = new BankAccountTest();
		System.out.println(" ACCOUNTS OPENED INITIALLY WITH THE FOLLOWING INFO: ");
		bankAccTest.display(bankAccTest.accounts);
		for (int i = 0; i < 12; i++) {
			System.out.println("_____________________________________________________________________________");
			System.out.println(" MONTH:" + (i + 1));
			bankAccTest.monthlyProcess(bankAccTest.accounts);
			bankAccTest.display(bankAccTest.accounts);
		}
	}
}
