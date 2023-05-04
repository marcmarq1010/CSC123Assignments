package test;

import UI.InputHelper;
import UI.Messages3;
import gravityCalculator.GravityCalculator;

public class GravityCalculatorTest 
{
	public static void main(String[] args)
	{
		InputHelper ui = new InputHelper();
		GravityCalculator gc = new GravityCalculator(ui.getDouble(Messages3.ENTER_HEIGHT), ui.getDouble(Messages3.ENTER_TIME));
		
		System.out.printf(Messages3.OUTPUT,gc.getHeight(), gc.getMetersFell(), gc.getTime(), gc.getPositionAtGivenTime());
	}
}
