
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 9 / Assignment 2
 * Date: April 18, 2019
 */

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.lang.SecurityException;

/**
 * The purpose of this Class is to display one account separately or all
 * accounts in the Bank at once. Locates Bank Accounts from within the @accounts
 * ArrayList. Performs monthly updates on all Bank Accounts in the @accounts
 * ArrayList. Opens, reads, and closes an input text file. Creates, opens, and
 * closes and output text file.
 * 
 * @author Patrick Czermak
 * @version 1.3
 * @since JDK 1.8
 */
public class Bank {

	private ArrayList<BankAccount> accounts;
	private static Scanner inputFile;
	private static Formatter fileOutput;
	private static Component parentFrame; //used to receive information from Frame

	/**
	 * Constructor which initializes accounts to a Bank Account in the ArrayList.
	 */
	public Bank() {
		accounts = new ArrayList<BankAccount>();
	}

	/**
	 * Method displayAccount displays account information through calling
	 * findAccount(accountNumber) method in current class. Checks first to make
	 * sure @accounts ArrayList index isn't negative or returns an error message to
	 * GUI.
	 * 
	 * @param accountNumber a specific account number in the @accounts ArrayList
	 * @return either the specified account number if it exists or an error message
	 */
	public String displayAccount(long accountNumber) {
		int accountIndex = findAccount(accountNumber);

		if (accountIndex >= 0) {
			return (accounts.get(accountIndex).toString() + "\n");
		} else {
			return "ERROR";
		}
	}

	/**
	 * Method printAccountDetails prints all accounts in @accounts ArrayList to an
	 * output text file. Catches securityException, formatterClosedException, and
	 * fileNotFoundException when outputting to a text file and pop-up window
	 * displays error message. Utilizes the toString() method to ensure proper
	 * account information is displayed for each account.
	 */
	public void printAccountDetails() {
		try {
			openOutputFile(parentFrame); // calls openOutputFile method
			for (BankAccount acc : accounts) {
				if (acc instanceof ChequingAccount) {
					fileOutput.format("%s%n", acc.toString());
				} else if (acc instanceof SavingsAccount) {
					fileOutput.format("%s%n", acc.toString());
				}
			}
		} catch (SecurityException securityException) {
			JOptionPane.showMessageDialog(parentFrame, "UNABLE TO OPEN FILE DUE TO PERMISSIONS", "ERROR",
					JOptionPane.ERROR_MESSAGE); // error pop-up window
		} catch (FormatterClosedException formatterClosedException) {
			JOptionPane.showMessageDialog(parentFrame, "UNABLE TO CLOSE FILE", "ERROR", JOptionPane.ERROR_MESSAGE); // error pop-up
																													// window
		} catch (FileNotFoundException fileNotFoundException) {
			JOptionPane.showMessageDialog(parentFrame, "UNABLE TO WRITE BANK RECORD(S) TO FILE", "ERROR",
					JOptionPane.ERROR_MESSAGE); // error pop-up window
		}
		closeOutputFile();
	}

