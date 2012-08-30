/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongUI;

import pongCore.Ball;
import pongCore.ClientThread;
import pongCore.GameClient;
import pongCore.GameServer;
import utils.Logger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import javax.swing.*;

/**
 *
 * @author sam
 */
public class GameWindow implements ActionListener{

    private static final String FILE = "file";
    private static final String CONNECT = "connect";
    private GameClient gameClient = null;
    private static final String START_SERVER = "server.start";
    private GameServer gameServer = null;

    public GameWindow() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar toolBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem connect = new JMenuItem("Connect");
        JMenuItem startServer = new JMenuItem("Start Server");

        /**
         * Sets up the 'connect' menu item.
         */
        connect.setActionCommand(CONNECT);
        connect.addActionListener(this);
        fileMenu.add(connect);

        /**
         * Sets up the 'start server' menu item.
         */
        startServer.setActionCommand(START_SERVER);
        startServer.addActionListener(this);
        fileMenu.add(startServer);

        toolBar.add(fileMenu);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(toolBar, BorderLayout.NORTH);

        PongBoard pongBoard = new PongBoard();
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
// Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        pongBoard.setCursor(blankCursor);
        mainPanel.add(pongBoard, BorderLayout.CENTER);

        jFrame.add(mainPanel);

        jFrame.setSize(600, 400);
        jFrame.setVisible(true);
    }

    /**
     * Code to run when an event occurs on the main form.
     * @param event 
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(CONNECT)){
            connect();
        }
        
        if(event.getActionCommand().equals(START_SERVER)) {
            startServer();
        }
    }
    
    /**
     * Method to run when a new server is started.
     */
    public void startServer() {
        try {
            gameServer = new GameServer(7777);
            Logger.log("started server on " + gameServer.getInfo());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Method to run when a new connection is made.
     */
    public void connect() {
        if(gameClient != null){
            gameClient.setKeepAlive(false);
        }

        Logger.log("connecting");  //places a line in the log to show a connection is being made.
        try {
            gameClient = new GameClient("localhost", 7777);
        }
        catch (IOException ex) {
            ex.printStackTrace();   //if the connection fails an error report is generated.
        }
    }
}
