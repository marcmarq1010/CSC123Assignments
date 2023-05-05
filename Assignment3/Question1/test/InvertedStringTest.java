package test;

import UI.InputHelper; // Import the InputHelper class from the UI package
import UI.Messages; // Import the Messages class from the UI package
import invertedString.InvertedString; // Import the InvertedString class from the invertedString package

public class InvertedStringTest 
{
	public static void main(String[] args) 
	{
		// Create an instance of the InputHelper class to get user input
		InputHelper ui = new InputHelper();
		// Create a new instance of the InvertedString class and pass in a string entered by the user
		InvertedString ns = new InvertedString(ui.getString(Messages.ENTER_STRING));
		
		// Print a message containing the original string entered by the user
		System.out.printf(Messages.ORIGINAL_STRING, ns.getString());
		System.out.println(""); // Print a blank line
		
		// Print a message containing the inverted string returned by the `toString()` method of the InvertedString class
		System.out.printf(Messages.INVERTED_STRING, ns);
	}
}
