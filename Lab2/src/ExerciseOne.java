/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 2
 * Date: January 25, 2019
 */


import java.text.DecimalFormat;

public class ExerciseOne {

	private int [] myArray; // instance variable "myArray"
	DecimalFormat DF = new DecimalFormat("0,000");

	public static void main(String[] args) {
		ExerciseOne EO = new ExerciseOne();		// Object instance of constructor ExerciseOne. 
		EO.printArrayValues();					// Calling method printArrayValues.
		EO.displayArrayProduct();				// Calling method displayArrayProduct
	}

	
	// CONSTRUCTOR which initializes and instantiates myArray with an amount of 10,
	// and uses for-loop to fill myArray with elements of 1-10.
	public ExerciseOne() {
		myArray = new int[10];							// Initializing myArray to size of 10.
		for (int i = 0; i < myArray.length; i++) {		// Loop to fill myArray with elements 1-10 in indexes/positions 0-9.
			myArray[i] = i + 1;							// Places the elements in the correct index as myArray starts at 1 NOT 0.
		}
	}
	
	
	//METHOD to print out the values of the elements in myArray.
	public void printArrayValues() {
		System.out.print("myArray = {");	// Prints "myArray = {".
		for (int i = 0; i <= 9; i++) {		// Loop to go through each element in myArray.
			System.out.print(myArray[i]);	// Prints each myArray element value.
			if(i < 9) {						// If statement to ensure there is NO "," printed after the last myArray element value.
			System.out.print(",");			// Prints "," in-between each myArray element value.
			}
		}
		System.out.println("}");			// Prints "}" after the last/10th myArray element.		
	}
	
	
	//METHOD to print the sum/product of elements in myArray.
	public void displayArrayProduct() {
		int product = 1;					// Initializing variable "product".
		for (int column: myArray) {			// Enhanced for loop which loops through each value in myArray and holds them in variable "column".
			product *= column;				// Multiplies each value of myArray as looping through and holds result in variable "column".
		}
		System.out.println("The product of all elements of myArray is " + DF.format(product) + ".");	// Prints phrase and the "product" of 
	}																									// myArray properly formatted using 												
}																										// DecimalFormat.
