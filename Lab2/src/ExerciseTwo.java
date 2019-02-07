/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 2
 * Date: January 25, 2019
 */


public class ExerciseTwo {
	private int [][] myArray;	// Instance variable myArray.
	
	public static void main(String[] args) {
		ExerciseTwo ET = new ExerciseTwo();		// Object instance of constructor ExerciseTwo.
		ET.printArrayValues();					// Calling method printArrayValues.
		ET.printArrayTotal();					// Calling method printArrayTotal.
	}
	
	
	// CONSTRUCTOR which initializes and instantiates myArray with 6 arrays of 10 elements each,
	// and uses for-loop to fill myArray with elements of 1-60.
	public ExerciseTwo() {
		myArray = new int[6][10];								// Initializing myArray to size of 6 arrays each holding 10 elements.
		for (int i = 0; i < myArray.length; i++) {				// Loop to fill myArray with 6 arrays.
			for (int j = 0; j < myArray[i].length; j++) {		// Loop to fill each of the 6 arrays with 10 values.
				myArray[i][j] = i * 10 + j +1;					// Ensures that each array within myArray is filled subsequently from 1-60.
			}
		}
	}
	
	
	// METHOD to print out all of the values in each of the 6 arrays within myArray.
	public void printArrayValues() {
		System.out.println("myArray = {");					// Prints "myArray = {".
		for (int i = 0; i < myArray.length; i++) {			// Loop to go through each of the 6 rows in the arrays in myArray.
			System.out.print("{");							// Prints "{".
			for (int j = 0; j < myArray[0].length; j++) {	// Loop to go through each element in each array within myArray.
				System.out.print(myArray[i][j]);			// Prints myArray.
				if (j < 9)									// Ensures that NO "," is printed after the last element in each array.
				System.out.print(",");						// Prints "," between each element within each of the 6 arrays.
			}
			System.out.print("}");							// Prints "}" at the end of each of the 6 arrays.
			if (i < 5) 										// Ensures that NO "," is printed after the last(6th) array within myArray.
			System.out.print(",");							// Prints ",".
			System.out.println();							// Prints on new line only after i
		}
		System.out.println("};");							// Prints "};" on a new line after myArray has been printed.
	}
	
		
	public void printArrayTotal() {  		
		int total =0;						// Initializing variable "total" to lowest value for use in this method.
		for (int [] row : myArray) {		// Enhanced for loop which creates a "row" array that holds the first dimension of 2d array(rows).
		    for ( int column : row) {		// Enhanced for loop which creates variable "column" that holds all values of the second dimension(columns).
		     total += column;				// Variable "total" adds each value from variable "column" and consecutively adds them together. 
		    }
		}
		System.out.print("The sum of all elements of myArray is " + total + ".");	//	Prints a phrase followed by the total sum of myArray.	
	}
}
