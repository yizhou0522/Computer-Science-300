
import java.util.Iterator;

/**
 * This class tests several important methods in the following classes.
 * 
 * @author user
 *
 */
public class SequenceGeneratorTests {

  /**
   * starts the test class
   * 
   * @param args
   */
  public static void main(String[] args) {

    int fails = 0;
    if (!geometricSequenceGeneratorTest()) {
      fails++;
      System.out.println("geometricSequenceGeneratorTest fails!");
    }
    if (!fibonacciSequenceGeneratorTest()) {
      fails++;
      System.out.println("fibonacciSequenceGeneratorTest fails!");
    }
    if (!digitProductSequenceGeneratorTest()) {
      fails++;
      System.out.println("digitProductSequenceGeneratorTest fails");
    }
    if (fails == 0)// all tests pass
      System.out.println("All tests pass!");
  }

  /**
   * test the geometricSequence class and its methods
   * 
   * @return true if all elements work as expected, false otherwise.
   */
  public static boolean geometricSequenceGeneratorTest() {

    boolean test = true;

    GeometricSequenceGenerator g = new GeometricSequenceGenerator(5, 2, 6);
    if (!g.hasNext())// test hasNext method
      test = false;
    if (!(g.next() == 5))// test next method
      test = false;
    if (!(g.getINIT() == 5 && g.getRATIO() == 2 && g.getSIZE() == 6))// test constructor
      test = false;
    try {
      GeometricSequenceGenerator g1 = new GeometricSequenceGenerator(-1, 1, 6);
    } catch (IllegalArgumentException e) {// test proper exception being thrown
    }
    return test;
  }

  /**
   * test the fibonacciSequence class and its methods
   * 
   * @return true if all elements work as expected, false otherwise.
   */
  public static boolean fibonacciSequenceGeneratorTest() {
    boolean test = true;
    FibonacciSequenceGenerator f = new FibonacciSequenceGenerator(3);
    if (!f.hasNext())// test hasNext method
      test = false;
    if (f.next() != 0)// test next method
      test = false;
    if ((f.getSIZE() != 3))// test constructor
      test = false;
    try {
      FibonacciSequenceGenerator f1 = new FibonacciSequenceGenerator(-1);
    } catch (IllegalArgumentException e) {// test proper exception being thrown

    }
    return test;

  }

  /**
   * test the digit product class and its methods
   * 
   * @return true if all elements work as expected, false otherwise.
   */
  public static boolean digitProductSequenceGeneratorTest() {
    boolean test = true;
    try {
      DigitProductSequenceGenerator d = new DigitProductSequenceGenerator(-1, 5);
    } catch (IllegalArgumentException e) {// test proper exception being thrown
    }
    DigitProductSequenceGenerator d1 = new DigitProductSequenceGenerator(1, 5);
    if (!(d1.getIterator() instanceof Iterator))// test getIterator method
      test = false;
    if (!(d1.getINIT() == 1 && d1.getSIZE() == 5))// test constructor
      test = false;

    return test;

  }
}
