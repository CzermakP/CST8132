/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 1
 * Date: January 16, 2019
 */

// Program prints 4 differently shaped triangles in concession.
public class CST8132_Czermak_Patrick_Lab1 {

	public static void main(String[] args) {
		 int numRows = 5; // variable which holds the value for the NUMBER of ROWS.

		// TRIANGLE 1
		for (int i = 1; i <= numRows; i++) {	// Loop for the NUMBER of ROWS to be printed. Starts at index "i", numRows=5, and for
												// each loop iteration index "i" is increased by 1... Hence (1,2,3,4,5).			
			System.out.print(" ");				// Prints an indent/tab space first through each loop to ensure each line is
												// indented/tab'd.			
			for (int k = numRows; k > i; k--) { // Loop - for blank SPACES in a ROW. each loop iteration will print
												// the amount of blank spaces until the inner index "k" is greater than
												// the outer index "i".				
				System.out.print(" ");			// Prints blank SPACE.
			}
			for (int j = 1; j <= i; j++) {		// Loop - for dollar signs printed in a COLUMN. As long as index "j" <= index "i" (j=1, and
												// i=numRows(5)), for each loop iteration index "j" is less than index "i", so index "j"
												// increases each loop.											
				System.out.print("$");			// Prints dollar sign.
			}
			System.out.println(); 				// Prints to a new line after each loop iteration.
		}
		System.out.println(); 					// Prints blank line between TRIANGLES 1 & 2.
		
		
		// TRIANGLE 2
		for (int i = 1; i <= numRows; i++) { 	// Loop for the NUMBER of ROWS to be printed. Starts at index "i", numRows=5, and for
												// each loop iteration index "i" is increased by 1... Hence (1,2,3,4,5).
			System.out.print(" "); 				// Prints an indent/tab space first through each loop to ensure each line is
												// indented/tab'd.
			for (int j = 1; j <= i; j++) { 		// Loop - for dollar signs printed in a COLUMN. Starts at index "j"(1), 
												// because "j<=i", for each loop iteration index "j" will get larger by 1(larger
												// than index i). Each loop iteration the amount of "$" printed will increase
												// by 1 until the "outer for-loop" hits "numRows".
				System.out.print("$"); 			// Prints dollar sign.
			}
			System.out.println(); 				// Prints to a new line after each loop iteration.
		}
		System.out.println(); 					// Prints blank line between TRIANGLES 2 & 3.
			

		// TRIANGLE 3
		for (int i = numRows; i > 0; i--) {		// Loop for the NUMBER of ROWS to be printed. Starts at index "i"(numRows), and for
												// each loop iteration index "i" is decreased by 1... Hence (5,4,3,2,1)												
			System.out.print(" "); 				// Prints an indent/tab space first through each loop to ensure each line is
												// indented/tab'd.
			for (int k = numRows; k > i; k--) { // Loop - for blank SPACES in a ROW. each loop iteration will print
												// the amount of blank spaces until the inner index "k" is greater than
												// the outer index "i".
				System.out.print(" "); 			// Prints blank SPACE.
			}
			for (int j = 1; j <= i; j++) { 		// Loop - for dollar signs printed in a COLUMN. As long as index "j" <=index "i" (j=1, and
												// i=numRows(5)), for each loop iteration index "j" is less than index "i", so index "j"
												// increases each loop.											
				System.out.print("$");			// Prints dollar sign.
			}
			System.out.println(); 				// Prints to a new line after each loop iteration.
		}
		System.out.println();					// Prints blank line between TRIANGLES 3 & 4.
				

		// TRIANGLE 4
		for (int i = 1; i <= numRows; i++) {		// Loop for the NUMBER of ROWS to be printed. Starts at index "i", and for
													// each loop iteration index "i" is decreased by 1... Hence (5,4,3,2,1).
			System.out.print(" ");					// Prints an indent/tab space first through each loop to ensure each line is
													// indented/tab'd.
			for (int j = numRows; j >= i; j--) {	// Loop - for dollar signs printed in a COLUMN. Starts at index "j"(numRows),
													// as long as j>=i (i=1), each loop iteration index "j" decreases by 1, so "$"
													// printed starts at 5 the first loop and decreases by 1 each loop iteration
													// until the "outer for-loop" hits "1".												 
				System.out.print("$");				// Prints dollar sign.
			}									
			if (i < numRows) {						// Print on a new line while index "i" is LESS THAN but NOT EQUAL to numRows
				System.out.println();				// which ensures NO last "empty line" printed after the triangle.
			}										 
		}
	}
}
