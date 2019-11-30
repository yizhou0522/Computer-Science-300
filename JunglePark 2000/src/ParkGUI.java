

/**
 * This interface presents several common potential methods shared with several classes
 * @author user
 *
 */
public interface ParkGUI {
  public void draw(); // draws a ParkGUI object (either an animal or a button) to the display window

  public void mousePressed(); // called each time the mouse is Pressed

  public void mouseReleased(); // called each time the mouse is Pressed

  public boolean isMouseOver(); // checks whether the mouse is over a ParkGUI object

}
