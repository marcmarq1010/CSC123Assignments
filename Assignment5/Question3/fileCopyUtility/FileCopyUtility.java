package fileCopyUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import UI.Messages;

public class FileCopyUtility 
{
    private String sourceFile;
    private String targetFile;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;

    public FileCopyUtility(String sourceFile, String targetFile)
    {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
        
        openSourceFile();
        openTargetFile();
      
        checkIfDirectory();
        copyFile();
    }

    public void openSourceFile() 
    {
        try 
        {
            File source = new File(sourceFile);
            inputStream = new FileInputStream(source);
        }
        catch (FileNotFoundException e) 
        {
            System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
            System.exit(1);
        }
    }

    public void openTargetFile() 
    {
        try 
        {
        	File target = new File(targetFile);

        		if (target.exists()) 
        	    {
        	        System.err.println(Messages.ERROR_FILE_EXISTS);
        	        System.exit(1);
        	    }
        	    else 
        	    {
        	        target.getParentFile().mkdirs();
        	        try 
        	        {
        	            target.createNewFile();
        	        } 
        	        catch (IOException e) 
        	        {
        	            System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
        	            System.exit(1);
        	        }
        	        outputStream = new FileOutputStream(target);
        	    }
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
            System.exit(1);
        } 
    }

    
    public void checkIfDirectory() 
    {
        File source = new File(sourceFile);
        File target = new File(targetFile);

        if (source.isDirectory() || target.isDirectory()) 
        {
            System.err.println(Messages.ERROR_DIRECTORY);
            System.exit(1);
        }
    }
    
    public void copyFile() 
    {
        byte[] buffer = new byte[1024];
        int bytesRead;

        try 
        {
            while ((bytesRead = inputStream.read(buffer)) != -1) 
            {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            System.out.println(Messages.COPY_COMPLETE);
            
        } 
        catch (IOException e) 
        {
            System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
            System.exit(1);
        } 
        
        finally 
        {
            try 
            {
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
                System.err.println(Messages.ERROR_DEFAULT + e.getMessage());
                System.exit(1);
            }
        }
    }


}