	/**
	 * Method static findAccount(int accountNumber) is overloaded which takes input
	 * instead of asking for it. Used when adding a new account.
	 * 
	 * @param accountNumber a specific account number in the @accounts ArrayList.
	 * @return -1 or the index of the account.
	 */
	public int findAccount(long accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).accountNumber == accountNumber) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Method monthlyUpdate performs an update on all accounts existing in
	 * the @accounts ArrayList.
	 * 
	 * @return message monthly updates to all of the accounts in the Bank 
	 */
	public String monthlyUpdate() {
		String message = "";
		String temp = "";
		for (BankAccount acc : accounts) {
			if (!(temp = acc.monthlyAccountUpdate()).equals("")) {
				message += temp;
				message += "\n";
			}
		}
		return message;
	}

	/**
	 * Method openInputFile opens the text file "bankData.txt". Catches an
	 * IO(input/Output) Exception and pop-up error window displays if unable to open
	 * the file.
	 * 
	 * @param parentFrame Frame used to display pop-up window message dialogs
	 */
	public void openInputFile(Component parentFrame) {
		try {
			inputFile = new Scanner(Paths.get("bankData.txt")); // locates the "bankData.txt" file from the path of
																// where source code is stored (and where file was
																// placed)
		} catch (IOException ioException) {
			JOptionPane.showMessageDialog(parentFrame, "CANNOT OPEN FILE, TERMINATED", "ERROR",
					JOptionPane.ERROR_MESSAGE); // error pop-up window
		}
	}

	/**
	 * Method readRecords reads and formats information from the text file
	 * bankData.txt, and creates either a new Chequing or Savings Account in the
	 * Bank. Catches NoSuchElementException and IllegalStateException when file is
	 * not properly formed or an error reading from the file. Each exception prompts
	 * a pop-up window to display informing user of error.
	 * 
	 * @param parentFrame Frame used to display pop-up window message dialogs
	 */
	public void readRecords(Component parentFrame) {
		boolean validRecord = true;
		openInputFile(parentFrame);
		try {
			while (inputFile.hasNext()) {
				String accountType = inputFile.next();
				if (accountType.equalsIgnoreCase("C")) {
					Long accountNumber = inputFile.nextLong();
					String firstName = inputFile.next();
					String lastName = inputFile.next();
					String phoneNumber = inputFile.next();
					String emailAddress = inputFile.next();
					Double balance = inputFile.nextDouble();
					double fee = inputFile.nextDouble();

					if (findAccount(accountNumber) == -1) { // ensures no duplicate chequing accounts added to
															// BankAccount ArrayList
						accounts.add(new ChequingAccount(accountNumber, balance, fee,
								new Client(firstName, lastName, phoneNumber, emailAddress))); // adds the chequing
																								// account to the Bank.
					}
				} else if (accountType.equalsIgnoreCase("S")) {
					Long accountNumber = inputFile.nextLong();
					String firstName = inputFile.next();
					String lastName = inputFile.next();
					String phoneNumber = inputFile.next();
					String emailAddress = inputFile.next();
					Double balance = inputFile.nextDouble();
					double interestRate = inputFile.nextDouble();
					Double minimumBalance = inputFile.nextDouble();

					if (findAccount(accountNumber) == -1) { // ensures no duplicate savings accounts added to
															// BankAccount ArrayList
						accounts.add(new SavingsAccount(accountNumber, balance, interestRate, minimumBalance,
								new Client(firstName, lastName, phoneNumber, emailAddress))); // adds the saving account
																								// to the Bank.
					}
				}
			}
		} catch (NoSuchElementException noSuchElementException) {
			JOptionPane.showMessageDialog(parentFrame, "FILE IMPROPERLY FORMED", "ERROR", JOptionPane.ERROR_MESSAGE); // error pop-up
																														// window
			validRecord = false;
		} catch (IllegalStateException illegalStateException) {
			JOptionPane.showMessageDialog(parentFrame, "CANNOT READ FROM FILE", "ERROR", JOptionPane.ERROR_MESSAGE); // error pop-up
																														// window
			validRecord = false;

		}
		if (validRecord) {
		JOptionPane.showMessageDialog(parentFrame, "Records successfully read", "CONFIRMATION",
				JOptionPane.INFORMATION_MESSAGE); // confirmation pop-up window
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
	 * Method openOutputFile creates a new text file. Catches SecurityException when
	 * write permissions are denied on the file, and prompts a pop-up window to
	 * display informing user of error.
	 * 
	 * @param parentFrame Frame used to display pop-up window message dialogs
	 * @throws FileNotFoundException throws up to printAccoountDetails() where handled
	 */
	public void openOutputFile(Component parentFrame) throws FileNotFoundException {
		try {
			fileOutput = new Formatter("bankDataOutput.txt"); // open the file and name it specifically as stated in
																// parameter.
		} catch (SecurityException securityException) {
			JOptionPane.showMessageDialog(parentFrame, "WRITE PERMISSION DENIED", "ERROR", JOptionPane.ERROR_MESSAGE); // pop-up
																														// window
		}
	}

	/**
	 * Method closeOutputFile closes the output file that was created. Once
	 * completed prompts a pop-up to display confirming successful completion.
	 */
	public void closeOutputFile() {
		if (fileOutput != null) {
			fileOutput.close();
			JOptionPane.showMessageDialog(parentFrame, "Records successfully written to [bankDataOutput.text] file",
					"CONFIRMATION", JOptionPane.INFORMATION_MESSAGE); // pop-up window
		}
	}

	/**
	 * Method gets and stores accounts ArrayList. BankSimulatorFrame Class utilizes
	 * this to access the ArrayList.
	 * 
	 * @return accounts all of the existing accounts in the Bank
	 */
	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}
}
