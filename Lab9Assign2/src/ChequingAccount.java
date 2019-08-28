
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 9 / Assignment 2
 * Date: April 18, 2019
 */


/**				
 * The purpose of this Class is to create, hold, display, output to file, and
 * update the specific parameters of a Chequing Account. It is a sub-class of
 * BankAccount abstract class.
 * 
 * @author Patrick Czermak
 * @version 1.3
 * @since JDK 1.8
 */
public class ChequingAccount extends BankAccount {
	// class variable.
	private double fee;

	/**
	 * Default Constructor.
	 */
	public ChequingAccount() {

	}

	/**
	 * Parameterized constructor to define the specific parameters a Chequing
	 * Account must have for a bank account.
	 * 
	 * @param accountNumber is a Long value to hold the account number which will be
	 *                      between 1-8 digits in length.
	 * @param balance       is a double value to hold the balance which must be a
	 *                      positive number.
	 * @param fee           is a double value randomly assigned.
	 * @param accHolder		has predefined parameters in Client Class.
	 */
	public ChequingAccount(Long accountNumber, double balance, double fee, Client accHolder) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.fee = fee;
		this.accHolder = accHolder;

	}

	/**
	 * Method toString displays to the GUI the properly formatted parameters that are
	 * required for a Chequing Account, invokes the super-class BankAccount toString
	 * method and combined they print the full parameters of a Chequing Account.
	 * 
	 * @return stringMsg is the properly formatted information required for a
	 *         chequing account
	 */
	@Override
	public String toString() {
		String stringMsg = " C  " + super.toString() + "  Fee: $" + decForm.format(fee) + " ";
		return stringMsg;
	}

	/**
	 * Methods outputString displays to an output text file the properly formatted
	 * parameters that are required for a Chequing Account, invokes the super-class
	 * BankAccount outputString method and combined they display the full parameters
	 * of a Chequing account to an output file.
	 * 
	 * @return stringMsg is the properly formatted Chequing Account information read
	 *         from the "bankinput.txt" file 
	 */
	@Override
	public String outputString() {
		String stringMsg = " C  " + super.outputString() + decForm.format(fee) + " ";
		return stringMsg;
	}

	/**
	 * Method monthlyAccountUpdate updates the Chequing Account's balance by
	 * deducting the fee. The method is overridden by the superclass BankAccount's
	 * monthlyAccountUpdate method.
	 * 
	 * @return message either successful or unsuccessful updates performed pop-up window
	 */
	@Override
	public String monthlyAccountUpdate() {
		String message = "";
		if (balance > fee) {
			balance -= fee;
			message =  "Monthly update for account [" + accountNumber + "] successful";			
		} else {
			message =  "UNABLE TO UPDATE ACCOUNT [" + accountNumber + "] DUE TO INSUFFICIENT FUNDS";			
		}
		return message;
	}
}
