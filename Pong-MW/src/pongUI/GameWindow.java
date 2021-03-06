/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongUI;

import pongCore.*;
import utils.Logger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Properties;
import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

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
    private static final String OPTIONS = "options";
    private ClientController clientController;
    private static final String EXIT = "exit";
    private static final String LOCAL = "local";
    private Game currentGame = null;

    public GameWindow(ClientController clientController) {
        this.clientController = clientController;

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar toolBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        /**
         * Sets up the 'connect' menu item.
         */
        JMenuItem connect = new JMenuItem("Connect To Server");
        connect.setActionCommand(CONNECT);
        connect.addActionListener(this);
        fileMenu.add(connect);

        /**
         * Sets up the 'start server' menu item.
         */
        JMenuItem startServer = new JMenuItem("Start Server");
        startServer.setActionCommand(START_SERVER);
        startServer.addActionListener(this);
        fileMenu.add(startServer);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setActionCommand(EXIT);
        exit.addActionListener(this);
        fileMenu.add(exit);

        toolBar.add(fileMenu);

        JMenu gameMenu = new JMenu("Game");
        JMenuItem localGame = new JMenuItem("Start Local Game");
        localGame.setActionCommand(LOCAL);
        localGame.addActionListener(this);
        gameMenu.add(localGame);
        toolBar.add(gameMenu);

        JMenu settingsMenu = new JMenu("Settings");
        JMenuItem options = new JMenuItem("Options...");
        options.setActionCommand(OPTIONS);
        options.addActionListener(this);
        settingsMenu.add(options);
        toolBar.add(settingsMenu);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(toolBar, BorderLayout.NORTH);

        PongBoard pongBoard = new PongBoard(clientController);
        clientController.addUpdateable(pongBoard);
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

        if(event.getActionCommand().equals(LOCAL)) {
            clientController.setCurrentGame(new LocalGame());
        }

        if(event.getActionCommand().equals(OPTIONS)) {
            showOptionsPane();
        }
        if(event.getActionCommand().equals(EXIT)) {
            System.exit(0);
        }
    }

    private void showOptionsPane() {
        OptionsPane optionPane = new OptionsPane(clientController.getProperties());
    }

    /**
     * Method to run when a new server is started.
     */
    public void startServer() {
        try {
            int port = Integer.parseInt(clientController.getProperties().getProperty(Main.PORT));
            gameServer = new GameServer(port);
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
            int port = Integer.parseInt(clientController.getProperties().getProperty(Main.PORT));
            String address = clientController.getProperties().getProperty(Main.ADDRESS);
            gameClient = new GameClient(address, port);

            clientController.setCurrentGame(gameClient.getGame());
        }
        catch (IOException ex) {
            ex.printStackTrace();   //if the connection fails an error report is generated.
        }
    }
}
