package test;

import UI.InputHelper;
import UI.Messages;
import UI.Messages2;
import circle.Circle;

public class CircleTest 
{
	public static void main(String[] args)
	{
		InputHelper ui = new InputHelper();
		Circle c = new Circle(ui.getString(Messages2.ENTER_CIRCLE_NAME), ui.getDouble(Messages2.ENTER_RADIUS));
		
		System.out.println(c.getName());
		System.out.printf(Messages2.RADIUS + Messages2.AREA + Messages2.CIRCUMFERENCE, c.getRadius(), c.getArea(), c.getCircumference());

	}
}
