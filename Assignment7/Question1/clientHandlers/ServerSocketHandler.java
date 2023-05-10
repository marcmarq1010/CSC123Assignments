package clientHandlers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import UI.Messages;

public class ServerSocketHandler 
{
    private int port;
    private ServerSocket serverSocket;

    public ServerSocketHandler(int port) 
    {
        this.port = port;
    }

    public void start() 
    {
        try 
        {
            serverSocket = new ServerSocket(port);
            System.out.println(Messages.SERVER_LISTENING + port);

            while (true) 
            {
                Socket socket = serverSocket.accept();
                System.out.println(Messages.SERVER_ACCEPTED_CLIENT + socket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } 
        catch (IOException e) 
        {
            System.out.println(Messages.ERROR + e.getMessage());
        }
    }

    public void stop()
    {
        try
        {
            serverSocket.close();
        } 
        catch (IOException e)
        {
            System.out.println(Messages.ERROR + e.getMessage());
        }
    }
}
