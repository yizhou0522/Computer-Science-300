

/**
 * This class represents a Tiger in the JunglePark application and it extends Animal class
 *
 */
public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for
                                             // food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger

  private int deerEatenCount = 0; // Number of Deers that the current tiger has eaten so far

  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }


  /**
   * Tiger's behavior in the Jungle Park Scans for food at the neighborhood of the current tiger. If
   * the Tiger founds any deer at its proximity, it hops on it, and eats it
   */
  @Override
  public void action() {

    for (int i = 0; i < processing.listGUI.size(); i++) {
      if (processing.listGUI.get(i) instanceof Deer)// only deer object can be eaten
        hop((Deer) processing.listGUI.get(i));
    }
    if (deerEatenCount > 0)
      displayDeerEatenCount(); // display deerEatenCount

  }

  /**
   * Displays the number of eaten deers if any on the top of the tiger image
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(),
        this.getPositionY() - this.image.height / 2 - 4);
  }


  /**
   * get the number of dear eaten
   * 
   * @return the number of deer eaten
   */
  public int getDeerEatenCount() {
    return deerEatenCount;
  }

  /**
   * The tiger object will replace the position of the "eaten" deer object within the specified
   * range and the deer object is removed in the JunglePark
   * 
   * @param food
   */
  public void hop(Deer food) {
    if (isClose(food, SCAN_RANGE)) {
      this.setPositionX(food.getPositionX());
      this.setPositionY(food.getPositionY());
      processing.listGUI.remove(food);
      deerEatenCount++;
    }



  }


}
