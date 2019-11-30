

import java.util.Iterator;

/**
 * This class represents a generator for an fibonaccci progression This class implements the
 * Iterator<Integer> interface
 *
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // number of elements in this sequence
  private int prev; // previous item in the sequence with respect to the current iteration
  private int next; // next item in the sequence with respect to the current iteration
  private int generatedCount; // number of items generated so far


  /**
   * Generates a fibonacci sequence
   * 
   * @param size number of elements in the sequence
   */
  public FibonacciSequenceGenerator(int size) {
    // check for the precondition: size > 0, throws an IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0)
      throw new IllegalArgumentException(
          "WARNING: " + "CANNOT create a sequence with size <= zero.");
    this.SIZE = size;
    this.prev = 0;
    this.next = 1;
    this.generatedCount = 0;
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
   * get the value of prev field
   * 
   * @return the value of prev
   */

  public int getPrev() {
    return prev;
  }

  /**
   * get the value of NEXT
   * 
   * @return the value of NEXT
   */
  public int getNext() {
    return next;
  }

  /**
   * Checks if the iteration has a next element in this sequence
   * 
   * @return true if the current element in the iteration has a next element in this sequence, false
   *         otherwise
   */
  @Override
  public boolean hasNext() {
    return generatedCount < SIZE;
    // Time complexity: O(1)
  }

  /**
   * Returns the next element in this arithmetic sequence iteration with respect to the numbers
   * generated so far
   * 
   * @return the next element in this iteration
   */
  @Override
  public Integer next() {
    if (!hasNext())
      return null;
    int current = prev;// store the prev value
    int record = next;
    next = prev + next;// get the next term
    prev = record;
    generatedCount++;
    return current;
    // Time complexity: O(1)
  }



}

