package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import UI.Messages;

public class Client 
{


    public static void main(String[] args) 
    {
        try  (Socket socket = new Socket(Messages.SERVER_HOST, Messages.SERVER_PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))) 
        {

            String line;
            while ((line = input.readLine()) != null) 
            {
                output.println(line);

                // Handle server response
                String serverResponse = serverInput.readLine();
                System.out.println(serverResponse);
            }

        } 
        catch (IOException e) 
        {
            System.out.println(Messages.ERROR + e.getMessage());
        }
    }
}
