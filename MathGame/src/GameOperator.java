
import java.util.Arrays;
import java.util.List;

/**
 * This class provides an abstraction for all of the operators that can be used in the math game.
 * Since the constructor for this class is private, use the getFromChar(char) method to acquire
 * references to GameOperator objects. You can then call apply() on these objects to perform their
 * specific operation.
 * 
 * @author dahl
 */
public class GameOperator {

  public static final List<GameOperator> ALL_OPERATORS =
      Arrays.asList(new GameOperator[] {new GameOperator('+'), // addition
          new GameOperator('-'), // subtraction
          new GameOperator('x'), // multiplication
          new GameOperator('/'), // division
          new GameOperator('&'), // concatenation
          new GameOperator('^'), // NOTHING
          new GameOperator(')')}); // list of all available GameOperators objects (note the private
                                   // constructor below)
  private char operator; // the character ID used to distinguish this GameOperator from others

  /**
   * Initialize a new GameOperator with the specified char operator ID. Cannot be instantiated from
   * outside this class, so use the GameOperator.getFromChar(char) method below to retrieve
   * GameOperator object references.
   * 
   * @param operator is the character ID that this object's instance field should be initialized to
   */
  private GameOperator(char operator) {
    this.operator = operator;
  }

  /**
   * Retrieves a reference to a GameOperator object corresponding to the requested operator char.
   * 
   * @param operator is the ID of the GameOperator object that is being requested
   * @return a reference to the requested GameOperator, or null when no such operator exists
   */
  public static GameOperator getFromChar(char operator) {
    for (int i = 0; i < ALL_OPERATORS.size(); i++)
      if (ALL_OPERATORS.get(i).operator == operator)
        return ALL_OPERATORS.get(i);
    return null;
  }

  /**
   * Returns a string containing this GameOperator's char operator ID. This also allows the
   * GameOperator.ALL_OPERATORS.toString() method to result in a more human readable result.
   * 
   * @return a string object representing this GameOperator's char operator ID.
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "" + this.operator;
  }

  /**
   * Defines how each operator converts two input numbers (operands) into one output result.
   * 
   * @param firstOperand is the first (left-most) operand
   * @param secondOperand is the second (right-most) operand
   * @return is the result of applying this operator to the provided operands
   * @throws IllegalStateException when operator represents an undefined operation
   */
  public int apply(int firstOperand, int secondOperand) {
    switch (this.operator) {
      case '+':
        return firstOperand + secondOperand; // addition
      case '-':
        return firstOperand - secondOperand; // subtraction
      case 'x':
        return firstOperand * secondOperand; // multiplication
      case '/':
        return firstOperand / secondOperand; // division
      case '&':
        return Integer.parseInt(firstOperand + "" + secondOperand); // concatenation
      case '^':
        return (int) Math.pow(firstOperand, secondOperand);
      default:
        throw new IllegalStateException("Unable to apply this operator: " + this.operator);
    }
  }
}
