
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 7
 * Date: March 31, 2019
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.lang.SecurityException;

/**
 * The purpose of Bank class is to add an account of either Savings or Chequing
 * to the Bank. Displays one account separately or all accounts in the Bank at
 * once. Updates accounts with either deposit or withdraw transactions. Locates
 * Bank Accounts from within the @accounts ArrayList. Performs monthly updates
 * on all Bank Accounts in the @accounts ArrayList. Opens, reads, and closes an
 * input text file. Creates, opens, and closes and output text file.
 * 
 * @author Patrick Czermak
 * @version 1.2
 * @since JDK 1.8
 */
public class Bank {
	/**
	 * private static variable accounts is a dynamic ArrayList of BankAccounts. It
	 * holds all of the accounts.
	 */
	private static ArrayList<BankAccount> accounts;

	/**
	 * private Scanner variable input is used to get user input from keyboard within
	 * Bank Class.
	 */
	private Scanner input;

	/**
	 * private Scanner variable inputFile is used to take input information from a
	 * text file.
	 */
	private Scanner inputFile;

	/**
	 * private Formatter variable is used to write information into a text file.
	 */
	private Formatter fileOutput;

	/**
	 * Constructor which initializes accounts to a Bank Account in the ArrayList.
	 */
	public Bank() {
		accounts = new ArrayList<BankAccount>();
	}

	/**
	 * Method addAccount adds either a Savings or Chequing account to the @accounts
	 * ArrayList.
	 * 
	 * @return true when accounts have been properly initialized as either Savings
	 *         or Chequing.
	 */
	public boolean addAccount() {
		input = new Scanner(System.in);
		String accountType;
		boolean menuOption = false;

		System.out.println("Enter details of account holder " + (accounts.size() + 1));
		System.out.println("=================================");

		while (!menuOption) {
			System.out.println("Enter account type (s for savings, c for checking):");
			accountType = input.next().toLowerCase();

			// Validation of account type input.
			if (accountType.equals("s")) {
				menuOption = true;
				accounts.add(new SavingsAccount()); // utilizes ArrayList class .add() method to properly update
													// accounts with a SavingsAccount.
			} else if (accountType.equals("c")) {
				menuOption = true;
				accounts.add(new ChequingAccount()); // utilizes ArrayList class .add() method to properly update
														// accounts with a ChequingAccount.
			} else {
				menuOption = false;
				System.out.println("INVALID...please select a valid menu option!");
			}
		}
		if (!accounts.get(accounts.size() - 1).addBankAccount()) { // Utilizes ArrayList class .get() method to find a
																	// specific index. And .size() method
																	// to get the total size of ArrayList.
			System.out.println("INVALID...Account number is already in use!");
		}
		return false;
	}

	/**
	 * Method displayAccount displays account information through calling
	 * findAccount() method in current class. Checks first to make sure @accounts
	 * ArrayList index isn't negative or prints an error.
	 */
	public void displayAccount() {
		int accountIndex = findAccount();

		if (accountIndex >= 0) {
			System.out.println(accounts.get(accountIndex));
		} else {
			System.out.println("ERROR...account doesn't exist!");
		}
	}

	/**
	 * Method printAccountDetails prints all accounts in @accounts ArrayList to the
	 * console and to an output text file, catches securityException and
	 * formatterClosedException when outputting to a text file. Utilizes the
	 * toString() method to ensure proper account information is printed for each
	 * account.
	 */
	public void printAccountDetails() {
		System.out.println("\n\nBanking System");
		System.out.println("*********************");
		System.out.println("Number of Account Holders: " + accounts.size());

		// ensures accounts printed to console before trying to print to file.
		for (BankAccount acc : accounts) {
			System.out.println(acc.toString());
		}

		try {
			openOutputFile(); // calls openOutputFile method

			for (BankAccount acc : accounts) {

				if (acc instanceof ChequingAccount) {
					fileOutput.format("%s%n", acc.toString());

				} else if (acc instanceof SavingsAccount) {
					fileOutput.format("%s%n", acc.toString());
				}
			}
		} catch (SecurityException securityException) {
			System.out.println(securityException.toString());

		} catch (FormatterClosedException formatterClosedException) {
			System.out.println(formatterClosedException.toString());

		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println(fileNotFoundException.toString() + " Unable to write bank record(s) to file!");

		}

		closeOutputFile();

	}

	/**
	 * Method deposit performs a deposit on a specified account accurately, catches
	 * all exceptions.
	 */
	public void deposit() {
		input = new Scanner(System.in);
		double amount = 0.0;
		BankAccount account = null;

		int accountIndex = findAccount(); // if account number exists...continue.
		if (accountIndex >= 0) {
			account = accounts.get(accountIndex);
			System.out.println("Enter amount to deposit: ");
			// Validation of deposit amount.
			boolean goodDepositAmount = false;
			while (!goodDepositAmount) {
				goodDepositAmount = true;
				if (!input.hasNextDouble()) { // ensure amount is a double value.
					System.out.println("INVALID...amount must be in number form! Please re-enter amount:");
					input.next();
					goodDepositAmount = false;
					continue;
				}
				amount = input.nextDouble();

				try { // try to deposit the amount
					account.deposit(amount);

				} catch (Exception allExceptions) { // catch any error exceptions
					System.out.println(allExceptions);
				}
			}
		} else { // if the account number specified doesn't exist print error
			System.out.println("ERROR...account doesn't exist!");
		}

	}

