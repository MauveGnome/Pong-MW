package pongCore;

import java.awt.*;

/**
 * @author MauveGnome
 */
public class Ball {
    int xPos, yPos;
    int speed, direction;
    
    public Ball() {
        
    }
    
    /**
     * Returns the X-coordinate of the Ball
     * @return the x-coordinate of the ball
     */
    public int getXPos() {
        return this.xPos;
    }
    
    /**
     * Returns the Y-coordinate of the Ball
     * @return the y-coordinate of the ball
     */
    public int getYPos() {
        return this.yPos;
    }

    /**
     * Returns the Y-coordinate of the Ball
     * @return the y-coordinate of the ball
     */
    public Point getXY() {
        return new Point(getXPos(), getYPos());        
    }
    
    /**
     * Returns the direction of the Ball
     * @return the direction of the ball
     */
    public int getDirection() {
        return this.direction;
    }
    
    /**
     * Returns the current speed of the ball
     * @return the speed of the ball
     */
    private int getSpeed() {
      return this.speed;
    }
    
    /**
     * Sets a new X-coordinate for the ball
     * @param n the new x-coordinate of the ball 
     */
    private void setXPos(int n) {
      this.xPos = n;
    }
    
    /**
     * Sets a new Y-coordinate for the ball
     * @param n the new y-coordinate for the ball
     */
    private void setYPos(int n) {
      this.yPos = n;
    }
    
    /**
     * Sets a the direction of the ball
     */
    public void setDirection(int newDirection) {
        this.direction = newDirection;
    }
    
    public void moveForward() {
      int newXPos, newYPos;
      Double xPosCalc, yPosCalc;
      
      xPosCalc = getXPos() + (Math.sin(direction) * getSpeed());
      yPosCalc = getYPos() + (Math.cos(direction) * getSpeed());
      newXPos = xPosCalc.intValue();
      newYPos = yPosCalc.intValue();      
      
      setXPos(newXPos);
      setYPos(newYPos);
    }
}
