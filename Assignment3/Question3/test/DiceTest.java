package test;

import UI.InputHelper;
import UI.Messages3;
import dice.Dice;

public class DiceTest 
{
	public static void main(String[] args) 
	{
		InputHelper ui = new InputHelper();
		
		Dice d = new Dice();
		
		d.cast();
		
		System.out.printf(Messages3.DICE_ROLL_VALUE, d.getValue());
	}
}