	/**
	 * Method withdraw performs a withdrawal on a specified account accurately,
	 * catches all exceptions.
	 */
	public void withdraw() {
		input = new Scanner(System.in);
		double amount = 0.0;
		BankAccount account = null;

		int accountIndex = findAccount(); // if account number exists...continue.
		if (accountIndex >= 0) {
			account = accounts.get(accountIndex);
			System.out.println("Enter amount to withraw: ");
			// Validation of withdraw amount.
			boolean goodWithdrawAmount = false;
			while (!goodWithdrawAmount) {
				goodWithdrawAmount = true;
				if (!input.hasNextDouble()) {
					System.out.println("INVALID...amount must be in number form! Please re-enter amount:");
					input.next();
					goodWithdrawAmount = false;
					continue;
				}
				amount = input.nextDouble();

				try { // try to withdraw amount
					account.withdraw(amount);

				} catch (Exception allExceptions) { // catch error exceptions
					System.out.println(allExceptions);
				}
			}
		} else { // if the account number specified doesn't exist print error
			System.out.println("ERROR...account doesn't exist!");
		}
	}

	/**
	 * Method findAccount() validates user inputed account number.
	 * 
	 * @return Bank.findAccount(accountNumber) where findAccount(accountNumber) is
	 *         validated for uniqueness.
	 */
	public int findAccount() {
		input = new Scanner(System.in);
		System.out.println("Enter Account number: ");

		// Validation of account number input.
		boolean goodAccountNumber = false;
		long accountNumber = 0;
		while (!goodAccountNumber) {
			goodAccountNumber = true;
			if (!input.hasNextLong()) { // ensure account number is only a number.
				System.out.println("INVALID...Account number must be a number! Please re-enter Account number:");
				input.next();
				goodAccountNumber = false;
				continue;
			}
			accountNumber = input.nextLong();
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
	 * @param accountNumber a specific account number in the @accounts ArrayList.
	 * @return -1 or the index of the account
	 */
	public static int findAccount(long accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).accountNumber == accountNumber) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Method monthlyUpdate performs an update on all accounts in the @accounts
	 * ArrayList.
	 */
	public void monthlyUpdate() {
		for (BankAccount acc : accounts) {
			acc.monthlyAccountUpdate();
		}
	}

	/**
	 * Method openInputFile opens the text file "bankinput.txt". Catches an
	 * IO(input/Output) Exception and prints and error statement if unable to open
	 * the file.
	 */
	public void openInputFile() {
		try {
			inputFile = new Scanner(Paths.get("bankinput.txt"));

		} catch (IOException ioException) {
			System.out.println("ERROR...during opening file. Terminated!");

		}

	}

	/**
	 * Method readRecords reads and formats information from the text file
	 * bankinput.txt, and creates either a new Chequing or Savings Account in the
	 * 
	 * @accounts ArrayList. Catches NoSuchElementException and IllegalStateException
	 *           when file is not properly formed or an error reading from the file.
	 */
	public void readRecords() {

		openInputFile();
		try {
			while (inputFile.hasNext()) {
				double random = new Random().nextDouble();

				if (inputFile.next().equals("C")) {
					String firstName = inputFile.next();
					String lastName = inputFile.next();
					Long accountNumber = inputFile.nextLong();
					String emailAddress = inputFile.next();
					Double balance = inputFile.nextDouble();
					double fee = 5.00 + (random * (10.00 - 5.00));

					if (findAccount(accountNumber) == -1) { // ensures no duplicate chequing accounts added to
															// BankAccount ArrayList
						accounts.add(new ChequingAccount(accountNumber, balance, fee));
						accounts.get(accounts.size() - 1).accHolder = new Client(firstName, lastName, emailAddress);
					}

				} else if (inputFile.next().equals("S")) {
					String firstName = inputFile.next();
					String lastName = inputFile.next();
					Long accountNumber = inputFile.nextLong();
					String emailAddress = inputFile.next();
					Double balance = inputFile.nextDouble();
					double interestRate = 0.00 + (random * (1.00 - 0.00));
					Double minimumBalance = inputFile.nextDouble();

					if (findAccount(accountNumber) == -1) { // ensures no duplicate savings accounts added to
															// BankAccount ArrayList
						accounts.add(new SavingsAccount(accountNumber, balance, interestRate, minimumBalance));
						accounts.get(accounts.size() - 1).accHolder = new Client(firstName, lastName, emailAddress);
					}
				}
			}
			System.out.println("Records successfully read!");

		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("ERROR...file improperly formed. Terminated!");

		} catch (IllegalStateException illegalStateException) {
			System.out.println("ERROR...while reading from file. Terminated!");

		}
		closeInputFile();

	}

	/**
	 * Method closeInputFile closes a text file.
	 */
	public void closeInputFile() {
		if (inputFile != null) {
			inputFile.close();
		}
	}

	/**
	 * Method openOutputFile creates a new text file. Catches SecurityException and
	 * FileNotFoundException when write permissions are denied, and created file not
	 * found.
	 * 
	 * @throws FileNotFoundException
	 */
	public void openOutputFile() throws FileNotFoundException {
		try {
			fileOutput = new Formatter("bankOutput.txt"); // open the file and name it specifically as stated in
															// parameter.

		} catch (SecurityException securityException) {
			System.out.println("ERROR...write permission denied!");

		} catch (FileNotFoundException fileNotFoundException) {
			throw fileNotFoundException;

		}
	}

	/**
	 * closeOutputFile closes the output file that was created.
	 */
	public void closeOutputFile() {
		if (fileOutput != null) {
			fileOutput.close();
		}
	}

}
