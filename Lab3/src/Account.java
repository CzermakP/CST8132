/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 3
 * Date: February 3, 2019
 */

import java.util.Random;

public class Account {
	// attributes of an Account.
	private long accountNum;
	private Client client;
	private double balance;
	
	/* CONSTRUCTOR which makes an Account, which consists of Client and balance info which it
	 *  gets from user's input gathered in Bank Class.
	 */
	public Account(Client client, double balance) {		
		Random RD = new Random();
		accountNum = RD.nextLong();
		while (accountNum <= 0 ) { //loop to ensure the generated number is NOT negative or 0.
			accountNum = RD.nextLong();
		}
		this.client = client; 
		this.balance = balance; 
	}
	
	/*
	 * METHOD to deposit into the Account.
	 */ 
	public void deposit(double amt) { 
		balance += amt;		
	}
	
	/*
	 * METHOD to withdraw from the Account, with condition that limits withdraw amount to the balance in the account.
	 */ 
	public boolean withdraw(double amt) {
		if (amt <= balance) { 
			balance -= amt;
			return true;			
		}else {
			 return false;
		}		
	}
	
	/*
	 * METHOD to get and return the randomly generated Account Number.
	 */
	public long getAccountNum() {
		return accountNum;	
	}
	
	/*
	 * METHOD to get and return the Client class.
	 */
	public Client getClient() {
		return client;		
	}
	
	/*
	 * METHOD to get and return the balance of the Account.
	 */
	public double getBalance() {
		return balance;		
	}
	
	/*
	 * METHOD to get and return the Clients name from the Client class.
	 */
	public String getName() {
		return client.getName(); //calls getName method of the client, and returns resulting Strings.				
	}
	
}
