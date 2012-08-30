package pongUI;

import pongCore.Player;
import utils.Logger;

import javax.swing.*;
import java.awt.*;
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
public class PongBoard extends JPanel implements Runnable, MouseMotionListener{


    private Player primaryPlayer;
    private Player player2;
    private boolean shouldRun = true;

    public PongBoard(){
        this.setBackground(Color.GREEN);
        this.addMouseMotionListener(this);


        //For testing, we won't create players here
        primaryPlayer = new Player("player one", null);

        new Thread(this).start();

    }

    public void addPrimaryPlayer(Player primaryPlayer){
        this.primaryPlayer = primaryPlayer;
    }

    public void addPlayerTwo(Player player){
        this.player2 = player;
    }


    long interval = 50;
    int count = 0;
    @Override
    public void run() {
        while(shouldRun){

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long timeBefore = System.currentTimeMillis();
            repaint();
            long timeAfter = System.currentTimeMillis();
            long timeTaken = timeAfter - timeBefore;
            if(timeTaken > 50){
                interval = timeTaken;
            }

            count ++;
            if(count > 100){
                Logger.log("Time between repaints " + interval);
                count = 0;
            }

        }
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.clearRect(0, 0, getWidth(), getHeight());


        int primaryPaddleY = primaryPlayer.getPaddle().getYPos();
        graphics2D.drawRect(50, primaryPaddleY, 10, 100);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Logger.log("Mouse Y" + e.getY());
        primaryPlayer.setPaddleY(e.getY());
    }

    public void setShouldRun(boolean shouldRun) {
        this.shouldRun = shouldRun;
    }
}
