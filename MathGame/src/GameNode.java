
import java.util.Random;


/**
 * This class represents a gameNode object
 * 
 * @author user
 *
 */
public class GameNode {
  private int number; // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node

  /**
   * initializes number to random 1-9 value, and next to null
   * 
   * @param rng is the given Random class object
   */
  public GameNode(Random rng) {
    next = null;
    number = rng.nextInt(9) + 1;
  }

  /**
   * accessor for the number field
   * 
   * @return the integer value of number
   */
  public int getNumber() {
    return number;
  }

  /**
   * accessor for the next field
   * 
   * @return next GameNode object
   */
  public GameNode getNext() {
    return next;
  }

  /**
   * mutator for the next field
   * 
   * @param next is the given GameNode object by user
   */
  public void setNext(GameNode next) {
    this.next = next;
  }

  /**
   * The new number for this node is calculated by applying the provided operator to this node's
   * number (the first operand), and the next node's number (the second operand).
   * 
   * @param operator is the given operator given by the user
   */
  public void applyOperator(GameOperator operator) {
    this.number = operator.apply(this.getNumber(), this.getNext().getNumber());
    this.next = this.getNext().getNext();
  }
}
