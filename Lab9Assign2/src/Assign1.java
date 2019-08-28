
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 9 / Assignment 2
 * Date: April 18, 2019
 */

/**
 * The purpose of this Class is to hold method main, which has the user menu
 * options. Each menu option calls the appropriate method from Bank class.
 * 
 * @author Patrick Czermak
 * @version 1.3
 * @since JDK 1.8
 *
 */
public class Assign1 {

	/**
	 * Default Constructor
	 */
	public Assign1() {

	}

	/**
	 * Method main launches the GUI, sets the size and makes it visible to 
	 * screen once launched.
	 * 
	 * @param args UNUSED - command line arguments.
	 */
	public static void main(String[] args) {
		BankSimulatorFrame bankSimFrame = new BankSimulatorFrame(); // creating instance of BankSimulatorFrame Class
		bankSimFrame.setSize(850, 600); // setting GUI size
		bankSimFrame.setVisible(true); // setting the GUI to be visible upon program launch
	}
}
