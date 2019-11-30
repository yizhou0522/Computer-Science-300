

import java.util.Scanner;

/**
 * This is the main driver class
 * 
 * @author user
 *
 */
public class AsciiArt {

  /**
   * Main class starts here.
   * 
   * @param args
   */
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    Canvas canvas = null;// a canvas object
    boolean shouldBreak = false;
    while (!shouldBreak) {
      System.out.println("======== MENU ========");
      System.out.println("[1] Create a new canvas ");
      System.out.println("[2] Draw a character ");
      System.out.println("[3] Undo drawing ");
      System.out.println("[4] Redo drawing ");
      System.out.println("[5] Show current canvas");
      System.out.println("[6] Show drawing history ");
      System.out.println("[7] Exit ");
      System.out.print("> ");
      try {
        String input = scan.nextLine().trim();// user input
        int result = Integer.parseInt(input);
        switch (result) {
          case 1:
            System.out.print("Width > ");
            int width = Integer.parseInt(scan.nextLine().trim());
            System.out.print("Height >");
            int height = Integer.parseInt(scan.nextLine().trim());
            canvas = new Canvas(width, height);// initialize the canvas object
            break;
          case 2:
            System.out.print("Row > ");
            int row = Integer.parseInt(scan.nextLine().trim());
            System.out.print("Col > ");
            int col = Integer.parseInt(scan.nextLine().trim());
            System.out.print("Character > ");
            char character = scan.nextLine().trim().charAt(0);
            canvas.draw(row, col, character);// draw the picture as user expected
            break;
          case 3:
            canvas.undo();
            break;
          case 4:
            canvas.redo();
            break;
          case 5:
            System.out.print(canvas.toString());
            break;
          case 6:
            canvas.printHistory();
            break;
          case 7:
            System.out.println("Bye!");
            shouldBreak = true;// break the loop
            break;
          default:
            break;
        }
      } catch (NumberFormatException e) {// user enters string instead of numbers
        System.out.println("WARNING: An invaild input!");
        continue;
      } catch (IllegalArgumentException e) {// user enters number that is either too small or too
                                            // large
        System.out.println("WARNING: Your number must be positive.");
        continue;
      } catch (NullPointerException e) {// user does not first create a Canvas object
        System.out.println("WARNING: You must create a canvas object before next steps.");
        continue;
      }


    }
  }

}
