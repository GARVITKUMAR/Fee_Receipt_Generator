package uNumberLibrary;

import java.util.Scanner;


/**
* <p> Title: UNumberWithSqrt. </p>
* 
* <p> Description: Mainline to support the functionality or the logic of coding to compute the square root using the Newton-Raphson square root method 
*     extends with UNumber</p>
* 
* <p> Copyright: Lynn Robert Carter � 2018-08-11 </p>
* 
* @author  Lynn Robert Carter & Garvit
* 
* @version 1.00	Initial baseline
* 
*/

public class UNumberWithSqrt extends UNumber {
		
	
	
	private static int howManyDigitsMatch2(UNumberWithGetters newGuess, UNumberWithGetters oldGuess, int maxMatchingDigits) {
		// If the characteristics are not the same, the digits in the mantissa do not matter
		if (newGuess.getCharacteristic() != oldGuess.getCharacteristic()) return 0;

		// The characteristic is the same, so fetch the mantissas so we can compare them
		String newGuessStr = newGuess.getMantissa();
		String oldGuessStr = oldGuess.getMantissa();
		// Set the upper limit;
		int maxIterations = maxMatchingDigits;

		// No need to do this because we are working with the mantissa, so there are not decimal points
		for (int ndx = 0; ndx<15; ndx++) {
			if (newGuessStr.charAt(ndx) == '.') {
				String start = newGuessStr.substring(0, ndx);
				String rest = newGuessStr.substring(ndx+1);
				newGuessStr = start + rest;
				break;
			}
		}

		for (int ndx = 0; ndx<maxMatchingDigits; ndx++) 
			if (oldGuessStr.charAt(ndx) == '.') {
				String start = oldGuessStr.substring(0, ndx);
				String rest = oldGuessStr.substring(ndx+1);
				oldGuessStr = start + rest;
				break;
			}
		

		// Loop through the digits as long as they match
		for (int ndx = 0; ndx < maxIterations; ndx++) {
			if (oldGuessStr.charAt(ndx) != newGuessStr.charAt(ndx)) return ndx;
		}

		// If the loop completes, we consider all 15 to match
		return maxMatchingDigits;
	}
	
	
	
public static void sqrt(String input, Scanner keyboard){

	while (input.length() > 0) {
		System.out.println("*****************************************************");
		
		// Produce a scanner from the input so we can fetch a double value from it
		Scanner value = new Scanner(input);
		
		// Does this input line consist of a value?
		if (value.hasNextDouble()) {
			
			// As long as there is another double value, compute the square root of it
			double inputValue = value.nextDouble();
			
			System.out.print("The value to be used: ");
			System.out.println(inputValue);

			System.out.println("\n     *****************************************************");
			//System.out.println("\n     Compute the Square Root using double values\n");

			// Set up the values for the loop
			double theValue = inputValue;							// We will compute the square root of this value
			
			double two = 2.0;										// This is the constant 2.0
			
		
			double oldGuess;										// Temporary value for determining when to terminate the loop
				
			int numSigDigits = 25;									// This is for computing results using UNumber values
			
			//System.out.println("\n     *****************************************************");
			System.out.println("\n     Compute the Square Root using UNumber values to " + numSigDigits + " significant digits\n");

			// Set up the values for the loop
			UNumberWithGetters theValue2 = new UNumberWithGetters(inputValue);	// We will compute the square root of this value
			theValue2 = new UNumberWithGetters(theValue2, numSigDigits);
			
			UNumberWithGetters two2 = new UNumberWithGetters(2.0);				// This is the constant 2.0
			two2 = new UNumberWithGetters(two2, numSigDigits);
			
			UNumberWithGetters newGuess2 = new UNumberWithGetters(theValue);	// Compute the the first estimate
			newGuess2 = new UNumberWithGetters(newGuess2, numSigDigits);
			newGuess2.div(two2);							
			
			//System.out.print("\n     The first estimate to be used: ");			// Display the first estimate

			//System.out.println(newGuess2.toDecimalString() + "\n");				
			
			UNumberWithGetters oldGuess2;										// Temporary value for determining when to terminate the loop
			
			int iteration = 0;														// This is used to count the number of iterations
			
			int digitsMatch = 0;													// This used to hold the number of matching significant digits
			
		//	System.out.println("     0 estimate " + newGuess2.toDecimalString());	// Display the first estimate
			
			do {
				long start = System.nanoTime();									// Capture the start time for this iteration
				
				iteration++;													// Next iteration, so count it
				
              	oldGuess2 = newGuess2; //save the oldGuess2

				newGuess2 = new UNumberWithGetters(theValue2); //store theValue2 in the newGuess2
				
				newGuess2.div(oldGuess2);newGuess2.add(oldGuess2);newGuess2.div(two2); //compute the newGuess2
				
				long stop = System.nanoTime();									// Capture the stop time for this iteration
				
				digitsMatch = howManyDigitsMatch2(newGuess2, oldGuess2, numSigDigits);	// Determine how many digits match
				
			//	System.out.println("     " + iteration + " estimate " + newGuess2.toDecimalString() + " with " + digitsMatch + " digits matching taking " + (stop-start)/1000000000.0 + " seconds" );		// Display the intermediate result
									
			} while (digitsMatch < numSigDigits);								// Determine if the old and the new guesses are "close enough"

			System.out.println("\n     The square root");
			System.out.println("     " + newGuess2.toDecimalString());			// Display the final result
			UNumberWithGetters resultSquared2 = new UNumberWithGetters(newGuess2);
			resultSquared2.mpy(newGuess2);
			System.out.println("\n     The square of the computed square root.  (It should be *very* close to the input value!):");
			System.out.println("     " + resultSquared2.toDecimalString());		// Display the result squared

		}
		
		// Ask for more input
		System.out.println("*****************************************************");
		System.out.print("\nEnter a double value or just press return (enter) to stop the loop: ");
		input = keyboard.nextLine().trim();
		value.close();
	}
	// An empty input line has been entered, so the tell the user we are stopping
	System.out.print("Empty line detected... the program stops");
	keyboard.close();
	
}


}
