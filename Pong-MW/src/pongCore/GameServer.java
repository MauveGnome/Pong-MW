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
 * To change this template use File | Settings | File Templates.
 */
public class GameServer {

    private boolean allowConnections = true;
    private ArrayList<ClientThread> clientThreads;

    public GameServer(int portNumber) throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);

        clientThreads = new ArrayList<ClientThread>();

        while(allowConnections){
            Socket socket = serverSocket.accept();

            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();
            clientThreads.add(clientThread);
        }


    }
}
