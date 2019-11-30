

import java.util.Scanner;

/**
 * This class represents the driver class of the whole project
 * 
 * @author user
 *
 */
public class ProcessScheduler { 
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private CustomProcessQueue queue; // this processing unit's custom process queue

  /**
   * Constructs a processScheduler, initializes all the variables
   */
  public ProcessScheduler() {
    currentTime = 0;
    numProcessesRun = 0;
    queue = new CustomProcessQueue();
  }

  /**
   * The driving program starts here.
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ProcessScheduler pScheduler = new ProcessScheduler();
    boolean isBreak = false;
    int burstTime;
    System.out.println("==========   Welcome to the SJF Process Scheduler App   ========");
    while (!isBreak) {
      System.out.println("Enter command: ");
      System.out.println("[schedule <burstTime>] or [s <burstTime>] ");
      System.out.println("[run] or [r] ");
      System.out.println("[quit] or [q] ");
      try {
        String command = scan.nextLine().trim().toLowerCase();
        String[] input = command.split(" ");
        if (!(input[0].equals("schedule") || input[0].equals("s") || input[0].equals("run")
            || input[0].equals("r") || input[0].equals("quit") || input[0].equals("q"))) {
          System.out.println("WARNING: Please enter a valid command!\n");
          continue;// catches the illegal commands
        }
        if (input[0].equals("schedule") || input[0].equals("s")) {// 's' command
          burstTime = Integer.parseInt(input[1]);
          if (burstTime <= 0) {
            System.out.println("WARNING: burst time MUST be greater than 0!\n");
            continue;// catches the illegal number
          }
          pScheduler.scheduleProcess(new CustomProcess(burstTime));
          System.out.println("Process ID " + ++pScheduler.numProcessesRun
              + " scheduled. Burst Time = " + burstTime + "\n");
        }
        if (input[0].equals("run") || input[0].equals("r")) {// 'r' command
          System.out.println(pScheduler.run());
        }
        if (input[0].equals("quit") || input[0].equals("q")) {// 'q' command
          System.out
              .println(pScheduler.numProcessesRun + " processes run in " + pScheduler.currentTime
                  + " units of time!\n" + "Thank you for using our scheduler!\n" + "Goodbye!\n");
          isBreak = true;
        }
      } catch (NumberFormatException e) {// catches non-integer input
        System.out.println("WARNING: burst time MUST be an integer!\n");
        continue;
      }
    }
  }

  /**
   * Adds a customProcess object to the queue
   * 
   * @param process the given CustomProcess object
   */
  public void scheduleProcess(CustomProcess process) {
    queue.enqueue(process);
  }

  /**
   * simulates the running process
   * 
   * @return the result string processed by run method
   */
  public String run() {
    StringBuilder sBuilder = new StringBuilder();
    if (queue.size() == 1 || queue.size() == 0)
      sBuilder.append("Starting " + queue.size() + " process\n\n");
    else
      sBuilder.append("Starting " + queue.size() + " processes\n\n");
    for (int i = 0; i < queue.size();) {// size will automatically decrease one by each loop
      CustomProcess temp = queue.dequeue();
      sBuilder
          .append("Time " + currentTime + " : Process ID " + temp.getProcessId() + " Starting.\n");
      currentTime += temp.getBurstTime();
      sBuilder
          .append("Time " + currentTime + ": Process ID " + temp.getProcessId() + " Completed.\n");
    }
    sBuilder.append("\nTime " + currentTime + ": All scheduled processes completed.\n");
    return sBuilder.toString();
  }
}
