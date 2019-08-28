
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
 * update the specific parameters of a Savings Account. It is a sub-class of
 * BankAccount abstract class.
 * 
 * @author Patrick Czermak
 * @version 1.2
 * @since JDK 1.8
 */
public class SavingsAccount extends BankAccount {
	/**
	 * Double variable to hold the Savings Account interestRate which is a randomly
	 * generated double value ranging between (0.00% - 1.00%).
	 */
	private double interestRate;

	/**
	 * Double variable to hold the Savings Account minimumBalance. Must be a
	 * positive value and less than account balance.
	 */
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
	 *                       be between 1-8 digits in length
	 * @param balance        is a double value to hold the balance which must be a
	 *                       positive number
	 * @param interestRate   is a double value randomly assigned
	 * @param minimumBalance is a double value which must be a positive number, and
	 *                       smaller than the account balance.
	 */
	public SavingsAccount(Long accountNumber, double balance, double interestRate, double minimumBalance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.minimumBalance = minimumBalance;
	}

	/**
	 * Method toString prints the properly formatted parameters that are required
	 * for a Savings Account, invokes the super-class BankAccount toString method
	 * and combined they print the full parameters of a Savings Account.
	 * 
	 * @return stringMsg is the properly formatted information required for a
	 *         Savings Account.
	 */
	@Override
	public String toString() {
		String stringMsg = "S |" + super.toString() + " |Minimum Balance: $" + decForm.format(minimumBalance)
				+ " |Interest Rate: " + decForm.format(interestRate) + "%";
		return stringMsg;
	}

	/**
	 * Method outputString displays to an output text file the properly formatted
	 * parameters of a Savings Account, invokes the super-class BankAccount
	 * outputString method, combined they print the full parameters of a Chequing
	 * Account to an output file.
	 * 
	 * @return stringMsg is the properly formatted Savings Account information read
	 *         from the "bankinput.txt" file.
	 */
	@Override
	public String outputString() {
		String stringMsg = "S " + super.outputString() + decForm.format(interestRate);
		return stringMsg;
	}

	/**
	 * Method addBankAccount randomly generates "interest rate", and validates user
	 * inputed "minimum balance" before allowing a Savings Account to be created.
	 * Method is overridden by the superclass BankAccount toString method, combined
	 * they create a Savings Account.
	 */
	@Override
	public boolean addBankAccount() {
		double random = new Random().nextDouble();
		if (super.addBankAccount()) {
			// validation of minimumBalance.
			boolean goodMinimumBalance = false;
			System.out.println("Enter minimum balance :");
			while (!goodMinimumBalance) {
				goodMinimumBalance = true;
				if (!input.hasNextDouble()) { // ensure minimum balance isn't anything other than an actual number.
					System.out.println("INVALID...minimum balance must be a number! Please re-enter minimum balance:");
					input.next();
					goodMinimumBalance = false;
					continue; // forces code to re-loop if goodMinimumBalance found to be false.
				}
				minimumBalance = input.nextDouble();
				if (minimumBalance < 0) { // ensure minimum balance isn't less than zero.
					System.out.println(
							"INVALID...minimun balance must be zero or greater! Please re-enter minimum balance:");
					goodMinimumBalance = false;
					continue;
				}
				if (minimumBalance > balance) { // ensures minimum balance isn't greater than balance.
					System.out.println("INVALID...minimum balance must be equal to or less than opening balance!"
							+ " Please re-enter minimum balance:");
					goodMinimumBalance = false;
					continue;
				}
			}
			// randomly generated interest rate value between 0.00% - 1.00%.
			interestRate = 0.00 + (random * (1.00 - 0.00));
		}
		return true;
	}

	/**
	 * Method monthlyAccountUpdate updates the Savings Account's balance by
	 * deducting the interest rate. The method is overridden by the super-class
	 * BankAccount's monthlyAccountUpdate method.
	 */
	@Override
	public void monthlyAccountUpdate() {
		double monthlyInterestRate = (balance * interestRate) / 12; // breaks up interest rate into 12 months.
		if (balance > minimumBalance) { // minimum balance requirements.
			balance += monthlyInterestRate;
		} else {
			System.out.println("NOTE: Unable to update account number [" + accountNumber
					+ "] due to insufficient funds! Interest rate is greater than account balance!");
		}
	}
}
