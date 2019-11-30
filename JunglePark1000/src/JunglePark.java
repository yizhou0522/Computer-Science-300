import java.util.Random;



public class JunglePark {

  private static PApplet processing; // PApplet object that represents the graphic
  // interface of the JunglePark application
  private static PImage backgroundImage; // PImage object that represents the
  // background image
  private static Tiger[] tigers; // array storing the current tigers present
  // in the Jungle Park

  // private static int k = 0;
  private static Random randGen; // Generator of random numbers

  public static void main(String[] args) {

    Utility.startApplication();
  }

  /**
   * This method aims to establish a setup once the program is launched. Defines the initial
   * environment properties of the application
   * 
   * @param processingObj represents a reference to the graphical interface of the application
   */
  public static void setup(PApplet processingObj) {
    processing = processingObj; // initialize the processing field to the one passed into
    // the input argument parameter

    randGen = new Random(); // create a Random object and store its reference in randGen
    processing.background(245, 255, 250); // Mint cream color
    // initialize and load the image of the background

    backgroundImage = processing.loadImage("images/background.png");
    // Draw the background image at the center of the screen

    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    // width [resp. height]: System variable of the processing library that stores the width
    // [resp. height] of the display window.

    tigers = new Tiger[8];// create eight null tiger objects within an array
  }

  /**
   * This callback method aims to visualize the tigers object in response to the user input(i.e.
   * 'T'). It will create up to eight tiger objects on the screen when user inputs 'T' or 't' and it
   * will reduce the number of tiger by one if user inputs 'R' or 'r'.
   */
  public static void keyPressed() {

    if (processing.key == 'T' || processing.key == 't') {

      for (int i = 0; i < tigers.length;) {
        if (tigers[i] == null) {// avoid nullpointerexception
          tigers[i] = new Tiger(processing, (float) randGen.nextInt(processing.width),
              (float) randGen.nextInt(processing.height));
          break;
        } else
          i++;
      }
    }
    if (processing.key == 'R' || processing.key == 'r') {
      for (int i = 0; i < tigers.length; i++) {
        if (tigers[i] != null && isMouseOver(tigers[i]))
          tigers[i] = null;
      }


    }
  }

  /**
   * This method intends to update the tiger image and the background image continuously so that
   * users can see the effect of dragging a tiger in the program.
   */
  public static void update() {

    processing.background(245, 255, 250); // Mint cream color
    // initialize and load the image of the background

    backgroundImage = processing.loadImage("images/background.png");
    // Draw the background image at the center of the screen

    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    // width [resp. height]: System variable of the processing library that stores the width
    // [resp. height] of the display window.

    for (int i = 0; i < tigers.length; i++)
      if (tigers[i] != null)
        tigers[i].draw();
  }

  /**
   * This method intends to decide if user's mouse is over tiger image by using parameter mouseX,
   * mouseY, image's width, image's height.
   * 
   * @param tiger is the tiger object.
   * 
   */

  public static boolean isMouseOver(Tiger tiger) {
    if ((float) processing.mouseX < (tiger.getPositionX() + tiger.getImage().width / 2)
        && (float) processing.mouseX > (tiger.getPositionX() - tiger.getImage().width / 2)
        && (float) processing.mouseY < (tiger.getPositionY() + tiger.getImage().height / 2)
        && (float) processing.mouseY > (tiger.getPositionY() - tiger.getImage().height / 2))
      // decide if the user's mouse is inside the given tiger image's area.
      return true;
    else
      return false;
  }

  /**
   * This callback method let tiger objects clickable; that is, it set the isDragging parameter in
   * tiger object to true to allow users to drag the tiger object.
   */
  public static void mouseDown() {
    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null) {
        if (isMouseOver(tigers[i]))// true

        {
          tigers[i].setDragging(true);
          break;
        }
      }
    }
  }

  /**
   * This callback method sets all the tiger objects' isDragging parameter to false once the users
   * do not click the mouse
   */
  public static void mouseUp() {

    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null)
        tigers[i].setDragging(false);
    }
  }


}


