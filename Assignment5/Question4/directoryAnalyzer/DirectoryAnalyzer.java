package directoryAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import UI.Messages1;

public class DirectoryAnalyzer 
{
	private String directory;
	
	public DirectoryAnalyzer(String directory)
	{
		this.directory = directory;
	}
	
	public String getDirectory() 
	{
		return directory;
	}
	
    public boolean directoryExists()
    {
        File file = new File(directory);
        return file.exists() && file.isDirectory();
    }
    
    public boolean canReadDirectory()
    {
        File file = new File(directory);
        return file.canRead();
    }
    
    public boolean isDirectory()
    {
        File file = new File(directory);
        return file.isDirectory();
    }
    

    public File[] getFiles()
    {
        File dir = new File(directory);
        return dir.listFiles();
    }
    
    public void validateDirectory()
    {
    	if (!directoryExists()) 
    	{
    		System.err.println(Messages1.ERROR_DIRECTORY_DOES_NOT_EXIST);
    		System.exit(1);
    	}
    	
    	if (!canReadDirectory()) 
    	{
    		System.err.println(Messages1.ERROR_NO_PERMISSION_TO_READ);
    		System.exit(1);
    	}
    	
    	if (!isDirectory()) 
    	{
    		System.err.println(Messages1.ERROR_NOT_A_DIRECTORY);
    		System.exit(1);
    	}
    }
    
    public void extractFileInfo() throws IOException 
    {
        File dir = new File(directory);
        if (!dir.isDirectory()) {
            System.err.println(Messages1.ERROR_NOT_A_DIRECTORY);
            return;
        }
        File[] files = dir.listFiles();
        if (files == null) 
        {
            System.err.println(Messages1.ERROR_READING_DIRECTORY);
            return;
        }
        
        long totalFileSize = 0;
        int totalAlphaChars = 0;
        int totalNumericChars = 0;
        int totalSpaces = 0;
        int totalFiles = 0;
        
        System.out.println(Messages1.FILE_HEADER);
        
        for (File file : files) 
        {
            if (file.isFile()) 
            {
                String fileName = file.getName();
                long fileSize = file.length();
                int alphaChars = 0;
                int numericChars = 0;
                int spaces = 0;
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
                {
                    String line;
                    while ((line = reader.readLine()) != null)
                    {
                        for (int i = 0; i < line.length(); i++) 
                        {
                            char c = line.charAt(i);
                            if (Character.isLetter(c)) 
                            {
                                alphaChars++;
                            } 
                            else if (Character.isDigit(c)) 
                            {
                                numericChars++;
                            } 
                            else if (Character.isWhitespace(c)) 
                            {
                                spaces++;
                            }
                        }
                    } 
                    totalFileSize += fileSize;
                    totalAlphaChars += alphaChars;
                    totalNumericChars += numericChars;
                    totalSpaces += spaces;
                    totalFiles++;
                    System.out.println(fileName + "\t" + fileSize + "\t" + alphaChars + "\t" + numericChars + "\t" + spaces);
                } 
                catch (IOException e) 
                {
                    System.err.println(Messages1.ERROR_READING_FILE + fileName);
                }
            }
        }
        System.out.println(Messages1.FILE_TOTAL_FILES + totalFiles);
        System.out.println(Messages1.FILE_TOTAL_NUMBER_OF_CHARS + totalAlphaChars);
        System.out.println(Messages1.FILE_TOTAL_NUMBER_OF_NUMS + totalNumericChars);
        System.out.println(Messages1.FILE_TOTAL_NUMBER_OF_SPACES + totalSpaces);
        System.out.println(Messages1.FILE_TOTAL_DISK_SIZE + totalFileSize);
    }
}
