package fileCopyUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import UI.Messages;

public class FileCopyUtility 
{

    // Instance variables to store source and target file paths and file input/output streams
    private String sourceFile;
    private String targetFile;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;

    // Constructor that takes in source and target file paths
    public FileCopyUtility(String sourceFile, String targetFile) 
    {
        
        // Assign source and target file paths to instance variables
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
        
        // Open source and target files
        openSourceFile();
        openTargetFile();
      
        // Check if either source or target file is a directory, and if so, exit the program with an error message
        checkIfDirectory();
        
        // Copy contents from source to target file
        copyFile();
    }

    // Function to open the source file and assign its input stream to the instance variable
    public void openSourceFile() 
    {
        try
        {
            File source = new File(sourceFile);
            inputStream = new FileInputStream(source);
        }
        catch (FileNotFoundException e) 
        {
            // If file not found, print error message and exit the program with an error code
            System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
            System.exit(1);
        }
    }

    // Function to open the target file, create it if it doesn't exist, and assign its output stream to the instance variable
    public void openTargetFile() 
    {
        try 
        {
            File target = new File(targetFile);

            if (target.exists()) 
            {
                // If target file already exists, print error message and exit the program with an error code
                System.err.println(Messages.ERROR_FILE_EXISTS);
                System.exit(1);
            }
            else
            {
                // If target file doesn't exist, create the file and its parent directories (if necessary), and assign its output stream to the instance variable
                target.getParentFile().mkdirs();
                try
                {
                    target.createNewFile();
                } 
                catch (IOException e) 
                {
                    // If an error occurs while creating the file, print error message and exit the program with an error code
                    System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
                    System.exit(1);
                }
                outputStream = new FileOutputStream(target);
            }
        } 
        catch (FileNotFoundException e) 
        {
            // If file not found, print error message and exit the program with an error code
            System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
            System.exit(1);
        } 
    }

    // Function to check if either source or target file is a directory, and if so, exit the program with an error message
    public void checkIfDirectory() 
    {
        File source = new File(sourceFile);
        File target = new File(targetFile);

        if (source.isDirectory() || target.isDirectory()) 
        {
            // If either source or target file is a directory, print error message and exit the program with an error code
            System.err.println(Messages.ERROR_DIRECTORY);
            System.exit(1);
        }
    }
    
    public void copyFile() 
    {
        // Create a buffer of bytes with a size of 1024
        byte[] buffer = new byte[1024];
        
        // Initialize bytesRead to 0
        int bytesRead = 0;

        try 
        {
            // Read from the inputStream into the buffer and store the number of bytes read in bytesRead
            while ((bytesRead = inputStream.read(buffer)) != -1) 
            {
                // Write to the outputStream from the buffer, starting at index 0 and writing bytesRead number of bytes
                outputStream.write(buffer, 0, bytesRead);
            }
            
            // Print a message indicating that the copy is complete
            System.out.println(Messages.COPY_COMPLETE);
            
        } 
        catch (IOException e) 
        {
            // If an exception occurs, print an error message including the exception message and exit the program with status code 1
            System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
            System.exit(1);
        } 
        
        finally 
        {
            try 
            {
                // Close the inputStream and outputStream if they are not null
                if (inputStream != null)
                {
                    inputStream.close();
                }
                if (outputStream != null) 
                {
                    outputStream.close();
                }
            } 
            catch (IOException e)
            {
                // If an exception occurs, print an error message including the exception message and exit the program with status code 1
                System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
                System.exit(1);
            }
        }
    }

}
