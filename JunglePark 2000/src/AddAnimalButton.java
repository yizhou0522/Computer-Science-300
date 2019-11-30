
/**
 * This class represents an AddAnimalButton object
 * 
 * @author user
 *
 */
public class AddAnimalButton extends Button {

  private String type; // type of the animal to add

  /**
   * create a new AddAnimalButton object at the given position in JunglePark
   * 
   * @param type is the button's type
   * @param x is the given x coordinate
   * @param y is the given y coordinate
   * @param park is the JunglePark object
   */
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park);
    this.type = type.toLowerCase();
    this.label = "Add " + type;
  }
  /**
   * Callback method of mousePressed, it calls each time the user presses the mouse
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      switch (type) {
        case "tiger":
          // TODO create a new Tiger and add it to the JunglePark
          processing.listGUI.add(new Tiger(processing));
          break;
        case "deer":
          processing.listGUI.add(new Deer(processing));
          // TODO create a new Deer and add it to the JunglePark

          break;
      }
    }
  }

}
