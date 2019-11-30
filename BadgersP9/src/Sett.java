
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents a sett object
 * 
 * @author user
 *
 */
public class Sett {
  private Badger topBadger;// the root badger

  /**
   * Constructs an empty Sett.
   */
  public Sett() {
    topBadger = null;
  }

  /**
   * Retrieve the top Badger within this Sett (the one that was settled first).
   * 
   * @return The Badger living on the top of the current Sett.
   */
  public Badger getTopBadger() {
    return topBadger;
  }

  /**
   * Checks whether this Sett is empty.
   * 
   * @return true if this Sett is empty, false otherwise.
   */
  public boolean isEmpty() {
    return topBadger == null;
  }

  /**
   * Creates a new Badger object with the specified size, and inserts them into this Sett (BST).
   * 
   * @param size The size of the new Badger that will be settled.
   * @throws java.lang.IllegalArgumentException When a Badger with the specified size already exists
   *         within this Sett.
   */
  public void settleBadger(int size) throws java.lang.IllegalArgumentException {
    Badger newBadger = new Badger(size);
    if (isEmpty())
      topBadger = newBadger;
    else
      settleHelper(topBadger, newBadger);
  }

  /**
   * This recursive helper method is used to help settle a new Badger within this Sett.
   * 
   * @param current The current Badger that we are considering settling the newBadger beneath
   * @param newBadger The new Badger that needs to be settled within this Sett.
   * @throws java.lang.IllegalArgumentException When a Badger with the specified size already exists
   *         within this Sett.
   */
  private void settleHelper(Badger current, Badger newBadger)
      throws java.lang.IllegalArgumentException {
    if (newBadger.getSize() < current.getSize()) {
      if (current.getLeftLowerNeighbor() == null)
        current.setLeftLowerNeighbor(newBadger);
      else
        settleHelper(current.getLeftLowerNeighbor(), newBadger);
    } else if (newBadger.getSize() > current.getSize()) {
      if (current.getRightLowerNeighbor() == null)
        current.setRightLowerNeighbor(newBadger);
      else
        settleHelper(current.getRightLowerNeighbor(), newBadger);
    } else {
      throw new IllegalArgumentException("WARNING: failed to settle the badger with size"
          + newBadger.getSize() + "as there is already a badger with the same size in this sett");
    }
  }

  /**
   * Finds a Badger of a specified size in this Sett.
   * 
   * @param size The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws java.util.NoSuchElementException When there is no Badger in this Sett with the
   *         specified size.
   */
  public Badger findBadger(int size) throws java.util.NoSuchElementException {
    return findHelper(topBadger, size);
  }

  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * 
   * @param current The current Badger that is the root of a (sub) tree that we are searching for a
   *        Badger with the specified size within.
   * @param size The size of the Badger object to search for and return.
   * @return he Badger found with the specified size.
   * @throws java.util.NoSuchElementException When there is no Badger in this Sett with the
   *         specified size.
   */
  private Badger findHelper(Badger current, int size) throws java.util.NoSuchElementException {
    if (current == null)
      throw new NoSuchElementException(
          "WARNING: failed to find a badger with size" + size + " in the sett");
    if (current.getSize() == size)
      return current;
    if (current.getSize() > size)
      return findHelper(current.getLeftLowerNeighbor(), size);
    else
      return findHelper(current.getRightLowerNeighbor(), size);
  }

  /**
   * Counts how many Badgers live in this Sett.
   * 
   * @return The number of Badgers living in this Sett.
   */
  public int countBadger() {

    return countHelper(topBadger);
  }

  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * 
   * @param current he current Badger that is the root of a (sub) tree that we are searching for a
   *        Badger with the specified size within.
   * @return the number of Badgers living in the Sett rooted at the current Badger.
   * 
   */
  private int countHelper(Badger current) {
    if (current == null)
      return 0;
    else
      return countHelper(current.getLeftLowerNeighbor()) + 1
          + countHelper(current.getRightLowerNeighbor());
  }

  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their size: smallest one in
   * the front (at index zero), through the largest one at the end (at index size-1).
   * 
   * @return A list of all Badgers living in the Sett in ascending order by size.
   */
  public java.util.List<Badger> getAllBadgers() {
    List<Badger> list = new ArrayList<>();
    getAllHelper(topBadger, list);
    return list;
  }

  /**
   * This recursive helper method is used to help collect the Badgers within this Sett into a List.
   * 
   * @param current The list of all Badgers living in the Sett that is rooted at the current Badger
   *        node. The contents of this list should be in ascending order by Badger size.
   * @param allBadgers The current Badger that is the root of a (sub) tree that we are collecting
   *        all contained Badgers within, into the allBadgers List.
   */
  private void getAllHelper(Badger current, java.util.List<Badger> allBadgers) {
    if (current.getLeftLowerNeighbor() != null)
      getAllHelper(current.getLeftLowerNeighbor(), allBadgers);
    allBadgers.add(current);
    if (current.getRightLowerNeighbor() != null)
      getAllHelper(current.getRightLowerNeighbor(), allBadgers);
  }

  /**
   * Computes the height of the Sett, as the number of nodes from root to the deepest leaf Badger
   * node.
   * 
   * @return The depth of this Sett
   */
  public int getHeight() {
    return getHeightHelper(topBadger);
  }

  /**
   * This recursive helper method is used to help compute the height of this Sett.
   * 
   * @param current The current Badger that is the root of a (sub) tree that we are calculating the
   *        height of.
   * @return The height of the (sub) tree that we are calculating.
   */
  private int getHeightHelper(Badger current) {
    if (current == null)
      return 0;
    else {
      int leftDepth = getHeightHelper(current.getLeftLowerNeighbor());
      int rightDepth = getHeightHelper(current.getRightLowerNeighbor());
      if (leftDepth > rightDepth)
        return leftDepth + 1;
      else
        return rightDepth + 1;

    }
  }

  /**
   * Retrieves the largest Badger living in this Sett.
   * 
   * @return The largest Badger living in this Sett.
   */
  public Badger getLargestBadger() {
    return getAllBadgers().get(getAllBadgers().size() - 1);
  }

  /**
   * Empties this Sett, to no longer contain any Badgers.
   */
  public void clear() {
    topBadger = null;
  }
}
