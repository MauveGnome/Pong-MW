/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongUI;

import pongCore.ClientThread;
import pongCore.GameClient;
import pongCore.GameServer;
import utils.Logger;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        jFrame.add(mainPanel);

        jFrame.setSize(400, 600);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(CONNECT)){
            connect();
        }
        
        if(event.getActionCommand().equals(START_SERVER)) {
            startServer();
        }
    }
    
    public void startServer() {
        try {
            gameServer = new GameServer(7777);
            Logger.log("started server on " + gameServer.getInfo());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void connect() {
        if(gameClient != null){
            gameClient.setKeepAlive(false);
        }

        Logger.log("connecting");
        try {
            gameClient = new GameClient("localhost", 7777);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
