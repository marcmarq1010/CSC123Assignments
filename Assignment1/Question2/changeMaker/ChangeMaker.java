package changeMaker;

import UI.Messages2;

public class ChangeMaker 
{
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int dollars;
    private int cents;
    private int amount;
    
    public ChangeMaker(int dollars, int cents) 
    {
        this.dollars = dollars;
        this.cents = cents;
        this.amount = dollars * 100 + cents;
        setQuarters();
        setDimes();
        setNickels();
        setPennies();
        Messages2.formatAmountString(this.dollars, this.cents, quarters, dimes, nickels, pennies);
    }
    
    public void setPennies() 
    {
        this.pennies = amount / 1;
    }
    
    public void setNickels() 
    {
        this.nickels = amount / 5;
        amount = amount % 5;
    }
    
    public void setDimes() 
    {
        this.dimes = amount / 10;
        amount = amount % 10;
    }
    
    public void setQuarters() 
    {
        this.quarters = amount / 25;
        amount = amount % 25;
    }

	public int getPennies() 
	{
		return pennies;
	}

	public int getNickels() 
	{
		return nickels;
	}

	public int getDimes() 
	{
		return dimes;
	}

	public int getQuarters() 
	{
		return quarters;
	}

	public int getCents() 
	{
		return cents;
	}  

	public int getDollars() 
	{
		return dollars;
	}
	
    
}
