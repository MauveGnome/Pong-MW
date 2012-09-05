package pongCore;

import pongUI.PongBoard;
import utils.Logger;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 05/09/2012
 * Time: 00:05
 * To change this template use File | Settings | File Templates.
 */
public class ClientController implements Runnable{
    private Properties properties;
    private Game currentGame = null;
    private boolean shouldRun = true;
    private ArrayList<Updateable> updateables;

    public ClientController(){
        updateables = new ArrayList<Updateable>();
        new Thread(this).start();
    }

    public void setShouldRun(boolean shouldRun) {
        this.shouldRun = shouldRun;
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

            for(Updateable updateable : updateables){
                updateable.update();
            }

            long timeAfter = System.currentTimeMillis();
            long timeTaken = timeAfter - timeBefore;
            if(timeTaken > 50){
                interval = timeTaken;
            }

            count ++;
            if(count > 100){
//                Logger.log("Time between repaints " + interval);
                count = 0;
            }

        }
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public void addUpdateable(Updateable updateable) {
        updateables.add(updateable);
    }


    public Player getPrimaryPlayer() {
        if(gameOn()){
            return currentGame.getPrimaryPlayer();
        } else {
            return null;
        }
    }

    private boolean gameOn() {
        return currentGame != null;
    }

    public Player getPlayerTwo() {
        if(gameOn()){
        return currentGame.getPlayerTwo();
        } else {
            return null;
        }
    }
}
