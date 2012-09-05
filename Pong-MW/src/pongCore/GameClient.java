package pongCore;

import utils.Logger;
import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 27/08/2012
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class GameClient extends Thread{

    private BufferedReader input;
    private PrintWriter output;
    private boolean keepAlive = true;
    private String toWrite = null;
    private Game game = null;


    public GameClient(String inetAddress, int port) throws IOException {

        Socket socket = new Socket(inetAddress, port);

        input = new BufferedReader( new InputStreamReader( socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());

        this.sendMessage("hello");
    }

    /**
     * Sends and logs a given message.
     * @param msg message to send.
     */
    public void sendMessage(String msg) {
        Logger.log("Sending : " + msg);
        toWrite = msg;
    }

    @Override
    public void run(){
        while(keepAlive){                             //code continues looping until killed.

            String outgoing = getToWrite();
            String incoming;

            if(!outgoing.equals("")){                 //runs code if there is a message to send.
                output.write(outgoing);
                clearMsg();                            //writes message to output stream then clears it.


                /**
                 * Reads and logs any incoming messages.
                 */
                try {
                    while((incoming = input.readLine()) != null){
                        Logger.log("Client heard : " + incoming);

                        parseIncoming(incoming);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void parseIncoming(String incoming) {
        if(incoming.equals(GameServer.ACCEPTED_TO_JOIN)) {
            joinServerGame();
        }
    }

    private void joinServerGame() {
        this.game = new ServerGame();
    }

    /**
     * Getter method for the outgoing message.
     * @return the outgoing message.
     */
    private String getToWrite() {
        return toWrite;
    }

    /**
     * Wipes the outgoing message.
     */
    private void clearMsg(){
        toWrite = "";
    }

    /**
     * Controls whether the client should continue running.
     * @param keepAlive true keeps the client running and false stops it.
     */
    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Game getGame() {
        return game;
    }


    private class ServerGame extends Game{
    }
}
