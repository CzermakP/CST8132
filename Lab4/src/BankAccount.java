
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 4
 * Date: February 16, 2019
 */

import java.text.DecimalFormat;
import java.util.Random;

/**
 * This class is a simple abstract bank account object which randomly generates
 * an account number and opening account balance. Updates balances of chequing
 * and saving accounts, as well as printing properly formatted chequing and
 * saving accounts information.
 * 
 * @author Patrick Czermak
 * @version 1.0
 * @since JDK 1.8
 */
public abstract class BankAccount {
	/**
	 * Random is used to generated account numbers, which do not change once
	 * assigned.
	 */
	private Random rand;
	/**
	 * DecimalFormat decForm is used to display properly formatted bank account
	 * balance. Savings accounts inherit it for displaying monthly interest rate,
	 * and Chequing accounts inherit it it for displaying fee.
	 */
	protected DecimalFormat decForm;
	/**
	 * balance refers to the actual balance which is randomly generated within this
	 * package to be between ($20.00 - 100.00), the balance gets updated with
	 * interest rate and fee changes.
	 */
	protected double balance;
	/**
	 * accountNo is a randomly generated long number which doesn't change throughout
	 * this package once assigned to an account.
	 */
	protected int accountNo;
	/**
	 * numAccounts is set once, as a randomly generated number.
	 */
	protected static int numAccounts; // stored only in one location (static attribute).

	/**
	 * CONSTRUCTOR - creating a randomly generated BankAccount account number only 8
	 * numbers in length by using (((Max - Min) +1) + Min).
	 */
	public BankAccount() {
		rand = new Random();
		accountNo = rand.nextInt((99999999 - 10000000) + 1) + 10000000;
		while (accountNo <= 0) {
			accountNo = rand.nextInt((99999999 - 10000000) + 1) + 10000000;
		}
	}

	/**
	 * Gets and returns the balance of the bank account.
	 * 
	 * @return balance - The balance of the bank account as a double.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * METHOD toString to display the account number and balance. It uses the
	 * toString methods from ChequingAccount and SavingsAccount which hold their
	 * information about their respective accounts. Combined they display the
	 * appropriate information for EACH account (account type, account number,
	 * balance, and interest rate OR fee).
	 * 
	 * @return String value showing account number and balance.
	 */
	@Override
	public String toString() {
		decForm = new DecimalFormat("00.00");
		if (balance < 0 || balance >= 100) { // ensures the display is consistently formatted throughout even when
												// balance becomes negative or greater than $100.00.
			return " | No: " + accountNo + " | Balance: $" + decForm.format(balance) + " ";
		} else {
			return " | No: " + accountNo + " | Balance: $ " + decForm.format(balance) + " ";
		}
	}

	/**
	 * ABSTRACT METHOD to calculate and update balance. Every sub-class has this
	 * method. Overrides the calculateAndUpdate methods of sub-classes
	 * ChequingAccount and SavingsAccount.
	 */
	public abstract void calculateAndUpdateBalance(); // a declaration of an abstract method doesn't need "{ }".
}
