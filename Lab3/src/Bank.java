
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 3
 * Date: February 2, 2019
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Bank {
	// attributes of a Bank.
	private String bankName;
	private Account[] accounts;
	private Scanner input;

	/*
	 * CONSTRUCTOR: which prompts user for their banking info(first/last name, phone
	 * number, email) and creates a new object of Client with that info. Then
	 * prompts user for opening balance and creates a new Account array with the
	 * Client object and the opening balance info.
	 */
	public Bank() {
		input = new Scanner(System.in);
		System.out.print("Enter the Bank Name: "); 
		bankName = input.nextLine(); 
		int numOfAcc = 0;
		System.out.print("How many accounts? "); 
 
		/*
		 * Positive integer check for Number of Accounts.Use a while loop which first
		 * checks to ensure number is an integer using .hasNext() to force the input if
		 * the scanner buffer is empty. then to ensure number is and actual integer
		 * value used .hasNextInt() within an if statement. I used this technique
		 * because it continuously loops until the user enters a positive integer value.
		 * 
		 * ** NOTE: Scanner methods of "hasNext" and "hasNextInt" do NOT advance the
		 * Scanner buffer.
		 */
		while (input.hasNext()) { // WHILE LOOP on the next Scanner input (hasNext() forces input if the Scanner
									// buffer is empty.
			if (!input.hasNextInt()) { // check if the Scanner buffer character is actually an int.
				System.out.println("ERROR...ENTER AN INTEGER NUMBER: ");
				System.out.print("How many accounts? "); 
				input.next(); // Force Scanner buffer to empty, so WHILE LOOP hasNext() forces an input.
			} else {
				numOfAcc = input.nextInt(); // know have an int, so assign it (nextInt() has already forced the
											// Scanner buffer ahead).
				if (numOfAcc <= 0) {
					System.out.println("ERROR...ENTER A POSITIVE INTEGER NUMBER: ");
					System.out.print("How many accounts? ");
				} else {
					break;
				}
			}
		}
		accounts = new Account[numOfAcc]; // initializing array with user's input of specified number of accounts.
		Client C; // create new Client object with users inputed info.
		System.out.println();
		for (int counter = 0; counter < accounts.length; counter++) { 
			System.out.println("Account: " + (counter + 1));
			System.out.print("\t\tWhat is the Client's first name? ");
			String firstName = input.next();
			System.out.print("\t\tWhat is the Client's last name? ");
			String lastName = input.next();
			System.out.print("\t\tWhat is the Client's phone number? ");
			Long phoneNum = input.nextLong();
			/*
			 * Email validation (uses my created method which checks for special characters)
			 * to ensure user entered email consists of only one "@" and at least one "."
			 * after the "@". Used a boolean to check against within a while loop to ensure
			 * the inputed email consists of two characters minimum and one "@". For loop to
			 * go through the inputed email address and checks it has minimum of 2
			 * characters at beginning until it finds only one "@", then using substring for
			 * the right side of the "@" i check for at least one "." using a for loop, if
			 * found it breaks out of loop and continues down the code, or if none found it
			 * displays an error message, and prompts again. I used this technique because
			 * it continues to loop until only one "@" is found and a minimum of one "."
			 * after the "@" is found. Ensures that an accurate email address is entered by
			 * the user. MY version of a correct email address is a minimum of 2 characters
			 * before the @ symbol, only one @ symbol. 2 characters after the @ symbol
			 * before a ".", and can have multiple "." as needed(true to real life). 
			 * [ex:patrickczermak@algonquin.cst.com].
			 */
			String email = null;
			boolean emailGood = false;
			while (!emailGood) {
				// reset the boolean to false if have to re-loop for re-entering the email
				// address.
				emailGood = true;
				System.out.print("\t\tWhat is the Client's email address? ");
				email = input.next();
				// check 2 characters at beginning of email and for "@" using loop to iterate 
				// through string and increment @ counter.
				int atSymbols = 0; // used to check for "@".
				int atSymbolLocation = 0; //used for "@" location.
				int minNumChars = 0; //used for minimum number of characters at start of email.
				for (int i = 0; i < email.length(); i++) {
					if (!isSpecialCharacter(Character.toString(email.charAt(i)))) {
						minNumChars++;
						if (email.charAt(i) == '@') {
							atSymbolLocation = i;
							atSymbols++;
						}
					} else {
						emailGood = false;
						System.out.println("\t\tERROR...INVALID EMAIL");
					}
				}
				if (emailGood) {
					if (minNumChars < 3 || atSymbols > 1 || atSymbols == 0) {
						// know there is more than one "@", or none, set boolean false and re-loop.
						emailGood = false;
						System.out.println("\t\tERROR...INVALID EMAIL");
					} else {
						// now know there is ONLY one @ symbol, so next getting the right-side of the
						// @ symbol and making sure the first two characters after it NOT a special
						// character.
						if (!isSpecialCharacter(Character.toString(email.charAt(atSymbolLocation + 1)))
								&& !isSpecialCharacter(Character.toString(email.charAt(atSymbolLocation + 2)))) {
							String atRightSide = email.substring(atSymbolLocation + 3, email.length());
							int decimals = 0;
							for (int i = 0; i < atRightSide.length(); i++) { //check for at least 1 "." using.
								if (atRightSide.charAt(i) == '.') {
									decimals++;
									break;
								}
							}
							if (decimals == 0) {
								emailGood = false;
								System.out.println("\t\tERROR...INVALID EMAIL");
							}
						} else {
							emailGood = false;
							System.out.println("\t\tERROR...INVALID EMAIL");
						}
					}
				}
			}
			C = new Client(firstName, lastName, phoneNum, email); // new object of Client holds user's inputed info. 
			System.out.print("\t\tWhat is your opening balance? ");
			double balance = input.nextDouble();
			accounts[counter] = new Account(C, balance); // filling array with Client info and balance.
			System.out.println();
		}
	}
	
	/*
	 * Method to check for special characters....utilized in email validation 
	 * in constructor.
	 */
	private boolean isSpecialCharacter(String ch) {
		if (ch.equals("!")) {
			return true;
		} else if (ch.equals("#")) {
			return true;
		} else if (ch.equals("$")) {
			return true;
		} else if (ch.equals("%")) {
			return true;
		} else if (ch.equals("^")) {
			return true;
		} else if (ch.equals("&")) {
			return true;
		} else if (ch.equals("*")) {
			return true;
		} else if (ch.equals("(")) {
			return true;
		} else if (ch.equals(")")) {
			return true;
		} else if (ch.equals("{")) {
			return true;
		} else if (ch.equals("}")) {
			return true;
		} else if (ch.equals("[")) {
			return true;
		} else if (ch.equals("]")) {
			return true;
		} else if (ch.equals("?")) {
			return true;
		}
		return false;
	}
	
	/*
	 * METHOD to print each Account's info which is in the accounts array. Method
	 * chaining done in order to obtain info from class Account and Client.
	 */
	public void printAccounts() {
		DecimalFormat DF = new DecimalFormat();
		System.out.println("Bank name: " + bankName);
		for (int counter = 0; counter < accounts.length; counter++) {
			System.out.print("Account: " + accounts[counter].getAccountNum());
			System.out.print(" | Name:" + accounts[counter].getClient().getName());
			System.out.print(" | Phone Number:" + accounts[counter].getClient().getPhoneNum());
			System.out.print(" | Email:" + accounts[counter].getClient().getEmail());
			System.out.println(" | Balance:$" + DF.format(accounts[counter].getBalance()));
		}
	}

	/*
	 * MAIN METHOD which creates an object of class Bank. And to give user a
	 * interactive menu to view account info. Withdraw, and deposit from/to a
	 * specified account.
	 */
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		DecimalFormat DF = new DecimalFormat();
		Bank B = new Bank();
		char userOption = ' ';
		while (!(userOption == 'q')) {
			System.out.println();
			System.out.println("Choose an OPTION: ");
			System.out.println("P = VIEW account info");
			System.out.println("W = WITHDRAW from account");
			System.out.println("D = DEPOSIT into account");
			System.out.println("Q = QUIT Bank");
			userOption = input.next().toLowerCase().charAt(0);
			switch (userOption) {
			case 'p': {
				B.printAccounts();
				break;
			}
			case 'w': {
				System.out.print("From which account? ");
				int accNum = input.nextInt() - 1;
				while (accNum < 0) {
					System.out.println("ERROR...must choose from one of the created accounts!");
					System.out.print("From which account? ");
					accNum = input.nextInt() - 1;
				}
				System.out.print("Amount to withdraw? ");
				double withdraw = input.nextDouble();
				while (withdraw <= 0) {
					System.out.println("ERROR...withdrawls must be a positive number!");
					System.out.print("Amount to withdraw? ");
					withdraw = input.nextDouble();
				}
				if (!B.accounts[accNum].withdraw(withdraw)) {
					System.out.println("Insufficient Funds! Balance is $" + DF.format(B.accounts[accNum].getBalance()));
					System.out.print("Amount to withdraw? ");
					withdraw = input.nextDouble();
				} else {
					System.out.println("Successfully withdrawn!");
				}
				break;
			}
			case 'd': {
				System.out.print("Deposit into which account? ");
				int accNum = input.nextInt();
				while (accNum <= 0) {
					System.out.println("ERROR...must choose from one of the created accounts!");
					System.out.print("Deposit into which account? ");
					accNum = input.nextInt();
				}
				System.out.print("Amount to deposit? ");
				double deposit = input.nextDouble();
				while (deposit <= 0) {
					System.out.println("ERROR...deposits can only be a positive amount!");
					System.out.print("Amount to deposit? ");
					deposit = input.nextDouble();
				}
				B.accounts[accNum - 1].deposit(deposit);
				System.out.println("Successfully deposited!");
			}
				break;
			}
		}
	}

}
