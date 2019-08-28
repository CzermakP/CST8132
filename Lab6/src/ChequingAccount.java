
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 6
 * Date: March 17, 2019
 */

/**
 * The purpose of this class is to create, hold, print, and update the specific
 * parameters of a Chequing Account. It is a subclass of BankAccount abstract
 * class.
 * 
 * @author Patrick Czermak
 * @version 1.1
 * @since JDK 1.8
 */
public class ChequingAccount extends BankAccount {
	/**
	 * Double variable to hold the Chequing Accounts fee. Must be positive and
	 * smaller than account balance.
	 */
	private double fee;

	/**
	 * Default Constructor.
	 */
	public ChequingAccount() {

	}

	/**
	 * Parameterized constructor to define the specific parameters a Chequing
	 * Account must have.
	 * 
	 * @param fee is a double value which must be positive number, and smaller than
	 *            the account balance.
	 */
	public ChequingAccount(double fee) {
		this.fee = fee;
	}

	/**
	 * Method toString prints the properly formatted parameters that are required
	 * for a Chequing Account, invokes the super-class BankAccount toString method
	 * and combined they print the full parameters of a Chequing Account.
	 */
	@Override
	public String toString() {
		return super.toString() + " |Fee: $" + decForm.format(fee);
	}

	/**
	 * Method addBankAccount validates user inputed "fee" before allowing a Chequing
	 * Account to be created. Method is overridden by the superclass BankAccount
	 * toString method, combined they create a Chequing Account.
	 */
	@Override
	public boolean addBankAccount() {
		if (super.addBankAccount()) {
			// Validation of monthly fee input.
			boolean goodFee = false;
			System.out.println("Enter monthly fee: ");
			while (!goodFee) {
				goodFee = true;
				if (!input.hasNextDouble()) { // ensure monthly fee isn't anything other than an actual number.
					System.out.println("INVALID...monthly fee must be a positive number greater or equal to zero!"
							+ " Please re-enter monthly fee:");
					input.next();
					goodFee = false;
					continue; // forces code to re-loop if goodFee found to be false.
				}
				fee = input.nextDouble();
				if (fee < 0) { // ensure monthly fee isn't negative number.
					System.out.println("INVALID...monthly fee must be greater or equal to zero!"
							+ " Please re-enter monthly fee:");
					goodFee = false;
					continue;
				}
			}
			return true;
		}
		return false;
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
			System.out.println("Unable to update account number [" + accountNumber
					+ "] due to insufficient funds! Fee is greater than account balance!");
		}
	}

}
