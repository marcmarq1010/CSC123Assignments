package test;

import UI.InputHelper;
import UI.Messages;
import invertedString.InvertedString;

public class InvertedStringTest 
{
	public static void main(String[] args)
	{
		InputHelper ui = new InputHelper();
		InvertedString ns = new InvertedString(ui.getString(Messages.ENTER_STRING));
		
		System.out.printf(Messages.ORIGINAL_STRING, ns.getString());
		System.out.println("");
		System.out.printf(Messages.INVERTED_STRING, ns);
	}
}
