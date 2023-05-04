package invertedString;

public class InvertedString 
{
	private String string;
	private String invert = "";
	
	public InvertedString(String string)
	{
		this.string = string;
		invertString();
	}
	
	public void invertString()
	{
		for (int i = string.length() - 1; i >= 0; i--)
		{
			invert += string.charAt(i);
		}
	}
	
	public String getString()
	{
		return string;
	}

	@Override
	public String toString() 
	{
		return invert;
	}
	
	
}
