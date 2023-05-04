package gravityCalculator;

public class GravityCalculator 
{
	private final double a = -9.81;
	
	private double height;
	private double time;
	private double positionAtGivenTime;
	private double metersFell;
	
	public GravityCalculator(double height, double time)
	{
		this.height = height;
		this.time = time;
		setPositionAtGivenTime();
		setMetersFell();
	}

	public void setPositionAtGivenTime() 
	{
	    this.positionAtGivenTime = 0.5 * a * Math.pow(time, 2) + height;
	    
	    if(positionAtGivenTime < 0) 
	    {
	        this.positionAtGivenTime = 0;
	    }
	}

	public void setMetersFell()
	{
		metersFell = height - positionAtGivenTime;
	}

	public double getHeight() 
	{
		return height;
	}

	public double getTime() 
	{
		return time;
	}

	public double getPositionAtGivenTime() 
	{
		return positionAtGivenTime;
	}

	public double getMetersFell() 
	{
		return metersFell;
	}
	
	
}