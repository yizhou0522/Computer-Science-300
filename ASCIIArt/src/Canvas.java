


/**
 * This class represents a canvas object
 * 
 * @author user
 *
 */
public class Canvas {

  private final int width; // width of the canvas
  private final int height; // height of the canvas

  private char[][] drawingArray; // 2D character array to store the drawing

  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  /**
   * Creates a canvas object with given parameters
   * 
   * @param width is the given width
   * @param height is the given height
   */
  public Canvas(int width, int height) {
    if (width <= 0 || height <= 0)
      throw new IllegalArgumentException();// Throws IllegalArgumentException if width
    // or height is 0 or negative
    this.width = width;
    this.height = height;
    this.undoStack = new DrawingStack();
    this.redoStack = new DrawingStack();
    drawingArray = new char[height][width];
    for (int i = 0; i < drawingArray.length; i++)
      for (int k = 0; k < drawingArray[i].length; k++)
        drawingArray[i][k] = ' ';// A Canvas is initially blank (use the space ' ' character)

  }

  /**
   * Draw a character at the given position
   * 
   * @param row is the given row number
   * @param col is the given col number
   * @param c is the given character
   */
  public void draw(int row, int col, char c) {
    if (row < 0 || row >= height || col < 0 || col >= width)
      throw new IllegalArgumentException();// This method should throw an IllegalArgumentException
                                           // if the drawing position is outside the canvas
    char record = drawingArray[row][col];
    drawingArray[row][col] = c;
    undoStack.push(new DrawingChange(row, col, record, c));// add a matching DrawingChange
    while (!redoStack.isEmpty()) {
      redoStack.pop();// // After making a new change, the redoStack should be empty.

    }

  }

  /**
   * Undo the most recent drawing change.
   * 
   * @return true if successful. False otherwise.
   */
  public boolean undo() {
    if (undoStack.isEmpty())
      return false;
    DrawingChange change = (DrawingChange) undoStack.pop();
    drawingArray[change.x][change.y] = change.prevChar;
    redoStack.push(new DrawingChange(change.x, change.y, change.prevChar, change.newChar));
    // An undone DrawingChange should be added to the redoStack so that we can redo if needed.
    return true;
  }

  /**
   * Redo the most recent undone drawing change.
   * 
   * @return true if successful; False otherwise.
   */
  public boolean redo() {
    if (redoStack.isEmpty())
      return false;
    DrawingChange change = (DrawingChange) redoStack.pop();
    drawingArray[change.x][change.y] = change.newChar;
    undoStack.push(new DrawingChange(change.x, change.y, change.prevChar, change.newChar));
    // A redone DrawingChange should be added to the undoStack so that we can undo again if needed.
    return true;
  }

  /**
   * a string of format should be printed
   * 
   * @return a printable string version of the Canvas.
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < drawingArray.length; i++) {
      for (int k = 0; k < drawingArray[i].length; k++) {
        stringBuilder.append(drawingArray[i][k]);
      }
      stringBuilder.append(System.lineSeparator());
    }
    return stringBuilder.toString();

  }

  /**
   * print the history of the undo stacks
   */
  public void printHistory() {
    while (!undoStack.isEmpty()) {
      DrawingChange d = (DrawingChange) undoStack.pop();
      System.out.println(
          undoStack.size() + 1 + ". " + "draw " + d.newChar + " on (" + d.x + "," + d.y + ")");
    }
  }
}
