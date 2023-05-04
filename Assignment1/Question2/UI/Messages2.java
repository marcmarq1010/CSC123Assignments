package UI;

public class Messages2 
{
	// User input
	public static final String ENTER_DOLLAR_AMOUNT = "Please enter your amount in dollars: ";
	public static final String ENTER_CENT_AMOUNT = "Please enter your amount in cents: ";
	
	// Output
	public static String DOLLAR_AMOUNT;
	public static String CENT_AMOUNT;
	public static String QUARTERS_AMOUNT;
	public static String DIMES_AMOUNT;
	public static String NICKELS_AMOUNT;
	public static String PENNIES_AMOUNT;
	
	public static  void formatAmountString(int dollars, int cents, int quarters, int dimes, int nickels, int pennies) 
	{
         DOLLAR_AMOUNT = dollars == 1 ? "%d dollar and " : "%d dollars and ";
         CENT_AMOUNT = cents == 1 ? "%d cent is: " : "%d cents are: ";
         
         QUARTERS_AMOUNT = quarters == 1 ? "%d quarter, " : "%d quarters, ";
         DIMES_AMOUNT = dimes == 1 ? "%d dime, " : "%d dimes, ";
         NICKELS_AMOUNT = nickels == 1 ? "%d nickel, " : "%d nickels, ";
         PENNIES_AMOUNT = pennies == 1 ? "%d penny." : "%d pennies.";
    }
}
