package test;

import UI.InputHelper;
import UI.Messages;
import coin.CoinCounter;

public class CoinCounterTest 
{
	public static void main(String[] args)
	{
		InputHelper ui = new InputHelper();
		CoinCounter cc = new CoinCounter(ui.getInt(Messages.ENTER_PENNIES), ui.getInt(Messages.ENTER_NICKELS), ui.getInt(Messages.ENTER_DIMES), ui.getInt(Messages.ENTER_QUARTERS));
		
		System.out.printf(Messages.DOLLAR_AMOUNT, cc.getDollars(), cc.getCents());
		System.out.println(Messages.CENT_AMOUNT);
	}
}
