
/**
 * This class represents clearButton object in the JunglePark, it extends Button class.
 * 
 * @author user
 *
 */
public class ClearButton extends Button {

  /**
   * Creates a clearButton object at the given position in the JunglePark
   * 
   * @param x is the given x coordinate
   * @param y is the given y coordinate
   * @param park is the JunglePark object
   */
  public ClearButton(float x, float y, JunglePark park) {
    super(x, y, park);
    this.label = "Clear Park";
    // TODO Auto-generated constructor stub
  }

  /**
   * The callback method once the user presses the mouse
   */
  public void mousePressed() {
    if (isMouseOver()) {
      for (int i = 0; i < processing.listGUI.size(); i++) {
        if (processing.listGUI.get(i) instanceof Animal) {// ensures only delete Animal objects
          processing.listGUI.remove(processing.listGUI.get(i));
          i--;
        }
      }
    }

  }

}
