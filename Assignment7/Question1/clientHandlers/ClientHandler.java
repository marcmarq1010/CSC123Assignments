package clientHandlers;

import java.io.*;
import java.net.Socket;

import UI.Messages;

public class ClientHandler implements Runnable
{
    private Socket socket;
    private String currentDirectory;

    public ClientHandler(Socket socket) 
    {
        this.socket = socket;
        currentDirectory = System.getProperty("user.dir");
    }

    public void run()
    {
        try 
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while ((line = input.readLine()) != null) 
            {
                String[] commandParts = line.split("\\s+");
                String command = commandParts[0];

                switch (command) 
                {
                    case "cd":
                        cd(commandParts, output);
                        break;
                    case "dir":
                        dir(output);
                        break;
                    case "cat":
                        cat(commandParts, output);
                        break;
                    default:
                        output.println(Messages.INVALID_COMMAND + line);
                }
            }

            socket.close();
        } 
        catch (IOException e) 
        {
            System.out.println(Messages.ERROR + e.getMessage());
        }
    }

    private void cd(String[] commandParts, PrintWriter output) throws IOException 
    {
        if (commandParts.length < 2)
        {
            output.println(Messages.COMMAND_PARTS_CD_DIRECTORY);
            return;
        }

        String argument = commandParts[1];
        String newDirectory;

        if (argument.equals(".")) 
        {
            // Stay in the same directory
            newDirectory = currentDirectory;
        } 
        else if (argument.equals("~")) 
        {
            // Go to the directory where the user started
            newDirectory = System.getProperty("user.dir");
        }
        else if (argument.equals("..")) 
        {
            // Go to the previous directory
            File currentDirectoryFile = new File(currentDirectory);
            String parentDirectory = currentDirectoryFile.getParent();
            if (parentDirectory == null)
            {
            	
                // At the root directory, stay there
                newDirectory = currentDirectory;
            } 
            else 
            {
                newDirectory = parentDirectory;
            }
        } 
        else 
        {
            // Go to the specified directory
            File directory = new File(currentDirectory, argument);
            if (directory.isDirectory()) {
                newDirectory = directory.getCanonicalPath();
            } 
            else 
            {
                output.println(Messages.INVALID_DIRECTORY + argument);
                return;
            }
        }

        currentDirectory = newDirectory;
        output.println(currentDirectory);
    }

    private void dir(PrintWriter output) throws IOException 
    {
        File currentDirectoryFile = new File(currentDirectory);
        if (!currentDirectoryFile.isDirectory()) 
        {
            output.println(Messages.INVALID_DIRECTORY  + currentDirectory);
            return;
        }

        File[] files = currentDirectoryFile.listFiles();
        for (File file : files) 
        {
            String fileType = file.isDirectory() ? "directory" : "file";
            output.println(file.getName() + " (" + fileType + ")");
        }
    }

    private void cat(String[] commandParts, PrintWriter output) throws IOException 
    {
        if (commandParts.length < 2)
        {
            output.println(Messages.COMMAND_PARTS_CAT_FILE);
            return;
        }

        String argument = commandParts[1];
        File file = new File(currentDirectory, argument);

        if (!file.exists() || !file.isFile()) 
        {
            output.println(Messages.INVALID_FILE + argument);
            return;
        }

        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = fileReader.readLine()) != null) 
        {
            output.println(line);
        }
        fileReader.close();
    }
}
