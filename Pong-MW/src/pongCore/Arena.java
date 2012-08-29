/**
 * @author sam
 */

package pongCore;


public class Arena {

  private int width, height;
  
  public Arena(int w, int h) {
    width = w;
    height = h;
  }
  
  /**
   * Returns the height of the arena
   * @return the height of the arena
   */
  public int getWidth() {
    return this.width;
  }
  
  /**
   * Returns the width of the arena
   * @return the width of the arena
   */
  public int getHeight() {
    return this.height;
  }
  
  /**
   * Gives a new direction for an object bouncing off the top or bottom
   * @param oldDir The old direction of the object
   * @return a new direction based on the old direction
   */
  public int verticalBounce(int oldDir) {
     return 180 - oldDir;
  }
  
  /**
   * Gives a new direction for an object bouncing off the left or right 
   * @param oldDir The old direction of the object
   * @return a new direction based on the old direction
   */
  public int horizontalBounce(int oldDir) {
     return 0 - oldDir;
  }
  
}
