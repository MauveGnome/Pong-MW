package pongCore;

import java.awt.*;

/**
 * The ball class represents a ball with an x-y coordinate as well as
 * speed and direction.
 * @author MauveGnome
 */
public class Ball {
    int xPos, yPos;
    int speed, direction;
    
    public Ball() {
        xPos = (int)(Math.random() * 200) + 100;
        yPos = (int)(Math.random() * 200) + 100;
        speed = 10;
        direction = (int)(Math.random() * 360);
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
     * Sets a the direction of the ball.
     */
    public void setDirection(int newDirection) {
        this.direction = newDirection;
        this.setValidDirection();
    }
    
    /**
     * If the direction value of the ball is outside the range 0-359
     * it is reset to an equivalent value inside this range.
     */
    public void setValidDirection() {
       if (this.getDirection() < 0 || this.getDirection() > 359) {
          this.setDirection(this.getDirection() % 360);
       }
    }
    
    /**
     * Changes the coordinates of the ball based on its speed and direction.
     */
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
