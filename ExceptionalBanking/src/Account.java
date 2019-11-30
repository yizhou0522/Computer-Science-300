
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Account {

  private static final int MAX_GROUPS = 10000;
  private static int nextUniqueId = 1000;

  private String name;
  private final int UNIQUE_ID;
  private TransactionGroup[] transactionGroups;
  private int transactionGroupsCount;

  /**
   * Creates an Account object
   * 
   * @param name is the String name of the object
   */
  public Account(String name) {
    this.name = name;
    this.UNIQUE_ID = Account.nextUniqueId;
    Account.nextUniqueId++;
    this.transactionGroups = new TransactionGroup[MAX_GROUPS];
    this.transactionGroupsCount = 0;
  }

  /**
   * Creates an Account object with the given file
   * 
   * @param file is the given file
   * @throws FileNotFoundException is the exception being thrown when the file is null or not exist
   */
  public Account(File file) throws FileNotFoundException {
    // NOTE: THIS METHOD SHOULD NOT BE CALLED MORE THAN ONCE, BECAUSE THE
    // RESULTING BEHAVIOR IS NOT DEFINED WITHIN THE JAVA SPECIFICATION ...
    Scanner in = new Scanner(file);
    // ... THIS WILL BE UPDATED TO READ FROM A FILE INSTEAD OF SYSTEM.IN.
    this.name = in.nextLine();
    this.UNIQUE_ID = Integer.parseInt(in.nextLine());
    Account.nextUniqueId = this.UNIQUE_ID + 1;
    this.transactionGroups = new TransactionGroup[MAX_GROUPS];
    this.transactionGroupsCount = 0;
    String nextLine = "";
    try {
      while (in.hasNextLine())
        this.addTransactionGroup(in.nextLine());
    } catch (DataFormatException e) {
      System.out.println("DataFormatExcepetion!!");
    } finally {
      in.close();
    }

  }

  /**
   * Get the account ID
   * 
   * @return the account ID
   */
  public int getId() {
    return this.UNIQUE_ID;
  }

  /**
   * Add a transaction group.
   * 
   * @param command is the given command by users.
   * @throws DataFormatException is the exception when the command contains value other than
   *         integers
   */
  public void addTransactionGroup(String command) throws DataFormatException {
    String[] parts = command.split(" ");
    int[] newTransactions = new int[parts.length];
    for (int i = 0; i < parts.length; i++) {
      try {
        newTransactions[i] = Integer.parseInt(parts[i]);
      } catch (NumberFormatException e) {
        throw new DataFormatException(
            "addTransactionGroup requires string commands that contain only space separated integer values");
      }
    }
    TransactionGroup t = new TransactionGroup(newTransactions);
    if (transactionGroupsCount == transactionGroups.length)
      throw new OutOfMemoryError(
          " The transaction group is already full with transaction number of "
              + transactionGroupsCount);
    this.transactionGroups[this.transactionGroupsCount] = t;
    this.transactionGroupsCount++;
  }

  /**
   * Get the transaction count for this object
   * 
   * @return the exact number of the transaction count in this Account object
   */
  public int getTransactionCount() {
    int transactionCount = 0;
    for (int i = 0; i < this.transactionGroupsCount; i++)
      transactionCount += this.transactionGroups[i].getTransactionCount();
    return transactionCount;
  }

  /**
   * Get the transaction amount of one given group
   * 
   * @param index is the given index
   * @return the number of transaction amount within one given group
   */
  public int getTransactionAmount(int index) {// one group has how many amount of transaction
    if (index < 0 || index > getTransactionCount())
      throw new IndexOutOfBoundsException("Index cannot be accessed with the value" + index
          + " The total number of accessible transactions is " + transactionGroupsCount);
    int transactionCount = 0;
    for (int i = 0; i < this.transactionGroupsCount; i++) {
      int prevTransactionCount = transactionCount;
      transactionCount += this.transactionGroups[i].getTransactionCount();
      if (transactionCount > index) {
        index -= prevTransactionCount;
        return this.transactionGroups[i].getTransactionAmount(index);
      }
    }
    return -1;
  }

  /**
   * Get the current balance for this object
   * 
   * @return the number of current balance
   */
  public int getCurrentBalance() {
    int balance = 0;
    int size = this.getTransactionCount();
    for (int i = 0; i < size; i++)
      balance += this.getTransactionAmount(i);
    return balance;
  }

  /**
   * Get the number of overdrafts for this object
   * 
   * @return return the number of overdrafts
   */
  public int getNumberOfOverdrafts() {
    int balance = 0;
    int overdraftCount = 0;
    int size = this.getTransactionCount();
    for (int i = 0; i < size; i++) {
      int amount = this.getTransactionAmount(i);
      balance += amount;
      if (balance < 0 && amount < 0)
        overdraftCount++;
    }
    return overdraftCount;
  }

}
