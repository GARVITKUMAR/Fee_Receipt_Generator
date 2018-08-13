package MainFile;

import java.util.Scanner;

import uNumberLibrary.UNumberWithGetters;
import uNumberLibrary.UNumberWithSqrt;

/**
 * <p> Title: Sq_Root </p>
 * 
 * <p> Description: Mainline to support the exercise of coding the Newton-Raphson square root method  with UNumber</p>
 * 
 * <p> Copyright: Lynn Robert Carter � 2018-08-11 </p>
 * 
 * @author Lynn Robert Carter & Garvit Kumar
 * 
 * @version 1.0 - Initial baseline
 * 
 */

public class Sq_Root {
	
	private static int getCharacteristic(double x) {
		return (((int)Math.log10(x)) + 1);
	}
	
	
	/*****
	 * This private method counts how many digits are the same between two estimates
	 */
		
	/*****
	 * This private method counts how many digits are the same between two estimates
	 */
	
	/*****
	 * This is the mainline 
	 * 
	 * @param args	The program parameters are ignored
	 */

	public static void main(String [] args) {
		
		
		Scanner keyboard = new Scanner(System.in); // to set up keyboard as a the scanner object 
	
		System.out.println("Author:Garvit");
		System.out.println("Enter a double value to find the square root: ");

		String input = keyboard.nextLine().trim(); //  to Fetch the input from the user
UNumberWithSqrt.sqrt(input,keyboard);
}}