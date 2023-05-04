package UI;

public class Messages 
{
	// User input
	public static final String ENTER_PENNIES = "Please enter the number of pennies: ";
	public static final String ENTER_NICKELS = "Please enter the number of nickels: ";
	public static final String ENTER_DIMES = "Please enter the number of dimes: ";
	public static final String ENTER_QUARTERS = "Please enter the number of quarters: ";
	
	// Output
	public static String DOLLAR_AMOUNT;	
	public static String CENT_AMOUNT;	
	
	public static  void formatAmountString(int dollars, int cents) 
	{
         DOLLAR_AMOUNT = dollars == 1 ? "You have %d dollar and %d" : "You have %d dollars and %d ";
         CENT_AMOUNT = cents == 1 ? "cent." : "cents.";
    }
}
