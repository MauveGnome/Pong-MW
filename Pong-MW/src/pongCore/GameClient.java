package pongCore;

import java.io.*;
import java.net.InetAddress;
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

    public GameClient(InetAddress inetAddress, int port) throws IOException {

        Socket socket = new Socket(inetAddress, port);

        input = new BufferedReader( new InputStreamReader( socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());

        this.sendMessage("hello");

    }

    public void sendMessage(String msg) {
        System.out.println("Sending : " + msg);
        toWrite = msg;
    }

    public void run(){
        while(keepAlive){
            String toWrite = getToWrite();
            if(!toWrite.equals("")){
                output.write(toWrite);
                clearMsg();

                String incoming;
                try {
                    while((incoming = input.readLine()) != null){
                        System.out.println("Got response " + incoming);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getToWrite() {
        return toWrite;
    }

    private void clearMsg(){
        toWrite = "";
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }
}
