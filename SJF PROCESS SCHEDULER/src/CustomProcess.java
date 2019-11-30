

/**
 * This class represents a customProcess object
 * 
 * @author user
 *
 */
public class CustomProcess implements Comparable<CustomProcess> {

  private static int nextProcessId = 1; // stores the id to be assigned to the next process
  // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * Constructs a customProcess object, initializes burstTime, PROCESSID.
   * 
   * @param burstTime the given burstTime
   */
  public CustomProcess(int burstTime) {
    this.burstTime = burstTime;
    PROCESS_ID = nextProcessId;
    nextProcessId++;
  }

  /**
   * compare two given customProcess objects
   * 
   * @param other the given customProcess object
   * @return -1 if the compared object is bigger, 1 if the compared object is smaller
   */
  @Override
  public int compareTo(CustomProcess other) {
    if (burstTime < other.getBurstTime())
      return -1;
    else if (burstTime > other.getBurstTime())
      return 1;
    else {
      if (PROCESS_ID < other.getProcessId())
        return -1;
      else
        return 1;
    }
  }

  /**
   * get the value of PROCESSID
   * 
   * @return the value of PROCESSID.
   */
  public int getProcessId() {
    return PROCESS_ID;
  }

  /**
   * get the value of burstTime
   * 
   * @return the value of burstTime.
   */
  public int getBurstTime() {
    return burstTime;
  }

}
