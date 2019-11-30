

import java.util.Iterator;

/**
 * This class mainly test the methods in the project
 * 
 * @author user
 *
 */
public class AsciiTest {
  /**
   * test classes run here
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testStackPushPeek());
    System.out.println(runStackTestSuite());
  }

  /**
   * test the push method in DrawingStack
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testStackPushPeek() {
    DrawingStack drawingStack = new DrawingStack();
    DrawingChange record = new DrawingChange(1, 1, 'a', 'b');
    drawingStack.push(record);
    return record == drawingStack.peek();
  }

  /**
   * test the constructor method in DrawingStack
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testStackConstructor() {
    boolean test = false;
    DrawingStack drawingStack = new DrawingStack();
    DrawingChange record = null;
    try {
      drawingStack.push(record);
    } catch (IllegalArgumentException e) {
      test = true;
    }
    return test;
  }

  /**
   * test the pop method in DrawingStack
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testStackPop() {
    DrawingStack drawingStack = new DrawingStack();
    DrawingChange record = new DrawingChange(1, 1, 'a', 'b');
    drawingStack.push(record);
    drawingStack.pop();
    if (!drawingStack.isEmpty())
      return false;
    return true;
  }

  /**
   * test the isEmpty method in DrawingStack
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testStackIsEmpty() {
    DrawingStack drawingStack = new DrawingStack();
    DrawingChange record = new DrawingChange(1, 1, 'a', 'b');
    drawingStack.push(record);
    return !drawingStack.isEmpty();
  }

  /**
   * test the iterator method in DrawingStack
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testStackIterator() {
    DrawingStack drawingStack = new DrawingStack();
    return drawingStack.iterator() instanceof Iterator;
  }

  /**
   * test the size method in DrawingStack
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testStackSize() {
    DrawingStack drawingStack = new DrawingStack();
    DrawingChange record = new DrawingChange(1, 1, 'a', 'b');
    drawingStack.push(record);
    return drawingStack.size() == 1;
  }


  /**
   * Run all the test methods in this class
   * 
   * @return true if they work as expected, false otherwise.
   */
  public static boolean runStackTestSuite() {
    return testStackConstructor() && testStackIsEmpty() && testStackIterator() && testStackPop()
        && testStackPushPeek() && testStackSize();
  }

}
