package pongCore;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Properties;

import pongUI.*;

/**
 * @author MauveGnome
 */
public class Main {

    private static final String USER_NAME = "username";
    public static final String PORT = "port";
    public static final String ADDRESS = "address";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Main main = new Main();

    }

    public Main() throws IOException {

        Properties properties = getProperties();

        GameWindow window;
        Ball ball = new Ball();
        Paddle player1 = new Paddle();
        Paddle player2 = new Paddle();

        ClientController clientController = new ClientController();
        clientController.setProperties(properties);

        window = new GameWindow(clientController);
    }

    private Properties getProperties() throws IOException {
        File propertiesFile = new File("pong.properties");

        Properties properties = new Properties(getDefaultProperties());
        if(propertiesFile.exists()) {
            properties.loadFromXML(new FileInputStream(propertiesFile));
        } else {
            properties.storeToXML(new FileOutputStream(propertiesFile), "");
        }
        return properties;
    }

    private Properties getDefaultProperties() {
        Properties defaultProperties = new Properties();
        defaultProperties.setProperty(USER_NAME, "Player1");
        defaultProperties.setProperty(PORT, "7777");
        defaultProperties.setProperty(ADDRESS, "localhost");
        return defaultProperties;
    }


}
