
import java.util.Random;
import java.util.Scanner;

/**
 * This is the class for starting the application; it displays the math game as required
 * 
 * @author user
 *
 */
public class GameApplication {

  /**
   * starts the application
   * 
   * @param args
   */
  public static void main(String[] args) {
    int numMoves = 0;// number of user moves
    int goal = (int) (Math.random() * 90 + 10);// random goal number
    Scanner scan = new Scanner(System.in);
    GameList gameList = new GameList();
    for (int i = 0; i < 7; i++)// initialize the gameList
      gameList.addNode(new GameNode(new Random()));
    while (!gameList.contains(goal)) {// break the loop is the goal is met
      System.out.println("Goal: " + goal + " Moves Taken: " + numMoves);
      System.out.println("Puzzle: " + gameList.toString());
      System.out.print("Number and Operation: ");
      for (int i = 0; i < GameOperator.ALL_OPERATORS.size(); i++) {// get and print all the
                                                                   // gameOperator objects
        System.out.print(GameOperator.ALL_OPERATORS.get(i) + " ");
      }
      String userInputs = scan.nextLine().trim();
      if (userInputs.toLowerCase().equals("quit")) {// quit the application
        System.out.println("Thanks for playing the Math Game!");
        break;
      }
      try {
        int userInputNum = Integer.parseInt(userInputs.substring(0, userInputs.length() - 1));
        // the value of user input number
        char userInputChar = userInputs.charAt(userInputs.length() - 1);
        // the char value of user input operator
        gameList.applyOperatorToNumber(userInputNum, GameOperator.getFromChar(userInputChar));
        gameList.addNode(new GameNode(new Random()));// add a gameNode when one turn is over
        numMoves++;
      } catch (NullPointerException e) {
        System.out.println("WARNING: NullPointerException found.");
      } catch (NumberFormatException e) {
        System.out.println("WARNING: NumberFormatException found.");
      } catch (ArithmeticException e) {
        System.out.println("WARNING: ArithmeticException found.");
      }
    }
    System.out.println("Congratulations, you won in " + numMoves + " moves.");
    System.out.println("Solution: " + gameList.toString());

  }
}
