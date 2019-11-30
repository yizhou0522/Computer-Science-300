

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a generator for an digit product progression
 * 
 * @author user
 *
 */
public class DigitProductSequenceGenerator {

  private final int INIT; // initial number
  private final int SIZE; // size of sequence
  private ArrayList<Integer> sequence; // ArrayList object storing the sequence

  /**
   * Generates an digit product progression
   * 
   * @param init initial value
   * @param size number of elements in the sequence
   */
  public DigitProductSequenceGenerator(int init, int size) {
    // check for the precondition: size > 0, throws an IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0)
      throw new IllegalArgumentException(
          "WARNING: " + "CANNOT create a sequence with size <= zero.");
    if (init <= 0)
      throw new IllegalArgumentException(
          "WARNING: The starting element for digit product sequence cannot"
              + "be less than or equal to zero");
    this.INIT = init;
    this.SIZE = size;
    sequence = new ArrayList<>();
    generateSequence();
  }

  /**
   * This method generate sequence for the digit product object
   */
  public void generateSequence() {
    sequence.clear();
    int prev = INIT;// store the init value
    sequence.add(INIT);
    for (int i = 0; i < SIZE - 1; i++) {
      int record = prev;
      int product = 1;
      while (prev % 10 != 0) {// get the previous term's each digit
        product = (prev % 10) * product;
        prev = prev / 10;
      }
      sequence.add(record + product);// add it to the arraylist
      prev = sequence.get(sequence.size() - 1);// get the next prev value
    }

  }

  /**
   * get the value of INIT
   * 
   * @return the value of INIT
   */
  public int getINIT() {
    return INIT;
  }

  /**
   * get the value of size field
   * 
   * @return the value of SIZE
   */
  public int getSIZE() {
    return SIZE;
  }

  /**
   * get the sequence field
   * 
   * @return ArrayList<Integer>
   */
  public ArrayList<Integer> getSequence() {
    return sequence;
  }

  /**
   * get the iterator of the sequence
   * 
   * @return Iterator<Integer>
   */
  public Iterator<Integer> getIterator() {
    Iterator<Integer> iterator = sequence.iterator();
    return iterator;
  }
}
