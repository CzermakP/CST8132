
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 7
 * Date: March 31, 2019
 */

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * BankAccount abstract class defines the parameters that are needed to create a
 * bank account. Prints formatted Bank Account information. Adds formatted
 * information required for every Bank Account created. Performs deposit and
 * withdraw transactions on created Bank Accounts. Performs monthly account
 * updates on a specific Bank Account. Prints properly formatted bank account
 * information to an output file.
 * 
 * @author Patrick Czermak
 * @version 1.2
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
	 * protected Scanner variable input is used to get user input from keyboard
	 * within classes BankAccount, SavingsAccount, and ChequingAccount.
	 */
	protected Scanner input;

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
	 * they print the full required information of an account.
	 * 
	 * @return stringMsg the properly formatted information all Bank Accounts must
	 *         have.
	 */
	public String toString() {
		decForm = new DecimalFormat("#0.00");
		String stringMsg = "AccountNumber: " + accountNumber + " |Name: " + accHolder.getFirstName() + " "
				+ accHolder.getLastName() + " |Email Address: " + accHolder.getEmailAddress() + " |Balance: $"
				+ decForm.format(balance);
		return stringMsg;
	}

	/**
	 * Method outputString displays to an output text file. Displays the specific
	 * information required for every Bank Account.
	 * 
	 * @return stringMsg is the Bank Account information read from the
	 *         "bankinput.txt" file
	 */
	public String outputString() {
		String stringMsg = accountNumber + " " + accHolder.getFirstName() + " " + accHolder.getLastName() + " "
				+ accHolder.getEmailAddress() + " " + decForm.format(balance);
		return stringMsg;
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
		long doesAccountNumberExist = 0;
		boolean goodAccountNumber = false;

		System.out.println("Enter Account number: ");
		// Validation of account number input.
		while (!goodAccountNumber) {
			goodAccountNumber = true;
			if (!input.hasNextLong()) { // ensure account number isn't anything other than an actual number.
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
				System.out.println("ERROR...account number already exists! please re-enter Account number: ");
				goodAccountNumber = false;
				continue;
			}
		}
		accountNumber = tempAccountNumber; // account now has unique number, so adding it to the accounts.

		// Validation of firstName input.
		System.out.println("Enter first name of account holder :");
		String firstName = input.next();
		while (!firstName.matches("[a-zA-Z]+")) { // loop to get input if doesn't have String value's of "a-z" or "A-Z".
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

		// Validation of email address input.
		System.out.println("Enter Email address :");
		String emailAddress = input.next();
		String emailPattern = "^[a-zA-Z.]{2,}+\\@[a-zA-Z0-9]{2,}+\\.[a-z]{2,3}$";
		// ^[a-zA-Z.]{2,}+@[a-zA-Z]{2,}+\\.[a-z]{2,3}$ is the required format for the
		// email address...the following breaks it down:
		// ^ specifies where the pattern begins...
		// [a-zA-Z.]{2,} specifies the values inputed must be either upper or lower case
		// string values and must contain a minimum of 2 string characters, and a
		// decimal may or may not be added before the @ symbol...
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
		accHolder = new Client(firstName, lastName, emailAddress);
		return true;
	}

	/**
	 * deposit method adds user inputed amount to account balance. Throws a
	 * TransactionIllegalArgumentException if the deposit amount is a negative
	 * value.
	 * 
	 * @param amount user inputed double value which must be positive.
	 * @throws TransactionIllegalArgumentException which is activated if the deposit
	 *                                             amount is negative.
	 */
	public void deposit(double amount) throws TransactionIllegalArgumentException {
		if (amount <= 0) {
			throw new TransactionIllegalArgumentException(accountNumber, "deposit ", amount, "amount negative or zero");
		} else {
			balance += amount;
			System.out.println("Successfully deposited!");
		}
	}

	/**
	 * withdraw method subtracts user inputed amount from account balance. Throws a
	 * TransactionIllegalArgumentException if the withdraw amount is a negative
	 * value or greater than the account balance.
	 * 
	 * @param amount user inputed double value which must be positive.
	 * @throws TransactionIllegalArgumentException which is activated if the deposit
	 *                                             amount is negative or greater
	 *                                             than the account balance.
	 */
	public void withdraw(double amount) throws TransactionIllegalArgumentException {
		if (amount <= 0) {
			throw new TransactionIllegalArgumentException(accountNumber, "withdraw ", amount,
					"amount negative or zero");
		} else if (amount > balance) {
			throw new TransactionIllegalArgumentException(accountNumber, "withdraw ", amount,
					"amount greater than balance");
		} else {
			balance -= amount;
			System.out.println("Successfully withdrawn!");
		}
	}

	/**
	 * Abstract method monthlyAccountUpdate utilizes the overridden subclasses
	 * monthlyAccountUpdate methods to update either a Savings or Chequing account.
	 */
	public abstract void monthlyAccountUpdate();

}
