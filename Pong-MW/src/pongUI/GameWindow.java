/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author sam
 */
public class GameWindow {
    
    public GameWindow() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        jFrame.add(mainPanel);

        jFrame.setSize(400, 600);

        jFrame.setVisible(true);
    }
    
}
