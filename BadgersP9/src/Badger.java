
/**
 * This class represents a badger object
 * 
 * @author user
 *
 */
public class Badger {

  private Badger leftLowerNeighbor;// the left badger
  private Badger rightLowerNeighbor;// the right badger
  private final int size;// the size of this badger

  /**
   * Creates a new Badger with specified size.
   * 
   * @param size is the given number of size
   */
  public Badger(int size) {
    this.size = size;
  }

  /**
   * Retrieves neighboring badger that is smaller than this one.
   * 
   * @return the left badger
   */
  public Badger getLeftLowerNeighbor() {
    return leftLowerNeighbor;
  }

  /**
   * Retrieves neighboring badger that is larger than this one.
   * 
   * @return the right badger
   */
  public Badger getRightLowerNeighbor() {
    return rightLowerNeighbor;
  }

  /**
   * Retrieves the size of this badger.
   * 
   * @return the value of size
   */
  public int getSize() {
    return size;
  }

  /**
   * Changes this badger's lower left neighbor.
   * 
   * @param badger is the given new badger
   */
  public void setLeftLowerNeighbor(Badger badger) {
    this.leftLowerNeighbor = badger;
  }

  /**
   * Changes this badger's lower right neighbor.
   * 
   * @param badger is the given new badger
   */
  public void setRightLowerNeighbor(Badger badger) {
    this.rightLowerNeighbor = badger;
  }


}
