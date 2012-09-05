package pongCore;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 27/08/2012
 * Time: 22:54
 */
public class GameServer extends Thread{

    private boolean allowConnections = true;             //essentially a server on/off switch.
    private ArrayList<ClientThread> clientThreads;       //stores a collection of all connected clients.
    private ServerSocket serverSocket;                   //listens to client requests and responds appropriately.

    public static final String ACCEPTED_TO_JOIN = "accept";

    public GameServer(int portNumber) throws IOException {
        serverSocket = new ServerSocket(portNumber);

        clientThreads = new ArrayList<ClientThread>();
        
        /*
         * starts a new thread to run the server in to allow the
         * rest of the program to continue running
         */
        this.start();
    }
    
    /**
     * Stops the server. Redundant comment.
     */
    public void stopServer(){
        allowConnections = false;
    }
    
    /**
     * 
     */
    public void run(){
        while(allowConnections){       //sits around looping as long as the server is not shut down.
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                ClientThread clientThread = null;  //creates a new clientThread object
                clientThread = new ClientThread(socket);
                clientThread.start();                                  //starts a new thread for the new client
                clientThreads.add(clientThread);                       //add the new client to the list of clients
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Returns a string containing information about the server
     * @return server info string.
     */
    public String getInfo() {
        return serverSocket.toString();
    }
    
}
