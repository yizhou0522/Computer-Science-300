
/**
 * This class represents a gamelist object
 * 
 * @author user
 *
 */
public class GameList {
  private GameNode list; // reference to the first GameNode in this list

  /**
   * initializes list to start out empty
   */
  public GameList() {
    list = null;
  }

  /**
   * Adds the new node to the end of this list
   * 
   * @param newNode is the given newNode required to be added
   */
  public void addNode(GameNode newNode) {
    if (this.list == null)
      this.list = newNode;
    else {
      GameNode lastNode = list;
      while (lastNode.getNext() != null) {
        lastNode = lastNode.getNext();
      }
      lastNode.setNext(newNode);
    }

  }

  /**
   * only returns true when this list contains a node with the specified number
   * 
   * @param number the target integer this method intends to search
   * @return true if the list contains the target number, false otherwise.
   */

  public boolean contains(int number) {
    GameNode temp = this.list;
    while (temp != null) {// traverse the list
      if (temp.getNumber() == number)
        return true;
      temp = temp.getNext();
    }
    return false;
  }


  /**
   * returns a string with each number in the list separated by " -> "s, and ending with " -> END"
   */
  public String toString() {
    String result = " ";
    GameNode displayNode = this.list;
    while (displayNode != null) {// traverse the loop
      result += displayNode.getNumber();
      if (displayNode.getNext() != null)
        result += " -> ";
      displayNode = displayNode.getNext();
    }
    result += " -> END";
    return result;
  }

  /**
   * This method scans through this list searching for the first occurrence of a node with the
   * specified number. After finding a node with that number, it calls the applyOperator method on
   * that GameNode, passing along the specified operator object reference.
   * 
   * @param number is the given number by user
   * @param operator is the given operator by user
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {

    GameNode temp = list;
    while (temp.getNumber() != number) {
      temp = temp.getNext();
    }
    temp.applyOperator(operator);// user applyOperator method from GameNode class
  }


}
