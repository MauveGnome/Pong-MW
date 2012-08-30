package pongCore;

/**
 * @author MauveGnome
 */
public class Paddle {
    int yPos;
    int speed;
    int upperLimit, lowerLimit;
    
    public Paddle() {
        yPos = 50;
        speed = 10;
        upperLimit = 0;
        lowerLimit = 500;    
    }
    
    /**
     * Returns the Y-coordinate of the paddle
     * @return the Y-coordinate of the paddle
     */
    public int getYPos() {
        return this.yPos;
    }
    
    /**
     * Returns the speed of the paddle
     * @return the speed of the paddle
     */
    public int getSpeed() {
        return this.speed;
    }
    
    /**
     * Increases the speed of the paddle
     */
    public void increaseSpeed() {
        this.speed += 10;
    }
    
    /**
     * Decreases the speed of the paddle
     */
    public void decreaseSpeed() {
        this.speed -= 10; 
    }
    
    /**
     * Moves the paddle up
     * @return Returns true if move is valid
     */
    public boolean moveUp() {
        boolean validMove;
        
        if (getYPos() - getSpeed() >= upperLimit) {
            this.yPos -= this.speed;
            validMove = true;
        }
        else
            validMove = false;
        
        return validMove;
    }
    
        /**
     * Moves the paddle down
     * @return Returns true if move is valid
     */
    public boolean moveDown() {
        boolean validMove;
        
        if (getYPos() + getSpeed() <= upperLimit) {
            this.yPos += this.speed;
            validMove = true;
        }
        else
            validMove = false;
        
        return validMove;
    }

    public void setY(int yPos) {
        this.yPos = yPos;
    }
}
