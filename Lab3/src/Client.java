/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 3
 * Date: February 3, 2019
 */

public class Client {
	//attributes of a Client.
	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;
	
	/*
	 * CONSTRUCTOR - makes a Client template.
	 */
	public Client(String firstName, String lastName, long phoneNum, String email) {	
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	/*
	 * METHOD to get and return Client firstName concatenated with lastName (space in-between).
	 */
	public String getName() {
		return firstName + " " + lastName;
	}
	
	/*
	 * METHOD to get and return Client phone number.
	 */
	public long getPhoneNum() {
		return phoneNum;		
	}
	
	/*
	 * METHOD to get and return Client email.
	 */
	public String getEmail() {
		return email;
	}
}
