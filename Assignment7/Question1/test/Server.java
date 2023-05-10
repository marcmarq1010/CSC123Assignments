package test;

import clientHandlers.ServerSocketHandler;

public class Server 
{
    public static void main(String[] args) 
    {
        ServerSocketHandler server = new ServerSocketHandler(2000);
        server.start();
    }
}
