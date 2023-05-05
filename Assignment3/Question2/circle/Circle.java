package circle;

public class Circle 
{
	private String name;
	private double area;
	private double circumference;
	private double radius;
	
	public Circle(String name, double radius)
	{
		this.name = name;
		this.radius = radius;
		setArea();
		setCircumference();
	}
	
	public void setCircumference()
	{
		circumference = 2 * Math.PI * radius; 
	}
	
	public void setArea()
	{
		area = Math.PI * Math.pow(radius, 2);
	}

	public String getName() 
	{
		return name;
	}

	public double getArea() 
	{
		return area;
	}

	public double getCircumference() 
	{
		return circumference;
	}

	public double getRadius() 
	{
		return radius;
	}
	
	
}
