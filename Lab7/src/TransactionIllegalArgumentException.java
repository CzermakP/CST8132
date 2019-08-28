
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 7
 * Date: March 31, 2019
 */

import java.text.DecimalFormat;

/**
 * The purpose of this class is to extend the IllegalArgumentException so that
 * it can give custom output to console for the user of the bank system.
 * 
 * @author Patrick Czermak
 * @version 1.2
 * @since JDK 1.8
 *
 */
public class TransactionIllegalArgumentException extends IllegalArgumentException {

	/**
	 * private long variable to hold the specific accountNumber specified from
	 * console by user.
	 */
	private Long accountNumber;

	/**
	 * private String variable to hold transaction type for the exception thrown
	 * message.
	 */
	private String withdrawOrDeposit;

	/**
	 * private double variable to hold the specific transaction amount.
	 */
	private double amount;

	/**
	 * private String variable to hold the specific description of the exception
	 * thrown.
	 */
	private String problemDescription;

	/**
	 * private DecimalFormat variable decForm to properly format the output of any
	 * numbers which utilize it.
	 */
	private DecimalFormat decForm = new DecimalFormat("#0.00");

	/**
	 * default serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Parameterized constructor which initializes accountNumber, withdrawOrDeposit,
	 * amount, and problemDescription.
	 */
	public TransactionIllegalArgumentException(Long accountNumber, String withdrawOrDeposit, double amount,
			String problemDescription) {
		this.accountNumber = accountNumber;
		this.withdrawOrDeposit = withdrawOrDeposit;
		this.amount = amount;
		this.problemDescription = problemDescription;
	}

	/**
	 * Method toString() prints an error message to console stating the Exception,
	 * account number, transaction type, and a description of the error.
	 * 
	 * @return stringMsg formatted specific information of the thrown exception and
	 *         details of the account number, transaction type and amount.
	 */
	public String toString() {
		String stringMsg = "TransactionIllegalArgumentException " + "on Account[" + accountNumber + "] "
				+ withdrawOrDeposit + "attempt of $" + decForm.format(amount) + " DENIED! ||ERROR: "
				+ problemDescription + "||";

		return stringMsg;
	}
}
