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
public class GameServer extends Thread{

    private boolean allowConnections = true;
    private ArrayList<ClientThread> clientThreads;
    private ServerSocket serverSocket;

    public GameServer(int portNumber) throws IOException {
        serverSocket = new ServerSocket(portNumber);

        clientThreads = new ArrayList<ClientThread>();
        this.start();
    }

    public void stopServer(){
        allowConnections = false;
    }
    
    public void run(){
        while(allowConnections){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();
            clientThreads.add(clientThread);
        }
    }

    public String getInfo() {
        return serverSocket.toString();
    }
}
