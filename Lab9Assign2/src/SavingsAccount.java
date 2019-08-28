
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 9 / Assignment 2
 * Date: April 18, 2019
 */


/**				
 * The purpose of this Class is to create, hold, display, output to file, and
 * update the specific parameters of a Savings Account. It is a sub-class of
 * BankAccount abstract class.
 * 
 * @author Patrick Czermak
 * @version 1.3
 * @since JDK 1.8
 */
public class SavingsAccount extends BankAccount {
	// class variables.
	private double interestRate;
	private double minimumBalance;

	/**
	 * Default constructor.
	 */
	public SavingsAccount() {

	}

	/**
	 * Parameterized constructor to define the specific parameters a Savings Account
	 * must have for a bank account.
	 * 
	 * @param accountNumber  is a Long value to hold the account number which will
	 *                       be between 1-8 digits in length.
	 * @param balance        is a double value to hold the balance which must be a
	 *                       positive number.
	 * @param interestRate   is a double value randomly assigned.
	 * @param minimumBalance is a double value which must be a positive number, and
	 *                       smaller than the account balance.
	 * @param accHolder		 has predefined parameters in Client Class.
	 */
	public SavingsAccount(Long accountNumber, double balance, double interestRate, double minimumBalance, Client accHolder) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.minimumBalance = minimumBalance;
		this.accHolder = accHolder;
	}

	/**
	 * Method toString displays the properly formatted parameters that are required
	 * for a Savings Account, invokes the super-class BankAccount toString method
	 * and combined they display the full parameters of a Savings Account.
	 * 
	 * @return stringMsg is the properly formatted information required for a
	 *         Savings Account.
	 */
	@Override
	public String toString() {
		String stringMsg = " S  " + super.toString() + "  Minimum Balance: $" + decForm.format(minimumBalance)
				+ "  Interest Rate: " + decForm.format(interestRate) + "%  ";
		return stringMsg;
	}

	/**
	 * Method outputString displays to an output text file the properly formatted
	 * parameters of a Savings Account, invokes the super-class BankAccount
	 * outputString method, combined they display the full parameters of a Chequing
	 * Account to an output file.
	 * 
	 * @return stringMsg is the properly formatted Savings Account information read
	 *         from the "bankinput.txt" file.
	 */
	@Override
	public String outputString() {
		String stringMsg = " S " + super.outputString() + decForm.format(interestRate) + " ";
		return stringMsg;
	}

	/**
	 * Method monthlyAccountUpdate updates the Savings Account's balance by
	 * deducting the interest rate. The method is overridden by the super-class
	 * BankAccount's monthlyAccountUpdate method.
	 * 
	 * @return message either successful or unsuccessful updates performed pop-up window
	 */
	@Override
	public String monthlyAccountUpdate() {
		String message = "";
		double monthlyInterestRate = (balance * interestRate) / 12; // breaks up interest rate into 12 months.
		if (balance > minimumBalance) { // minimum balance requirements.
			balance += monthlyInterestRate;
			message =  "Monthly update for account [" + accountNumber + "] successful";			
		} else {
			message = "UNABLE TO UPDATE ACCOUNT [" + accountNumber + "] DUE TO INSUFFICIENT FUNDS";
		}
		return message;
	}
}
