
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 9 / Assignment 2
 * Date: April 18, 2019
 */

import java.text.DecimalFormat;

/**
 * The purpose of this Class is to define required information that every Bank
 * Account must contain. Adds formatted information required for every Bank
 * Account created. Performs deposit and withdraw transactions on created Bank
 * Accounts. Performs monthly account updates on a specific Bank Account. Prints
 * properly formatted bank account information to an output file.
 * 
 * @author Patrick Czermak
 * @version 1.3
 * @since JDK 1.8
 */
public abstract class BankAccount {
	/**
	 * protected variable accountNumber holds the account number of a Bank Account.
	 * Must be a positive, unique number not greater than 8 numbers long.
	 */
	protected long accountNumber;

	/**
	 * protected Person variable accHolder has predefined parameters in class Person
	 * (firstName, lastName, phoneNumber, emailAddress).
	 */
	protected Client accHolder;

	/**
	 * protected double variable balance holds an accounts balance. Must be a
	 * positive number.
	 */
	protected double balance;

	/**
	 * protected DecimalFormat variable decForm is used to format all number values
	 * for display within classes BankAccount, SavingsAccount, and ChequingAccount.
	 */
	protected DecimalFormat decForm;

	/**
	 * Default constructor.
	 */
	public BankAccount() {

	}

	/**
	 * Method toString returns data of the account formatted to display. This method
	 * is overridden by its subclasses SavingsAccount and ChequingAccount. Combined
	 * they display the full required information of an account.
	 * 
	 * @return stringMsg the properly formatted information all Bank Accounts must
	 *         have.
	 */
	public String toString() {
		decForm = new DecimalFormat("#0.00");
		String stringMsg = "AccountNumber: " + accountNumber + "  Name: " + accHolder.getFirstName() + " "
				+ accHolder.getLastName() + "  Phone Number: " + accHolder.getPhoneNumber() + "  Email Address: "
				+ accHolder.getEmailAddress() + "  Balance: $" + decForm.format(balance);
		return stringMsg;
	}

	/**
	 * Method outputString displays to an output text file. Displays the specific
	 * information required for every Bank Account.
	 * 
	 * @return stringMsg is the Bank Account information read from the
	 *         "bankinput.txt" file.
	 */
	public String outputString() {
		String stringMsg = accountNumber + " " + accHolder.getFirstName() + " " + accHolder.getLastName() + " "
				+ accHolder.getPhoneNumber() + " " + accHolder.getEmailAddress() + " " + decForm.format(balance);
		return stringMsg;
	}

	/**
	 * deposit method adds user inputed amount to account balance.
	 * 
	 * @param amount user inputed double value which must be positive.
	 * @return depositMessage when deposit amount successfully deposited into an account
	 */
	public String deposit(double amount) {
		String depositMessage = "Successfully deposited";
		balance += amount;
		return depositMessage;
	}

	/**
	 * withdraw method subtracts user inputed amount from account balance.
	 * 
	 * @param amount user inputed double value which must be positive.
	 * @return withdrawMessage either successful or unsuccessful message
	 */
	public String withdraw(double amount) {
		String withdrawMessage = "Successfully withdrawn";
		balance -= amount;
		return withdrawMessage;
	}

	/**
	 * Abstract method monthlyAccountUpdate utilizes the overridden subclasses
	 * monthlyAccountUpdate methods to update either a Savings or Chequing account.
	 * 
	 * @return message either successful or unsuccessful updates performed on Savings or Chequing accounts pop-up window
	 */
	public abstract String monthlyAccountUpdate();

}
