
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 5/Assignment 1
 * Date: March 3, 2019
 */

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * BankAccount abstract class defines the parameters that are needed to create a bank
 * account.
 * 
 * @author Patrick Czermak
 * @version 1
 * @since JDK 1.8
 */
public abstract class BankAccount {
	/**
	 * protected variable accountNumber holds the account number of a Bank Account. 
	 * Must be a positive, unique number not greater than 8 numbers long.
	 */
	protected int accountNumber;
	/**
	 * protected Person variable accHolder has predefined parameters in class Person (firstName, lastName, phoneNumber, emailAddress).
	 */
	protected Person accHolder;
	/**
	 * protected double variable balance holds an accounts balance. 
	 * Must be a positive number.
	 */
	protected double balance;
	/**
	 * protected Scanner variable input is used to get user input from keyboard within classes BankAccount,
	 * SavingsAccount, and ChequingAccount.
	 */
	protected Scanner input;
	/**
	 * protected DecimalFormat variable decForm is used to format all number values for display within classes
	 * BankAccount, SavingsAccount, and ChequingAccount.
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
	 * they print the full required information of an account.
	 */
	public String toString() {
		decForm = new DecimalFormat("#0.00");
		String print = "AccountNumber: " + accountNumber + " |Name: " + accHolder.getFirstName() + " "
				+ accHolder.getLastName() + " |Phone Number: " + accHolder.getPhoneNumber() + " |Email Address: "
				+ accHolder.getEmailAddress() + " |Balance: $" + decForm.format(balance);
		return print;
	}

	
	/**
	 * Method addBankAccount adds the properly formatted information required for
	 * every account created, including account number, first name, last name, phone
	 * number, email address, and opening balance.
	 * 
	 * @return true while account holder information validates properly
	 */
	public boolean addBankAccount() {
		input = new Scanner(System.in);
		
		int tempAccountNumber = 0; // creating tempAccountNumber so can try and find bank account before
									// assigning the actual BankAccount objects account number.
		int doesAccountNumberExist = 0;
		boolean goodAccountNumber = false;
		System.out.println("Enter Account number: ");
		// Validation of account number input.
		while (!goodAccountNumber) {
			goodAccountNumber = true;
			if (!input.hasNextInt()) { // ensure account number isn't anything other than an actual number.
				System.out.println("INVALID...Account number must be a number! Please re-enter Account number:");
				input.next();
				goodAccountNumber = false;
				continue;
			}
			tempAccountNumber = input.nextInt();
			if (tempAccountNumber <= 0) { // ensure account number isn't zero or negative value.
				System.out.println(
						"INVALID...Account number cannot be zero or negative! Please re-enter" + " Account number:");
				goodAccountNumber = false;
				continue;
			}
			if (tempAccountNumber > 99999999) { // ensure account number is max of eight digits long.
				System.out.println("INVALID...Account number cannot be greater than 8 digits long! Please"
						+ " re-enter Account number:");
				goodAccountNumber = false;
				continue;
			}
			doesAccountNumberExist = Bank.findAccount(tempAccountNumber);
			if (doesAccountNumberExist >= 0) {
				System.out.println("INVALID...account number already exists, please re-enter Account number: ");
				goodAccountNumber = false;
				continue;
			}
		}
		accountNumber = tempAccountNumber; // account now has unique number, so adding it to the accounts.
		// Validation of firstName input.
		System.out.println("Enter first name of account holder :");
		String firstName = input.next();
		while ( !firstName.matches("[a-zA-Z]+") ) { // loop to get input if doesn't have String value's of "a-z" or "A-Z". 
			System.out.println("INVALID...first name must be a string value! Please re-enter first name:");
			firstName = input.next();
		}

		// Validation of lastName input.
		System.out.println("Enter last name of account holder :");
		String lastName = input.next();
		while (!lastName.matches("[a-zA-Z]+")) { // loop to get input if doesn't have String value's of "a-z" or "A-Z".																		
			System.out.println("INVALID...last name must be a string value! Please re-enter last name:");
			lastName = input.next();
		}
		// Validation of phone number input.
		String phoneNumber = " ";
		boolean goodPhoneNumber = false;
		System.out.println("Enter phone number :");
		while (!goodPhoneNumber)  {
			goodPhoneNumber = true;
			if (!input.hasNext()) { // ensure phone number input is only string values.
				System.out.println("INVALID...phone number must only be numbers 10 or 11 digits long wihtout spaces!"
						+ " Please re-enter phone number:");
				input.next();
				goodPhoneNumber = false;
				continue;
			}
			phoneNumber = input.next();
			if ((!phoneNumber.matches("[0-9]{10,11}") || phoneNumber.contains(" "))) { // ensure phone number is only string values and only 10 or 11
														// numbers long.
				System.out.println("INVALID...phone number must only be numbers 10 or 11 digits long without spaces!"
						+ " Please re-enter phone number:");
				goodPhoneNumber = false;
				continue;
			}
		}
		// Validation of email address input.    
		System.out.println("Enter Email address :");
		String emailAddress = input.next();
		String emailPattern = "^[a-zA-Z]{2,}+\\@[a-zA-Z]{2,}+\\.[a-z]{2,3}$";
		// ^[a-zA-Z]{2,}+@[a-zA-Z]{2,}+\\.[a-z]{2,3}$ is the required format for the
		// email address...the following breaks it down:
		// ^ specifies where the pattern begins...
		// [a-zA-Z]{2,} specifies the values inputed must be either upper or lower case
		// string values and must contain a minimum of 2 string characters...
		// +\\@ specifies that an @ symbol must come next...
		// [a-zA-Z]{2,} specifies the values inputed must be either upper or lower case
		// string values and must contain a minimum of 2 string characters...
		// +\\. specifies that a . must come next...
		// [a-z]{2,3} specifies that the values inputed must be only 2 or 3 lower case
		// string values...
		// $ specifies where the pattern ends.

		while (!emailAddress.matches(emailPattern)) {
			System.out.println(
					"INVALID...Email address must be in the form of [cc@cc.cc] at the minimal! Please re-enter email address:");
			emailAddress = input.next();
		}
		// Validation of opening balance input.
		boolean goodOpeningBalance = false;
		System.out.println("Enter opening balance :");
		while (!goodOpeningBalance) {
			goodOpeningBalance = true;
			if (!input.hasNextDouble()) { // ensure opening balance is only a double value.
				System.out
						.println("INVALID...opening balance must be a number greater or equal to zero! Please re-enter"
								+ " opening balance:");
				input.next();
				goodOpeningBalance = false;
				continue;
			}
			balance = input.nextDouble();
			if (balance < 0) { // ensure opening balance isn't negative.
				System.out
						.println("INVALID...opening balance must be a number greater or equal to zero! Please re-enter"
								+ " opening balance:");
				goodOpeningBalance = false;
				continue;
			}
		}
		accHolder = new Person(firstName, lastName, phoneNumber, emailAddress);
		return true;
	}

	
	/**
	 * Method updateBalance updates the balance in the object by the parameter amount.
	 * 
	 * @param amt
	 */
	public void updateBalance(double amt) {
		balance = amt + balance;
	}

	
	/**
	 * Abstract method monthlyAccountUpdate utilizes the overridden subclasses
	 * monthlyAccountUpdate methods to update either a Savings or Chequing account.
	 */
	public abstract void monthlyAccountUpdate();

}
