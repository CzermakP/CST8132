
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 5/Assignment 1
 * Date: March 3, 2019
 */


/**
 * Person class defines a Person used within a bank account.
 * @author Patrick Czermak
 * @version 1.0
 * @since JDK 1.8
 */
public class Person {
	/**
	 * String variable to hold the first name, case insensitive, must be a string value. 
	 */
	private String firstName;
	/**
	 * String variable to hold the last name, case insensitive, must be a string value.
	 */
	private String lastName;
	/**
	 * String variable to hold the phone number, must be a number either 10 or 11 digits in length.
	 */
	private String phoneNumber;
	/**
	 * String variable to hold the email address, must be at a minimum [cc@cc.cc].
	 */
	private String emailAddress;
	
	
	/**
	 * Parameterized Constructor which specifies the variables required to create a Person.
	 * @param firstName		is a case insensitive String value.
	 * @param lastName		is a case insensitive String value.
	 * @param phoneNumber	is a String value that must be 10 or 11 numbers in length. 
	 * @param emailAddress	is a String value that must be in the minimum form of "cc@cc.cc".
	 */
	public Person(String firstName, String lastName, String phoneNumber, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;	
	}
	
	
	/**
	 * Method that gets and returns first name String. 
	 * @return firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	
	/**
	 * Method that gets and returns last name String.
	 * @return lastName.
	 */
	public String getLastName() {
		return lastName;
	}
	
	
	/**
	 * Method that gets and returns phone number String.
	 * @return phoneNumber.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	/**
	 * Method that gets and returns email address String.
	 * @return emailAddress.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	
}
