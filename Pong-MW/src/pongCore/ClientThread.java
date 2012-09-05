package pongCore;

import utils.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
    private BufferedReader input = null;
    private PrintWriter output;


    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        input = new BufferedReader( new InputStreamReader( socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {

        Logger.log("Got connection from " + socket.getInetAddress().toString());
        String incoming = "";
        while (true){
            try {
                while((incoming = input.readLine()) != null){
                    Logger.log("Server hears : " + incoming);

                    parseIncoming(incoming);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseIncoming(String incoming) {
        if(incoming.equals("hello")){
            output.println(GameServer.ACCEPTED_TO_JOIN);
        }
    }

    public Socket getSocket() {
        return this.socket;
    }
}
