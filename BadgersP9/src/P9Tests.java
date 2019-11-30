
import java.util.NoSuchElementException;

/**
 * This class mainly test most of the methods in badger and sett class
 * 
 * @author user
 *
 */
public class P9Tests {

  /**
   * program starts here
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(runAllBadgerTests());
    System.out.println(runAllSettTests());
  }

  /**
   * run all the badger tests
   * 
   * @return true if all work as expected, false otherwise.
   */
  public static boolean runAllBadgerTests() {
    return testBadgerConstructor() && testGetSize();
  }

  /**
   * run all sett tests
   * 
   * @return true if all sett classes pass, false otherwise.
   */
  public static boolean runAllSettTests() {
    return testClear() && testCountBadger() && testFindBadger() && testGetAllBadgers()
        && testGetHeight() && testGetLargestBadger() && testIsEmpty() && testSettConstructor()
        && testSettleBadger();
  }

  /**
   * test badger's constructor
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testBadgerConstructor() {
    Badger badger1 = new Badger(1);
    Badger badger2 = new Badger(2);
    badger1.setRightLowerNeighbor(badger2);
    return badger1.getRightLowerNeighbor().equals(badger2);
  }

  /**
   * test getSize method
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testGetSize() {
    Badger badger = new Badger(1);
    return badger.getSize() == 1;
  }

  /**
   * test sett constructor
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testSettConstructor() {
    Sett sett = new Sett();
    return sett.getTopBadger() == null;
  }

  /**
   * test isEmpty method
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testIsEmpty() {
    Sett sett = new Sett();
    sett.settleBadger(1);
    return !sett.isEmpty();
  }

  /**
   * test settleBadger method
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testSettleBadger() {
    Sett sett = new Sett();
    try {
      sett.settleBadger(1);
      sett.settleBadger(1);
    } catch (IllegalArgumentException e) {
      return true;
    }
    return false;
  }

  /**
   * test findBadger method
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testFindBadger() {
    Sett sett = new Sett();
    try {
      sett.settleBadger(1);
      sett.settleBadger(2);
      sett.findBadger(3);
    } catch (NoSuchElementException e) {
      return true;
    }
    return false;
  }

  /**
   * test countBadger method
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testCountBadger() {
    Sett sett = new Sett();
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(3);
    return sett.countBadger() == 3;
  }

  /**
   * test getAllBadger method
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testGetAllBadgers() {
    Sett sett = new Sett();
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(3);
    for (int i = 0; i < sett.getAllBadgers().size(); i++)
      if (sett.getAllBadgers().get(i).getSize() != i + 1)
        return false;
    return true;
  }

  /**
   * test getHeight method
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testGetHeight() {
    Sett sett = new Sett();
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(3);
    return sett.getHeight() == 3;
  }

  /**
   * test getLargestBadger method
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testGetLargestBadger() {
    Sett sett = new Sett();
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(3);
    return sett.getLargestBadger().getSize() == 3;
  }

  /**
   * test clear method
   * 
   * @return true if it works as expected, false otherwise.
   */
  public static boolean testClear() {
    Sett sett = new Sett();
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(3);
    sett.clear();
    return sett.getTopBadger() == null;
  }

}
