package coin;

import UI.Messages;

public class CoinCounter 
{
	private int pennies;
	private int nickels;
	private int dimes;
	private int quarters;
	private int dollars;
	private int cents;
	
	private final int pennyValue = 1;
	private final int nickelValue = 5;
	private final int dimeValue = 10;
	private final int quarterValue = 25;
	
	private int amount;
	
	public CoinCounter(int pennies, int nickels, int dimes, int quarters)
	{
		this.pennies = pennies;
		this.nickels = nickels;
		this.dimes = dimes;
		this.quarters = quarters;
		setAmount();
		setDollars();
		setCents();
		Messages m = new Messages();
		m.formatAmountString(dollars, cents);
	}
	
	public void setAmount()
	{
		amount = (pennies * pennyValue) + (nickels * nickelValue) + (dimes * dimeValue) + (quarters * quarterValue);
	}

	public int getDollars() 
	{
		return dollars;
	}

	public void setDollars() 
	{
		this.dollars = amount / 100;
	}

	public int getCents()
	{
		return cents;
	}

	public void setCents() 
	{
		this.cents = amount % 100;
	}

	
}
