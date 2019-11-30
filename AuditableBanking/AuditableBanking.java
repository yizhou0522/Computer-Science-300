import java.util.Scanner;


public class AuditableBanking {
  /**
   * The main method aims to visualize the transaction in front of the users. With different types
   * of users' commands, it will add new transaction group, show current balance, show number of
   * overdrafts in current balance, and quit the program respectively.
   * 
   */
  public static void main(String[] args) {
    int[][] allTransactions = new int[100][];
    int allTransactionsCount = 0;
    Scanner scan = new Scanner(System.in);
    System.out.println(" ========== Welcome to the Auditable Banking App ==========");
    for (int i = 0; i < 100; i++) { // this for loop prints
      System.out.println(" COMMAND MENU:");
      System.out.println("  Submit a Transaction (enter sequence of integers separated by spaces)");
      System.out.println("  Show Current [B]alance");
      System.out.println("  Show Number of [O]verdrafts");
      System.out.println("  [Q]uit Program");
      System.out.print(" ENTER COMMAND:");
      String command = scan.nextLine();
      if (command.equals("B") || command.equals("b")) {// show the current balance
        System.out.println("Current Balance:"
            + AuditableBanking.calculateCurrentBalance(allTransactions, allTransactionsCount));
      } else if (command.equals("O") || command.equals("o")) {// show the number of overdrafts
        System.out.println("Number of Overdrafts:"
            + AuditableBanking.calculateNumberOfOverdrafts(allTransactions, allTransactionsCount));
      } else if (command.equals("Q") || command.equals("q")) {//quit the program
        break;
      } else {// adds a new transaction group
        AuditableBanking.processCommand(command, allTransactions, allTransactionsCount);
        allTransactionsCount++;
      }
      System.out.println("\n");
    }
    System.out.println(" ============ Thank you for using this App!!!! ============");

  }

  /**
   * Adds a transaction group to an array of transaction groups and return the new
   * allTransactionsCount after the group is added. If the allTransactions array is already full
   * then this method will do nothing other than return allTransactionCount.
   * 
   * @param newTransactions is the new transaction group being added (perfect size).
   * @param allTransactions is the collection that newTransactions is being added to (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *        newTransactions is added.
   * @return the number of transaction groups within allTransactions after newTransactions is added.
   */

  public static int submitTransactions(int[] newTransactions, int[][] allTransactions,
      int allTransactionsCount) {

    if (allTransactionsCount + 1 > allTransactions.length)// decides whether the allTransactions
                                                          // group is full
      return allTransactionsCount;

    else {
      allTransactions[allTransactionsCount] = newTransactions;
      return ++allTransactionsCount;
    }

  }

  /**
   * Processing users'commands and add it to the allTransactions collection if it is not full and
   * contains the legal transaction codes.
   * 
   * @param command is the user input of transaction number
   * @param allTransactions is the collection that newTransactions is being added to (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *        newTransactions is added.
   * @return the number of transaction groups within allTransactions after newTransactions is added.
   */
  public static int processCommand(String command, int[][] allTransactions,
      int allTransactionsCount) {
    String[] a = command.trim().split(" ");// gains the string array of user input without any
                                           // spaces
    int[] b = new int[a.length];// declares an int array with the same size as string array
    for (int i = 0; i < b.length; i++) {// assign the elements in string array into int array
      b[i] = Integer.parseInt(a[i]);
    }
    if (b[0] != 1 && b[0] != 0 && b[0] != 2)// decides whether the command code is legal
      return allTransactionsCount;
    else {
      int temp = submitTransactions(b, allTransactions, allTransactionsCount);
      return temp;
    }

  }

  /**
   * This method first determines which type of transaction code is input by the user. And it uses
   * the for loop to iterate the allTransaction array, calculate and return the number of
   * currentBalance.
   * 
   * @param allTransactions is the collection that newTransactions is being added to (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *        newTransactions is added.
   * @return the exact number of current balance.
   */
  public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) {
    int numCurrentBalance = 0;// record the number of current balance throughout the method
    for (int i = 0; i < allTransactionsCount; i++) {
      if (allTransactions[i][0] == 0) {// considering the binary amount transactions
        for (int k = 1; k < allTransactions[i].length; k++) {
          if (allTransactions[i][k] == 0)
            numCurrentBalance--;
          else
            numCurrentBalance++;
        }

      } else if (allTransactions[i][0] == 1) {// considering the integer amount transaction

        for (int k = 1; k < allTransactions[i].length; k++)
          numCurrentBalance = numCurrentBalance + allTransactions[i][k];
      } else {
        for (int k = 1; k < allTransactions[i].length; k++)// considering the quick withdraw
                                                           // transaction
          switch (k) {
            case 1:
              numCurrentBalance = numCurrentBalance - allTransactions[i][k] * 20;
              break;
            case 2:
              numCurrentBalance = numCurrentBalance - allTransactions[i][k] * 40;
              break;
            case 3:
              numCurrentBalance = numCurrentBalance - allTransactions[i][k] * 80;
              break;
            case 4:
              numCurrentBalance = numCurrentBalance - allTransactions[i][k] * 100;
              break;
            default:
              break;
          }
      }
    }
    return numCurrentBalance;
  }

  /**
   * This method aims to calculate and return the number of overdrafts by adding a numCurrentBalance
   * when iterating the allTransaction loop.
   * 
   * @param allTransactions is the collection that newTransactions is being added to (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *        newTransactions is added.
   * @return the exact number of overdrafts in current balance.
   */
  public static int calculateNumberOfOverdrafts(int[][] allTransactions, int allTransactionsCount) {
    int numOverdrafts = 0;// record the number of overdrafts throughout the method
    int numCurrentBalance = 0;// record the number of current balance; it aims to help decide
                              // whether current balance is negative or not after a withdraw
    for (int i = 0; i < allTransactionsCount; i++) {// iterate the allTransaction for loop
      if (allTransactions[i][0] == 0) {// considering the binary amount transaction
        for (int k = 1; k < allTransactions[i].length; k++) {
          if (allTransactions[i][k] == 0)
            numCurrentBalance--;
          else
            numCurrentBalance++;
          if (allTransactions[i][k] == 0 && numCurrentBalance < 0)
            numOverdrafts++;
        }

      } else if (allTransactions[i][0] == 1) {// considering the integer amount transaction

        for (int k = 1; k < allTransactions[i].length; k++)

        {
          numCurrentBalance = numCurrentBalance + allTransactions[i][k];
          if (allTransactions[i][k] < 0 && numCurrentBalance < 0)
            numOverdrafts++;
        }
      } else {
        for (int k = 1; k < allTransactions[i].length; k++) {// considering the quick withdraw
                                                             // transactions
          switch (k) {// following the rules of quick withdraw transaction
            case 1:
              numCurrentBalance = numCurrentBalance - allTransactions[i][k] * 20;
              break;
            case 2:
              numCurrentBalance = numCurrentBalance - allTransactions[i][k] * 40;
              break;
            case 3:
              numCurrentBalance = numCurrentBalance - allTransactions[i][k] * 80;
              break;
            case 4:
              numCurrentBalance = numCurrentBalance - allTransactions[i][k] * 100;
              break;
            default:
              break;
          }
          if (numCurrentBalance < 0)
            numOverdrafts++;
        }
      }
    }

    return numOverdrafts;
  }
}
