package pongCore;

import java.awt.*;

/**
 * @author MauveGnome
 */
public class Ball {
    int xPos, yPos;
    int direction;
    
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
}
