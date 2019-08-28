
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 5/Assignment 1
 * Date: March 3, 2019
 */

import java.util.Scanner;

/**
 * The purpose of Bank class is to add an account of either Savings or Chequing
 * to the Bank. Displays one account separately or all accounts in the Bank at
 * once. Updates accounts with either deposit or withdraw transactions.
 * 
 * @author Patrick Czermak
 * @version 1
 * @since JDK 1.8
 */
public class Bank {
	/**
	 * private static variable accounts is an array of BankAccounts. It holds all of
	 * the created accounts.
	 */
	private static BankAccount[] accounts;
	/**
	 * private static int variable numAccounts holds the number of accounts within
	 * the bank.
	 */
	private static int numAccounts = 0;
	/**
	 * private int variable maxSize holds the maximum size of accounts that the bank
	 * can hold.
	 */
	private int maxSize = 0;
	/**
	 * private Scanner variable input is used to get user input from keyboard within
	 * Bank Class.
	 */
	private Scanner input;

	/**
	 * Constructor which initializes maxSize variable to 1000, and BankAccount array
	 * to the size of maxSize.
	 */
	public Bank() {
		maxSize = 1000;
		accounts = new BankAccount[maxSize];
	}

	/**
	 * Parameterized Constructor which defines the Bank to have a maxSize.
	 * 
	 * @param maxSize holds the maximum size of accounts that the bank can hold.
	 */
	public Bank(int maxSize) {
		this.maxSize = maxSize;
		accounts = new BankAccount[maxSize];
	}

	/**
	 * Method addAccount adds either a Savings or Chequing account to the @accounts
	 * array.
	 * 
	 * @return true when accounts have been properly initialized as either Savings
	 *         or Chequing.
	 */
	public boolean addAccount() {
		input = new Scanner(System.in);
		String accountType;
		boolean menuOption = false;

		if (numAccounts >= maxSize) {
			System.out.println("ERROR...Bank is full!");
		} else {
			System.out.println("Enter details of account holder " + (numAccounts + 1));
			System.out.println("=================================");

			while (!menuOption) {
				System.out.println("Enter account type (s for savings, c for checking):");
				accountType = input.next().toLowerCase();

				// Validation of account type input.
				if (accountType.equals("s")) {
					menuOption = true;
					accounts[numAccounts] = new SavingsAccount();
				} else if (accountType.equals("c")) {
					menuOption = true;
					accounts[numAccounts] = new ChequingAccount();
				} else {
					menuOption = false;
					System.out.println("INVALID...please select a valid menu option!");
				}
			}
			if (accounts[numAccounts].addBankAccount()) {
				numAccounts++;
			} else {
				System.out.println("INVALID...Account number is already in use!");
			}
		}
		return false;
	}

	/**
	 * Method displayAccount displays account information through calling
	 * findAccount() method in current class. Checks first to make sure @accounts
	 * array index isn't negative or prints an error.
	 */
	public void displayAccount() {
		int accountIndex = findAccount();

		if (accountIndex >= 0) {
			System.out.println(accounts[accountIndex]);
		} else {
			System.out.println("ERROR...account doesn't exist!");
		}
	}

	/**
	 * Method printAccountDetails prints all accounts in @accounts array, utilizes
	 * the toString() method to ensure proper account information is printed for
	 * each account.
	 */
	public void printAccountDetails() {
		System.out.println();
		System.out.println("\nBanking System");
		System.out.println("*********************");
		System.out.println("Number of Account Holders: " + numAccounts);
		for (int i = 0; i < numAccounts; i++) {
			System.out.println(accounts[i].toString());
		}
	}

	/**
	 * Method updateAccount performs either deposit or withdraws on the specified
	 * account based on if user enters a positive or negative number (positive for
	 * deposit, negative for withdraw).
	 */
	public void updateAccount() { //
		input = new Scanner(System.in);
		double amount = 0.0;
		BankAccount account = null;

		int accountIndex = findAccount(); // if account number exists...continue.

		if (accountIndex >= 0) {
			account = accounts[accountIndex];
			System.out.println("Enter amount to deposit/withdraw (positive to deposit, negative to withdraw): ");
			// Validation of deposit/withdraw amount.
			boolean goodAmount = false;
			while (!goodAmount) {
				goodAmount = true;
				if (!input.hasNextDouble()) { // ensure amount is a double value.
					System.out.println("INVALID...amount must be in number form! Please re-enter amount:");
					input.next();
					goodAmount = false;
					continue;
				}
				amount = input.nextDouble();
			}
			if (amount > 0) { // deposits successfully if amount is greater than zero.
				account.balance = account.balance + amount;
				System.out.println("Successfully deposited!");
			} else if (amount < 0) { // withdraws successfully if amount is less than zero.
				account.balance = account.balance - (amount * -1); // converts negative amount to positive to ensure
																	// amount is properly deducted from balance.
				if (account.balance < 0) { // ensures balance doesn't go into a negative balance.
					System.out.println("ERROR...insufficient funds!");
				} else
					System.out.println("Successfully withdrawn!");
			}

		} else { // if the account number specified doesn't exist print error
			System.out.println("ERROR...account doesn't exist!");
		}
	}

	/**
	 * Method findAccount validates user inputed account number.
	 * 
	 * @return Bank.findAccount(accountNumber) where findAccount(accountNumber) is
	 *         validated for uniqueness.
	 */
	public int findAccount() {
		input = new Scanner(System.in);
		System.out.println("Enter Account number: ");
		// Validation of account number input.
		boolean goodAccountNumber = false;
		int accountNumber = 0;
		while (!goodAccountNumber) {
			goodAccountNumber = true;
			if (!input.hasNextInt()) { // ensure account number is only a number.
				System.out.println("INVALID...Account number must be a number! Please re-enter Account number:");
				input.next();
				goodAccountNumber = false;
				continue;
			}
			accountNumber = input.nextInt();
			if (accountNumber <= 0 || accountNumber > 99999999) { // ensure account number is minimum 1 number or
																	// maximum 8 numbers long.
				System.out.println("INVALID...Account number must be between 1 and 8 numbers long! Please"
						+ " re-enter Account number:");
				goodAccountNumber = false;
				continue;
			}
		}
		return Bank.findAccount(accountNumber);

	}

	/**
	 * Method static findAccount(int accountNumber) is overloaded which takes input
	 * instead of asking for it. Used when adding a new account.
	 * 
	 * @param accountNumber a specific account number in the @accounts array.
	 * @return -1 or the index of the account
	 */
	public static int findAccount(int accountNumber) {
		for (int i = 0; i < numAccounts; i++) {
			// check if the current account is null so know are at
			// end of the initialized accounts in the array
			if (accounts[i] != null) {
				if (accounts[i].accountNumber == accountNumber) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Method monthlyUpdate updates all accounts in the @accounts array.
	 */
	public void monthlyUpdate() {
		for (int i = 0; i < accounts.length; i++) { // loop through every account in accounts array that is there,
			if (accounts[i] != null) { // if the array index is not empty,
				accounts[i].monthlyAccountUpdate(); // run monthlyAccountUpdate appropriately on each account.
			}
		}
	}
}
