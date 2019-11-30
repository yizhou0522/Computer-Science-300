

import java.util.Iterator;

/**
 * This class represents a DrawingStack object and it implements StackADT
 * 
 * @author user
 *
 */
public class DrawingStack implements StackADT {

  Node<DrawingChange> head;// the head of Node
  int size;// the size of the stack

  /**
   * Add an object to the stack
   */
  @Override
  public void push(Object element) throws IllegalArgumentException {

    if (element == null) {
      throw new IllegalArgumentException();// throws exception if the input is not vaild
    }
    Node<DrawingChange> newNode = new Node(element, head);
    head = newNode;
    newNode = null;
    size++;
  }

  /**
   * remove the top of the object in stack
   * 
   * @return the object
   */
  @Override
  public Object pop() {
    Object remove = head.getData();
    head = head.getNext();
    size--;
    return remove;
  }

  /**
   * 
   * @return the top object in stack.
   */
  @Override
  public Object peek() {

    return head.getData();
  }

  /**
   * Check to see if the stack is empty
   * 
   * @return true if it is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * get the size of the stack
   * 
   * @return the number of the size
   */
  @Override
  public int size() {

    return this.size;
  }

  /**
   * get the iterator for this class
   * 
   * @return the iterator
   */
  @Override
  public Iterator iterator() {
    Iterator iterator = new DrawingStackIterator(head);
    return iterator;
  }

}
