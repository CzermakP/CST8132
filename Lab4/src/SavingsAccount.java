
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 4
 * Date: February 16, 2019
 */

/**
 * This class represents a savings account. It overrides the BankAccount method
 * of toString in order to properly display each savings accounts info. Also
 * overrides BankAccount abstract method calculateAndUpdateBalance in order to
 * properly display its monthly fee updates on the accounts.
 * 
 * @author Patrick Czermak
 * @version 1.0
 * @since JDK 1.8
 *
 */

public class SavingsAccount extends BankAccount {
	/**
	 * attribute which refers to the actual interest rate value. Within package it
	 * is randomly generated between (0.02 - 0.10).
	 */
	private double interestRate;

	/**
	 * CONSTRUCTOR - initializes class variables to their given values.
	 * 
	 * @param interestRate holds the interest rate for savings accounts.
	 * @param balance      holds the balance for savings accounts which will be a
	 *                     double value.
	 */
	public SavingsAccount(double interestRate, double balance) {
		this.interestRate = interestRate;
		this.balance = balance;
	}

	/**
	 * METHOD toString - to display the "InterestRate". The balance amount is added
	 * through the toString method which uses the parent toString method that holds
	 * the "balance" attribute. Envoke's the toString() method of BankAccount.
	 * 
	 * @return String value showing account type and interest rate.
	 */	
	@Override
	public String toString() {
		return "Savings Account " + super.toString() + "| Interest Rate: " + decForm.format(interestRate) + " %";
	}

	/**
	 * METHOD holds the calculations for adding and updating the yearly interest
	 * rate for the savings accounts, by breaking up the year into 12 months in
	 * order to get an accurate monthly interest rate(balance plus yearly interest
	 * divided by 12). It is overridden by its parent class BankAccount, which uses
	 * this class's(sub class) methods as needed.
	 * 
	 * @return void.
	 */	
	@Override
	public void calculateAndUpdateBalance() {
		double monthlyInterest = (balance * interestRate) / 12; // monthly interest rate calculation.
		balance = balance + monthlyInterest; // monthly balance calculation.
	}
}
