package dice;

import java.util.Random;

public class Dice 
{
	private int value;
	
	public Dice()
	{
		
	}

	public void cast()
	{
		Random rand = new Random();
		
		value = rand.nextInt(6) + 1;
	}
	
	public int getValue() 
	{	 
		return value;
	}
}
