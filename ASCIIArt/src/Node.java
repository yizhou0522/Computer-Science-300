

/**
 * Node class for LinkedList for Stack<T>
 * 
 * @param <T> type of data of node
 */
public class Node<T> {
  private final T data;
  private Node<T> next;

  /**
   * Creates a Node object
   * 
   * @param element is the given element
   * @param next is the given node
   */
  public Node(T element, Node<T> next) {
    this.data = element;
    this.next = next;
  }

  /**
   * set the value of next
   * 
   * @param next is the given next
   */
  public void setNext(Node<T> next) {
    this.next = next;
  }

  /**
   * get the value of next
   * 
   * @return the value of next
   */
  public Node<T> getNext() {
    return this.next;
  }

  /**
   * get the data of one specific node
   * 
   * @return the value of the data
   */
  public T getData() {
    return this.data;
  }
}
