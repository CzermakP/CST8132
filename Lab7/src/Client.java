
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 7
 * Date: March 31, 2019
 */

/**
 * Client class defines a Client used within a bank account.
 * 
 * @author Patrick Czermak
 * @version 1.2
 * @since JDK 1.8
 */
public class Client {
	/**
	 * String variable to hold the first name, case insensitive, must be a string
	 * value.
	 */
	private String firstName;

	/**
	 * String variable to hold the last name, case insensitive, must be a string
	 * value.
	 */
	private String lastName;

	/**
	 * String variable to hold the email address, must be at a minimum [cc@cc.cc].
	 */
	private String emailAddress;

	/**
	 * Parameterized Constructor which specifies the variables required to create a
	 * Client.
	 * 
	 * @param firstName    is a case insensitive String value.
	 * @param lastName     is a case insensitive String value.
	 * @param emailAddress is a String value that must be in the minimum form of
	 *                     "cc@cc.cc".
	 */
	public Client(String firstName, String lastName, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	/**
	 * Method that gets and returns first name String.
	 * 
	 * @return firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method that gets and returns last name String.
	 * 
	 * @return lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method that gets and returns email address String.
	 * 
	 * @return emailAddress.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

}
