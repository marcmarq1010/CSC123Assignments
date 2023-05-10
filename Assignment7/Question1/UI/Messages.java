package UI;

public class Messages
{
	// SETUP Server
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 2000;
	
	// Error or Invalid
	public static final String ERROR = "Error: ";
	public static final String INVALID_DIRECTORY = "Invalid directory: ";
	public static final String INVALID_FILE = "Invalid file: ";
	public static final String INVALID_COMMAND = "Invalid command: ";
	
	// Terminal prompts
	public static final String COMMAND_PARTS_CD_DIRECTORY = "Usage: cd <directory>";
	public static final String COMMAND_PARTS_CAT_FILE = "Usage: cat <filename>";
	
	//Server status
	public static final String SERVER_LISTENING = "Server listening on port ";
	public static final String SERVER_ACCEPTED_CLIENT = "Accepted new client connection from ";
}
