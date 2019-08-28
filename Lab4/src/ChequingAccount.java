
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 4
 * Date: February 16, 2019
 */

/**
 * This class represents a chequing account. It overrides the BankAccount
 * class's method of toString in order to properly display each chequing
 * accounts info. Also overrides BankAccount class's abstract method
 * calculateAndUpdateBalance in order to properly display its monthly interest
 * rate updates on the accounts.
 * 
 * @author Patrick Czermak
 * @version 1.0
 * @since JDK 1.8
 *
 */

public class ChequingAccount extends BankAccount {
	/**
	 * attribute which refers to the actual fee value. Within package it is randomly
	 * generated between ($1.00 - $5.00).
	 */
	private double fee;

	/**
	 * CONSTRUCTOR - initializes class variables to their given values.
	 * 
	 * @param fee     holds the monthly fee for chequing accounts.
	 * @param balance holds the balance for chequing accounts which will be a double
	 *                value.
	 */
	public ChequingAccount(double fee, double balance) {
		this.fee = fee;
		this.balance = balance;
	}

	/**
	 * METHOD toString - to display the type of account(chequing) and the "fee". The
	 * account number and balance amount is added through the toString method which
	 * uses the parent class's toString method that holds the "balance" attribute.
	 * Envoke's the toString() method of BankAccount.
	 * 
	 * @return String value showing account type and fee.
	 */	
	@Override
	public String toString() {
		return "Chequing Account" + super.toString() + "| Monthly Fee: $ " + decForm.format(fee);
	}

	/**
	 * METHOD holds the calculations for adding and updating the yearly interest
	 * rate for the savings accounts(balance minus fee). It is overridden by its
	 * parent class BankAccount, which uses this class's(sub class) methods as
	 * needed.
	 * 
	 * @return void.
	 */
	@Override
	public void calculateAndUpdateBalance() {
		balance -= fee;

	}
}
