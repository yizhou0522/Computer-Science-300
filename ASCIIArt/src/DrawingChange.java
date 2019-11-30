
/**
 * This class represents a drawingChange object
 * 
 * @author user
 *
 */
public class DrawingChange {
  public final int x; // x coordinate for a change
  public final int y; // y coordinate for a change
  public final char prevChar; // previous character in the (x,y)
  public final char newChar; // new character in the (x,y)

  /**
   * Creates a drawingChange object
   * 
   * @param x is the given x coordinate
   * @param y is the given y coordinate
   * @param prevChar is the given previous char
   * @param newChar is the given new char
   */
  public DrawingChange(int x, int y, char prevChar, char newChar) {
    this.x = x;
    this.y = y;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }
}
