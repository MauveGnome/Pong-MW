package pongUI;

import pongCore.ClientController;
import pongCore.Player;
import pongCore.Updateable;
import utils.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 30/08/2012
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
public class PongBoard extends JPanel implements Updateable, MouseMotionListener, KeyListener {

    private ClientController clientController = null;

    public PongBoard(ClientController clientController){
        this.clientController = clientController;
        this.setBackground(Color.GREEN);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.requestFocus();
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.clearRect(0, 0, getWidth(), getHeight());

        Player primaryPlayer = clientController.getPrimaryPlayer();
        if(primaryPlayer  != null){
            int primaryPaddleY = primaryPlayer.getPaddle().getYPos();
            graphics2D.drawRect(50, primaryPaddleY, 10, 100);
        }

        Player player2 = clientController.getPlayerTwo();
        if(player2  != null){
            int player2PaddleY = player2.getPaddle().getYPos();
            graphics2D.drawRect(getWidth() - 50, player2PaddleY, 10, 100);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
//        Logger.log("Mouse Y" + e.getY());
        if(clientController.getPrimaryPlayer() != null) {
            clientController.getPrimaryPlayer().setPaddleY(e.getY());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        Logger.log("key pressed");
        if(e.getKeyCode() == KeyEvent.VK_UP){
            //up
            clientController.getPrimaryPlayer().getPaddle().moveUp();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            //down
            clientController.getPrimaryPlayer().getPaddle().moveDown();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void update() {
        repaint();
    }
}
