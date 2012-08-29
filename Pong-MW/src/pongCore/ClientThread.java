package pongCore;

import utils.Logger;

import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 27/08/2012
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
public class ClientThread extends Thread{
    private Socket socket;

    
    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Logger.log("Got connection from " + socket.getInetAddress().toString());
    }
}
