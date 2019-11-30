
/**
 * This interface is the interface of waiting queue
 * 
 * @author user
 *
 * @param <T> type of object
 */

public interface WaitingQueueADT<T extends Comparable<T>> {

  /**
   * inserts a newObject in the priority queue
   * 
   * @param newObject is the given new object
   */
  public void enqueue(T newObject);

  /**
   * removes and returns the item with the highest priority
   * 
   * @return the item with the highest priority
   */
  public T dequeue();

  /**
   * returns without removing the item with the highest priority
   * 
   * @return the item with the highest priority
   */
  public T peek();

  /**
   * get the value of size of the queue
   * 
   * @return size of the waiting queue
   */
  public int size();

  /**
   * checks if the waiting queue is empty
   * 
   * @return true if the queue is empty, false otherwise.
   */
  public boolean isEmpty();
}
