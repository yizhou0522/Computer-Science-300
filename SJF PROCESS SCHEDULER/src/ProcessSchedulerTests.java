

import java.util.Arrays;

/**
 * This class tests the methods in CustomProcssQueue class
 * 
 * @author user
 *
 */
public class ProcessSchedulerTests {

  /**
   * the test program starts here
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testDequeueCustomProcessQueue() && testEnqueueCustomProcessQueue()
        && testPeekCustomProcessQueue() && testSizeCustomProcessQueue());

  }

  /**
   * test the enqueue method, checks the correctness of the enqueue
   * 
   * @return true if the method works as expected, false otherwise
   */
  public static boolean testEnqueueCustomProcessQueue() {
    CustomProcessQueue cQueue = new CustomProcessQueue();
    cQueue.enqueue(new CustomProcess(4));
    cQueue.enqueue(new CustomProcess(3));
    cQueue.enqueue(new CustomProcess(5));
    cQueue.enqueue(new CustomProcess(2));
    cQueue.enqueue(new CustomProcess(8));
    return cQueue.size() == 5;

  }

  /**
   * test the dequeue method, checks the correctness of the dequeue
   * 
   * @return true if the method works as expected, false otherwise
   */
  public static boolean testDequeueCustomProcessQueue() {
    CustomProcessQueue cQueue = new CustomProcessQueue();
    cQueue.enqueue(new CustomProcess(4));
    cQueue.enqueue(new CustomProcess(3));
    cQueue.enqueue(new CustomProcess(5));
    cQueue.enqueue(new CustomProcess(2));
    return cQueue.dequeue().getBurstTime() == 2 && cQueue.size() == 3;
  }

  /**
   * test the size method
   * 
   * @return true if the method works as expected, false otherwise
   */
  public static boolean testSizeCustomProcessQueue() {
    CustomProcessQueue cQueue = new CustomProcessQueue();
    cQueue.enqueue(new CustomProcess(4));
    cQueue.enqueue(new CustomProcess(3));
    cQueue.enqueue(new CustomProcess(5));
    cQueue.enqueue(new CustomProcess(2));
    return cQueue.size() == 4;
  }

  /**
   * test the peek method
   * 
   * @return true if the method works as expected, false otherwise
   */
  public static boolean testPeekCustomProcessQueue() {
    CustomProcessQueue cQueue = new CustomProcessQueue();
    cQueue.enqueue(new CustomProcess(4));
    cQueue.enqueue(new CustomProcess(3));
    cQueue.enqueue(new CustomProcess(5));
    cQueue.enqueue(new CustomProcess(2));
    return cQueue.peek().getBurstTime() == 2;
  }

}
