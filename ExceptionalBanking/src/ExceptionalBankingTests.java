
import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class ExceptionalBankingTests {

  public static void main(String[] args) throws DataFormatException {
    int numFails = 0;
    if (!testAccountBalance())
      numFails++;
    if (!testAccountAddNegativeQuickWithdraw())
      numFails++;
    if (!testAccountBadTransactionGroup())
      numFails++;
    if (!testAccountIndexOutOfBounds())
      numFails++;
    if (!testAccountMissingFile())
      numFails++;
    if (!testOverdraftCount())
      numFails++;
    if (!testTransactionGroupEmpty())
      numFails++;
    if (!testTransactionGroupInvalidEncoding())
      numFails++;
    if (numFails == 0)//no test fails
      System.out.println("ALL TEST PASS");
    else
      System.out.println("FAIL IN ONE OR MORE TESTS");
  }

  /**
   * This method checks whether the getAccountBalance() get the expected value of account balance.
   * 
   * @return true when the result matches, and false otherwise.
   */
  public static boolean testAccountBalance() {
    Account account = new Account("test");

    try {
      account.addTransactionGroup("0 1 1 1 0 0 1 1 1 1");// 3-2+4=5
      account.addTransactionGroup("1 10 -20 +30 -20 -20");// 5+10-20+30-40=-15
      account.addTransactionGroup("2 3 1 0 1");// -15-60-40-100=-215
    } catch (DataFormatException e) {
      System.out.println("DataFormatException!!");
    }
    return account.getCurrentBalance() == -215;
  }

  /**
   * This method checks whether the getNumberofOverdraft get the expected value of overdrafts
   * 
   * @return true when the result matches, and false otherwise.
   */
  public static boolean testOverdraftCount() {
    Account account = new Account("test");
    try {
      account.addTransactionGroup("0 1 1 1 0 0 1 1 1 1");
      account.addTransactionGroup("1 10 -20 +30 -20 -20");//
      account.addTransactionGroup("2 3 1 0 1");//
    } catch (DataFormatException e) {
      System.out.println("DataFormatException!!");
    } //
    return account.getNumberOfOverdrafts() == 7;
  }

  /**
   * This method checks whether the TransactionGroup constructor throws an exception with an
   * appropriate message, when it is passed an empty int[].
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   * @throws DataFormatException
   */
  public static boolean testTransactionGroupEmpty() {
    int[] test = null;
    try {
      TransactionGroup t = new TransactionGroup(test);
    } catch (DataFormatException e) {
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the TransactionGroup constructor throws an exception with an
   * appropriate message, when then first int in the provided array is not 0, 1, or 2.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testTransactionGroupInvalidEncoding() {
    int[] test = new int[] {4, 1, 0, 1, 0};
    try {
      TransactionGroup t = new TransactionGroup(test);
    } catch (DataFormatException e) {
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account.addTransactionGroup method throws an exception with an
   * appropriate message, when it is passed a quick withdraw encoded group that contains negative
   * numbers of withdraws.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountAddNegativeQuickWithdraw() {
    int[] test = new int[] {2, -1, 0, 1, 0};
    try {
      TransactionGroup t = new TransactionGroup(test);
    } catch (DataFormatException e) {
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account.addTransactionGroup method throws an exception with an
   * appropriate message, when it is passed a string with space separated English words (non-int).
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountBadTransactionGroup() {
    String test = "1 1 h";
    try {
      Account account = new Account("test");
      account.addTransactionGroup(test);
    } catch (DataFormatException e) {
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account.getTransactionAmount method throws an exception with an
   * appropriate message, when it is passed an index that is out of bounds.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountIndexOutOfBounds() {
    try {
      Account account = new Account("test");
      account.getTransactionAmount(-1);
    } catch (IndexOutOfBoundsException e) {
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account constructor that takes a File parameter throws an
   * exception with an appropriate message, when it is passed a File object that does not correspond
   * to an actual file within the file system.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountMissingFile() {
    File file = new File("file.txt");
    try {
      Account account = new Account(file);
    } catch (FileNotFoundException e) {
      return true;
    }
    return false;
  }
}
