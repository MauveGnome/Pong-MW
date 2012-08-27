/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongCore;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author sam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        jFrame.add(mainPanel);

        jFrame.setSize(400, 600);

        jFrame.setVisible(true);

    }
}
