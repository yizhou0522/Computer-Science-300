import java.util.Arrays;


public class AuditableBankingTests {

  /**
   * The main method aims to test the following methods in AuditableBanking class.
   * 
   */
  public static void main(String[] args) {
    System.out.println(AuditableBankingTests.testCalculateNumberOfOverdrafts());
    System.out.println(AuditableBankingTests.testCalculateCurrentBalance());
    System.out.println(AuditableBankingTests.testProcessCommand());
  }

  /**
   * This method aims to decide whether processCommand can correctly add a transaction group when
   * the allTransaction collection is not full. It also help decides whether it can stop adding new
   * group when the allTransaction if full.
   * 
   * @return true if processCommand() method returns the correct result, false otherwise.
   */
  public static boolean testProcessCommand() {
    boolean foundProblem = false;
    String command = "0 1 0 0 1 1 1 0 1";// an example command
    int[][] allTransactions = new int[5][];// an example allTransactions collection which is not
                                           // full
    allTransactions[0] = new int[] {1, 10, -20, +30, -20, -20}; // +2 overdrafts (ending balance:
                                                                // -20)
    allTransactions[1] = new int[] {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}; // +2 overdrafts (ending balance:
                                                                   // -15)
    allTransactions[2] = new int[] {1, 115};// +0 overdrafts (ending balance: +100)
    allTransactions[3] = new int[] {2, 3, 1, 0, 1}; // +1 overdrafts (ending balance: -100)
    int newTransactionsCount1 = AuditableBanking.processCommand(command, allTransactions, 4);
    if (newTransactionsCount1 != 5) {// tests with the expected value 5 when the allTransaction
                                     // collection is not full
      foundProblem = true;
      System.out.println(
          "FAILURE:Cannot add a transaction when the allTransaction twoD array is not full");
    } else {
      System.out.println("PASSED TEST 1/2 of testProcessCommand!!!");
    }
    int[][] transactions = new int[][] {{1, 10, -20, +30, -20, -20}, // +2 overdrafts (ending
                                                                     // balance: -20)
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // +2 overdrafts (ending balance: -15)
        {1, 115}, // +0 overdrafts (ending balance: +100)
        {2, 3, 1, 0, 1}, // +1 overdrafts (ending balance: -100)
    };// an example allTransactions collection which is already full
    int newTransactionsCount2 = AuditableBanking.processCommand(command, transactions, 4);
    if (newTransactionsCount2 != 4) {// tests with the expected value 4 when the allTransaction
                                     // collection is already full
      foundProblem = true;
      System.out.println(
          "FAILURE:Can STILL add a transaction when the allTransaction twoD array is full");
    } else {
      System.out.println("PASSED TEST 2/2 of testProcessCommand!!!");
    }

    return !foundProblem;
  }

  /**
   * This method aims to decide whether CalculateCurrentBalance() method can return the correct
   * number of current balance by changing different transaction number.
   * 
   * @return true if CalculateCurrentBalance() method returns the correct result, false otherwise.
   */
  public static boolean testCalculateCurrentBalance() {
    boolean foundProblem = false;
    int[][] transactions = new int[][] {{1, 10, -20, +30, -20, -20}, // +2 overdrafts (ending
        // balance: -20)
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // +2 overdrafts (ending balance: -15)
        {1, 115}, // +0 overdrafts (ending balance: +100)
        {2, 3, 1, 0, 1}, // +1 overdrafts (ending balance: -100)
    };
    int currentBalance = AuditableBanking.calculateCurrentBalance(transactions, 2);
    if (currentBalance != -15) { // tests with the expected value -15 with two transaction group
      foundProblem = true;
      System.out.println(
          "FAILURE:calculateCurrentBalance doesn't return -15 when transactionNumber is 2, and transactions contained "
              + Arrays.deepToString(transactions));
    } else {
      System.out.println("PASSED TEST 1/2 of testProcessCommand!!!");
    }
    int currentBalance1 = AuditableBanking.calculateCurrentBalance(transactions, 4);
    if (currentBalance1 != -100) { // tests with the expected value -100 with four transaction group
      foundProblem = true;
      System.out.println(
          "FAILURE:calculateCurrentBalance doesn't return -100 when transactionNumber is 4 , and transactions contained: "
              + Arrays.deepToString(transactions));
    } else {
      System.out.println("PASSED TEST 2/2 of testProcessCommand!!!");
    }

    return !foundProblem;
  }

  /**
   * This method aims to decide if the CalculateNumberOfOverdrafts() can return the correct value of
   * overdrafts within the current balance. It relies on the similar method with the
   * testCalculateCurrentBalance() to decide if the program runs well.
   * 
   * @return true if CalculateNumberOfOverdrafts() method returns the correct result, false
   *         otherwise.
   */
  public static boolean testCalculateNumberOfOverdrafts() {
    boolean foundProblem = false;
    int[][] transactions = new int[][] {{1, 10, -20, +30, -20, -20}, // +2 overdrafts (ending
                                                                     // balance: -20)
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // +2 overdrafts (ending balance: -15)
        {1, 115}, // +0 overdrafts (ending balance: +100)
        {2, 3, 1, 0, 1}, // +1 overdrafts (ending balance: -100)
    };

    // test with a single transaction of the Integer Amount encoding
    int transactionCount = 1;
    int overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
    if (overdrafts != 2) {// tests with the expected value 2
      System.out.println(
          "FAILURE: calculateNumberOfOverdrafts did not return 2 when transactionCount = 1, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TEST 1/2 of TestCalculateNumberOfOverdrafts!!!");

    // test with four transactions: including one of each encoding
    transactionCount = 4;
    overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
    if (overdrafts != 5) {// tests with the expected value 5
      System.out.println(
          "FAILURE: calculateNumberOfOverdrafts did not return 5 when transactionCount = 4, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TESTS 2/2 of TestCalculateNumberOfOverdrafts!!!");

    return !foundProblem;
  }

}
