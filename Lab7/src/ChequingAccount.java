
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 7
 * Date: March 31, 2019
 */

import java.util.Random;

/**
 * The purpose of this class is to create, hold, print, output to file, and
 * update the specific parameters of a Chequing Account. It is a sub-class of
 * BankAccount abstract class.
 * 
 * @author Patrick Czermak
 * @version 1.2
 * @since JDK 1.8
 */
public class ChequingAccount extends BankAccount {
	/**
	 * Double variable to hold the Chequing Accounts fee which is a randomly
	 * generated double value between ($5.00 - $10.00).
	 */
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
	 *                      between 1-8 digits in length
	 * @param balance       is a double value to hold the balance which must be a
	 *                      positive number
	 * @param fee           is a double value randomly assigned
	 */
	public ChequingAccount(Long accountNumber, double balance, double fee) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.fee = fee;

	}

	/**
	 * Method toString prints to console the properly formatted parameters that are
	 * required for a Chequing Account, invokes the super-class BankAccount toString
	 * method and combined they print the full parameters of a Chequing Account.
	 * 
	 * @return stringMsg is the properly formatted information required for a
	 *         chequing account
	 */
	@Override
	public String toString() {
		String stringMsg = "C |" + super.toString() + " |Fee $" + decForm.format(fee);
		return stringMsg;
	}

	/**
	 * Methods outputString displays to an output text file the properly formatted
	 * parameters that are required for a Chequing Account, invokes the super-class
	 * BankAccount outputString method and combined they print the full parameters
	 * of a Chequing account to an output file.
	 * 
	 * @return stringMsg is the properly formatted Chequing Account information read
	 *         from the "bankinput.txt" file
	 */
	@Override
	public String outputString() {
		String stringMsg = "C " + super.outputString() + decForm.format(fee);
		return stringMsg;
	}

	/**
	 * Method addBankAccount validates user inputed "fee" before allowing a Chequing
	 * Account to be created. Method is overridden by the super-class BankAccount
	 * toString method, combined they create a Chequing Account.
	 */
	@Override
	public boolean addBankAccount() {
		double random = new Random().nextDouble();
		if (super.addBankAccount()) {
			fee = 5.00 + (random * (10.00 - 5.00));
		}
		return true;
	}

	/**
	 * Method monthlyAccountUpdate updates the Chequing Account's balance by
	 * deducting the fee. The method is overridden by the superclass BankAccount's
	 * monthlyAccountUpdate method.
	 */
	@Override
	public void monthlyAccountUpdate() {
		if (balance > fee) {
			balance -= fee;
		} else {
			System.out.println("NOTE: Unable to update account number [" + accountNumber
					+ "] due to insufficient funds! Fee is greater than account balance!");
		}
	}
}
