package invertedString;

public class InvertedString 
{
	private String string;	// Holds the original string to be inverted
	private String invert = "";	// Holds the inverted string

	// Takes a string parameter and initializes the instance variable `string` with it. It also calls the method `invertString()`.
	public InvertedString(String string) 
	{
		this.string = string;
		invertString();
	}

	// Iterates through each character in the `string` instance variable and builds the inverted string by adding each character to the beginning of `invert`.
	public void invertString() 
	{
		// Iterates through each character in the string from the end to the beginning
		for (int i = string.length() - 1; i >= 0; i--) 
		{
			// Add the current character to the beginning of the inverted string
			invert += string.charAt(i);
		}
	}

	// Returns the original `string` instance variable
	public String getString() 
	{
		return string;
	}

	// Overrides the default `toString()` method and returns the inverted string `invert`.
	@Override
	public String toString() 
	{
		return invert;
	}
}
