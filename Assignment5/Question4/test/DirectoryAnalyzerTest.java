package test;

import UI.Messages1;
import directoryAnalyzer.DirectoryAnalyzer;

public class DirectoryAnalyzerTest 
{
	public static void main(String[] args)
	{
			// Check if two arguments are provided
		    if (args.length != 1) 
		    {
		    	// Prints an error message
		        System.err.println(Messages1.ERROR_NOT_ENOUGH_ARGUMENTS);
		        
		        // Exit with an error status
		        System.exit(1);
		    }
	    
	    DirectoryAnalyzer analyzer = new DirectoryAnalyzer(args[0]);
	}
}

/*
Take a single command-line argument, a directory name. DONE
Retrieve the directory name from the command-line argument. DONE
Check if the directory exists. DONE
Check if there is permission to read the directory. DONE
Check if the provided directory is a directory, not a file. DONE
Retrieve a list of the files contained within the directory. DONE
Extract necessary information about each file, such as its File Name, Size, Alpha Chars, Numeric Chars, Spaces
Calculate the total size of all the files in the directory.
Output the information about each file to the console.
Report the total size on disk in bytes, KBs, MBs, or GBs as required.
Close any open resources.
End the program.
*/