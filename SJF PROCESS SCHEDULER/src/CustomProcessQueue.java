

import java.util.Arrays;

/**
 * The class represents a CustomProcessQueue object and it implements waiting queue ADT
 * 
 * @author user
 *
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {

  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue

  /**
   * The constructor creates a customProcessQueue object, and initializes customProcess array.
   */
  public CustomProcessQueue() {
    heap = new CustomProcess[INITIAL_CAPACITY];
  }

  /**
   * inserts a newObject in the priority queue
   * 
   * @param newObject is the given new object
   */
  @Override
  public void enqueue(CustomProcess newObject) {
    if (size >= heap.length) // grow when more space is needed within array
      heap = Arrays.copyOf(heap, heap.length * 2); // copy heap into bigger array
    size++;
    heap[size] = newObject;// add the element at the end of the heap array
    minHeapPercolateUp(size);
  }

  /**
   * removes and returns the item with the highest priority
   * 
   * @return the item with the highest priority
   */
  @Override
  public CustomProcess dequeue() {
    if (size < 1)
      return null;
    CustomProcess temp = heap[1];
    heap[1] = heap[size];
    heap[size] = null;
    size--;//remove the root element of the heap
    minHeapPercolateDown(1);
    return temp;
  }

  /**
   * returns without removing the item with the highest priority
   * 
   * @return the item with the highest priority
   */
  @Override
  public CustomProcess peek() {
    if (size < 1)
      return null;
    return heap[1];

  }

  /**
   * get the value of size of the queue
   * 
   * @return size of the waiting queue
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * checks if the waiting queue is empty
   * 
   * @return true if the queue is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * percolate up the heap until the heap order meets
   * 
   * @param index the initial index begin to percolate
   */
  private void minHeapPercolateUp(int index) {
    if (index == 1)
      return;
    else {
      if (heap[index].compareTo(heap[index / 2]) > 0)
        return;
      else {
        swap(heap, index, index / 2);
        minHeapPercolateUp(index / 2);
      }
    }
  }

  /**
   * percolate down the heap until the heap order meets
   * 
   * @param index the initial index begin to percolate
   */
  private void minHeapPercolateDown(int index) {
    if (size < 2)
      return;
    else {
      if (index * 2 > heap.length || heap[index * 2] == null )
        return;
      else if (heap[index].compareTo(heap[2 * index]) < 0
        )
        return;
      else if (heap[index].compareTo(heap[2 * index]) > 0) {
        swap(heap, index, 2 * index);
        minHeapPercolateDown(index * 2);
      } else {
        swap(heap, index, 2 * index + 1);
        minHeapPercolateDown(index * 2 + 1);
      }
    }
  }

  /**
   * swap the two given index of array
   * 
   * @param heap the given heap array
   * @param p is the given index
   * @param q is another given index
   */
  private void swap(CustomProcess[] heap, int p, int q) {
    CustomProcess temp = heap[p];
    heap[p] = heap[q];
    heap[q] = temp;
  }

  /**
   * get the heap array
   * 
   * @return the heap array
   */
  public CustomProcess[] getHeap() {
    return heap;
  }
}
