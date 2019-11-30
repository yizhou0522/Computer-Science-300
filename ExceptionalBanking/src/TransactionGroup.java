

import java.util.zip.DataFormatException;


public class TransactionGroup {

  private enum EncodingType {
    BINARY_AMOUNT, INTEGER_AMOUNT, QUICK_WITHDRAW
  };

  private EncodingType type;
  private int[] values;

  /**
   * The constructor creates a TransactionGroup object.
   * 
   * @param groupEncoding is an int array which includes the transaction code
   * @throws DataFormatException is the case when the following six circumstances occur
   */
  public TransactionGroup(int[] groupEncoding) throws DataFormatException {
    if (groupEncoding == null)// int[] groupEncoding is null
      throw new DataFormatException("transaction group encoding cannot be null or empty");
    else if (groupEncoding[0] != 1 && groupEncoding[0] != 0 && groupEncoding[0] != 2)
      // groupEncoding is not beginning with 0,1,2
      throw new DataFormatException(
          "the first element within a transaction group must be 0, 1, or 2");
    this.type = EncodingType.values()[groupEncoding[0]];
    if (type == EncodingType.BINARY_AMOUNT) {
      for (int i = 0; i < groupEncoding.length; i++)
        if (groupEncoding[i] != 1 && groupEncoding[i] != 0)// array contains integer other 1s or 0s
          throw new DataFormatException(
              "binary amount transaction groups may only contain 0s and 1s");
    }
    if (type == EncodingType.INTEGER_AMOUNT) {
      for (int i = 0; i < groupEncoding.length; i++) {
        if (groupEncoding[i] == 0)// array contains 0s
          throw new DataFormatException("integer amount transaction groups may not contain 0s");
      }
    }
    if (type == EncodingType.QUICK_WITHDRAW) {
      if (groupEncoding.length != 5)// array's length is not equal to 5
        throw new DataFormatException("quick withdraw transaction groups must contain 5 elements");
      for (int i = 0; i < groupEncoding.length; i++) {
        if (groupEncoding[i] < 0)//array contains negative integers
          throw new DataFormatException(
              "quick withdraw transaction groups may not contain negative numbers");
      }
    }
    this.values = new int[groupEncoding.length - 1];
    for (int i = 0; i < values.length; i++)
      this.values[i] = groupEncoding[i + 1];
  }

  /**
   * This method intends to get transaction count under each circumstance
   * 
   * @return the number of transaction count
   */
  public int getTransactionCount() {
    int transactionCount = 0;
    switch (this.type) {
      case BINARY_AMOUNT:
        int lastAmount = -1;
        for (int i = 0; i < this.values.length; i++) {
          if (this.values[i] != lastAmount) {
            transactionCount++;
            lastAmount = this.values[i];
          }
        }
        break;
      case INTEGER_AMOUNT:
        transactionCount = values.length;
        break;
      case QUICK_WITHDRAW:
        for (int i = 0; i < this.values.length; i++)
          transactionCount += this.values[i];
    }
    return transactionCount;
  }

  /**
   * This method intends to get the total amount of transaction under the given index
   * 
   * @param transactionIndex is the given index
   * @return the total number of transaction under the given index
   */
  public int getTransactionAmount(int transactionIndex) {
    if (transactionIndex < 0 || transactionIndex >= getTransactionCount())
      throw new IndexOutOfBoundsException("Index cannot be accessed with the value"
          + transactionIndex + " the current transaction count " + getTransactionCount());
    // throw indexoutofbound exception when the given index is either smaller than 0 or bigger than
    // the bound
    int transactionCount = 0;
    switch (this.type) {
      case BINARY_AMOUNT:
        int lastAmount = -1;
        int amountCount = 0;
        for (int i = 0; i <= this.values.length; i++) {
          if (i == this.values.length || this.values[i] != lastAmount) {
            if (transactionCount - 1 == transactionIndex) {
              if (lastAmount == 0)
                return -1 * amountCount;
              else
                return +1 * amountCount;
            }
            transactionCount++;
            lastAmount = this.values[i];
            amountCount = 1;
          } else
            amountCount++;
          lastAmount = this.values[i];
        }
        break;
      case INTEGER_AMOUNT:
        return this.values[transactionIndex];
      case QUICK_WITHDRAW:
        final int[] QW_AMOUNTS = new int[] {-20, -40, -80, -100};
        for (int i = 0; i < this.values.length; i++)
          for (int j = 0; j < this.values[i]; j++)
            if (transactionCount == transactionIndex)
              return QW_AMOUNTS[i];
            else
              transactionCount++;
    }
    return -1;
  }

}
