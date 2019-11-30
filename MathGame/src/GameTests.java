
import java.util.Random;

/**
 * This class displays several tests for specific methods in the whole project.
 * 
 * @author user
 *
 */
public class GameTests {
  public static void main(String[] args) {
    int fails = 0;// number of failed tests
    if (!testApplyOperatorToNumber()) {
      fails++;
      System.out.println("testApplyOperatorToNumber failed!");
    }
    if (!testContains()) {
      fails++;
      System.out.println("testContains failed!");
    }
    if (!testgetNext()) {
      fails++;
      System.out.println("testgetText failed!");
    }
    if (!testsetNext()) {
      fails++;
      System.out.println("testsetNext failed!");
    }
    if (fails == 0)// all tests passed
      System.out.println("All tests passed!");



  }

  /**
   * This method tests the contains method in GameList class
   * 
   * @return true if contains method work as expected, false otherwise.
   */
  public static boolean testContains() {
    GameNode node1 = new GameNode(new Random());
    GameNode node2 = new GameNode(new Random());
    GameNode node3 = new GameNode(new Random());
    int n1 = node1.getNumber();// get the value of node1
    GameList list = new GameList();
    list.addNode(node1);
    list.addNode(node2);
    list.addNode(node3);// initialize the gameList
    return list.contains(n1);// check if node1 is matched with its own number

  }

  /**
   * This method tests the ApplyOperatorToNumber method in GameList class
   * 
   * @return true if the method work as expected, false otherwise
   */
  public static boolean testApplyOperatorToNumber() {

    GameNode node1 = new GameNode(new Random());
    GameNode node2 = new GameNode(new Random());
    GameNode node3 = new GameNode(new Random());
    int n1 = node1.getNumber();
    int n2 = node2.getNumber();
    GameList list = new GameList();
    list.addNode(node1);
    list.addNode(node2);
    list.addNode(node3);// initializes the gamelist
    list.applyOperatorToNumber(n1, GameOperator.getFromChar('+'));
    return node1.getNumber() == n1 + n2; // test if the value given by the test
                                         // method is matched with expected value
  }

  /**
   * This method tests the getNext method in GameNode class
   * 
   * @return true if the method works as expected, false otherwise.
   */
  public static boolean testgetNext() {
    GameNode node1 = new GameNode(new Random());
    GameNode node2 = new GameNode(new Random());
    GameList list = new GameList();
    list.addNode(node1);
    list.addNode(node2);// initialize the gamelist
    int n2 = node2.getNumber();
    return node1.getNext().getNumber() == n2;// test if the value given by the test method is
                                             // matched with n2
  }

  /**
   * This method tests the setNext method in GameNode class
   * 
   * @return true if the method works as expected, false otherwise.
   */
  public static boolean testsetNext() {
    GameNode node1 = new GameNode(new Random());
    GameNode node2 = new GameNode(new Random());
    GameNode node3 = new GameNode(new Random());
    int n3 = node3.getNumber();
    GameList list = new GameList();
    list.addNode(node1);
    list.addNode(node2);// initializes the gamelist
    node1.setNext(node3);// use the setNext method
    return node1.getNext().getNumber() == n3;// check if setNext method returns the expected value
                                             // n3
  }

}
