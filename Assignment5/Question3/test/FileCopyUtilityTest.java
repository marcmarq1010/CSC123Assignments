package test;

import UI.Messages;
import fileCopyUtility.FileCopyUtility;

public class FileCopyUtilityTest 
{
	public static void main(String[] args) 
	{
	    // Check if two arguments are provided
	    if (args.length != 2) 
	    {
	    	// Prints an error message
	        System.err.println(Messages.ERROR_NOT_ENOUGH_ARGUMENTS);
	        
	        // Exit with an error status
	        System.exit(1);
	    }
	}


}
/*
Verify that two command-line arguments are provided, i.e., the source file and target file. DONE
Check if the source file exists, and if it does not exist, print an error message and quit. DONE
Check if either the source file or target file is a directory, and if it is, print an error message and quit. DONE
Check if the target file already exists, and if it does, print an error message and quit. DONE
If the target file does not exist, create the file and any necessary directories. DONE
Read the contents of the source file using raw bytes. DONE
Write the contents to the target file using raw bytes. DONE
Close the source file and target file to release resources. DONE
Print a message indicating the completion of the copy operation. DONE
*/