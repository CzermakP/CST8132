/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 8
 * Date: April 7, 2019
 */

/**
 * The purpose of this class is to hold the main method which creates an
 * instance of class TipCalculatorFrame and sets the GUI to be visible upon
 * program execution.
 * 
 * @author Patrick
 * @version 1.0
 * @since JDK 1.8
 */
public class TipCalculator {

	/**
	 * Launches the GUI Tip Calculator, ensures it is visible when launched.
	 * 
	 * @param args 		UNUSED arguments.
	 */
	public static void main(String[] args) {

		TipCalculatorFrame frame = new TipCalculatorFrame();
		frame.setVisible(true);

	}
}