import java.util.Random;

public class Demo1{

  private static PApplet processing; // PApplet object that represents the graphic
  // interface of the JunglePark application
  private static PImage backgroundImage; // PImage object that represents the
  // background image
  private static Tiger[] tigers; // array storing the current tigers present
  // in the Jungle Park

  private static int k = 0;
  private static Random randGen; // Generator of random numbers

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Utility.startApplication();
  }

  /**
   * Defines the initial environment properties of the application
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

    tigers = new Tiger[8];
  }

  public static void keyPressed() {



    if (processing.key == 'T' || processing.key == 't') {

      if (k < tigers.length) {
        tigers[k] = new Tiger(processing, (float) randGen.nextInt(processing.width),
            (float) randGen.nextInt(processing.height));
        k++;
      }
    }
    if (processing.key == 'R' || processing.key == 'r') {
      for (int i = 0; i < tigers.length; i++) {
        if (tigers[i] != null && isMouseOver(tigers[i]))
          tigers[i] = null;
      }


    }
  }

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



  public static boolean isMouseOver(Tiger tiger) {
    if ((float) processing.mouseX < (tiger.getPositionX() + tiger.getImage().width / 2)
        && (float) processing.mouseX > (tiger.getPositionX() - tiger.getImage().width / 2)
        && (float) processing.mouseY < (tiger.getPositionY() + tiger.getImage().height / 2)
        && (float) processing.mouseY > (tiger.getPositionY() - tiger.getImage().height / 2))
      return true;
    else
      return false;
  }

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

  public static void mouseUp() {

    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null)
        tigers[i].setDragging(false);
    }
  }


}


