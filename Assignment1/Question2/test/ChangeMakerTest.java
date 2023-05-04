package test;

import UI.InputHelper;
import UI.Messages2;
import changeMaker.ChangeMaker;

public class ChangeMakerTest 
{
	public static void main(String[] args)
	{
		InputHelper ui = new InputHelper();
		ChangeMaker cm = new ChangeMaker(ui.getInt(Messages2.ENTER_DOLLAR_AMOUNT), ui.getInt(Messages2.ENTER_CENT_AMOUNT));
		
		System.out.printf(Messages2.DOLLAR_AMOUNT, cm.getDollars());
		System.out.printf(Messages2.CENT_AMOUNT, cm.getCents());
		System.out.println("");
		System.out.printf(Messages2.QUARTERS_AMOUNT + Messages2.DIMES_AMOUNT + Messages2.NICKELS_AMOUNT + Messages2.PENNIES_AMOUNT, cm.getQuarters(), cm.getDimes(), cm.getNickels(), cm.getPennies());
	}
}
