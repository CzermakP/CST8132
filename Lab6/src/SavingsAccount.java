
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 6
 * Date: March 17, 2019
 */

/**
 * The purpose of this class is to create, hold, print, and update the specific
 * parameters of a Savings Account. It is a subclass of BankAccount abstract
 * class.
 * 
 * @author Patrick Czermak
 * @version 1.1
 * @since JDK 1.8
 */
public class SavingsAccount extends BankAccount {
	/**
	 * Double variable to hold the Savings Account interestRate, ranging only from
	 * (0-1).
	 */
	private double interestRate;

	/**
	 * Double variable to hold the Savings Account minimumBalance. Must be positive
	 * and less than account balance.
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
	 * @param interestRate   is a double value which must be only from (0 - 1).
	 * @param minimumBalance is a double value which must be a positive number, and
	 *                       smaller than the account balance.
	 */
	public SavingsAccount(double interestRate, double minimumBalance) {
		this.interestRate = interestRate;
		this.minimumBalance = minimumBalance;
	}

	/**
	 * Method toString prints the properly formatted parameters that are required
	 * for a Savings Account, invokes the super-class BankAccount toString method
	 * and combined they print the full parameters of a Savings Account.
	 */
	@Override
	public String toString() {
		return super.toString() + " |Minimum Balance: $" + decForm.format(minimumBalance) + " |Interest Rate: "
				+ decForm.format(interestRate) + "%";
	}

	/**
	 * Method addBankAccount validates user inputed "minimum balance" and "interest
	 * rate" before allowing a Savings Account to be created. Method is overridden
	 * by the superclass BankAccount toString method, combined they create a Savings
	 * Account.
	 */
	@Override
	public boolean addBankAccount() {
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
			// validation of interest rate.
			boolean goodInterestRate = false;
			System.out.println("Enter interest rate (should be a number in (0,1)):");
			while (!goodInterestRate) {
				goodInterestRate = true;
				if (!input.hasNextDouble()) { // ensure interest rate isn't anything other than an actual number.
					System.out.println(
							"INVALID...interest rate must be a number from 0 and 1! Please re-enter interest rate:");
					input.next();
					goodInterestRate = false;
					continue;
				}
				interestRate = input.nextDouble();
				if (interestRate < 0 || interestRate > 1) { // ensure interest rate isn't less than zero or greater than
															// one.
					System.out.println("INVALID...interest rate must be from 0 and 1! Please re-enter interest rate:");
					goodInterestRate = false;
					continue;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Method monthlyAccountUpdate updates the Savings Account's balance by
	 * deducting the interest rate. The method is overridden by the superclass
	 * BankAccount's monthlyAccountUpdate method.
	 */
	@Override
	public void monthlyAccountUpdate() {
		double monthlyInterestRate = (balance * interestRate) / 12; // breaks up interest rate into 12 months.
		if (balance > minimumBalance) { // minimum balance requirements.
			balance += monthlyInterestRate;
		} else {
			System.out.println("ERROR...Unable to update account number [" + accountNumber
					+ "] due to insufficient fund! Interest rate is greater than account balance!");
		}
	}

}
