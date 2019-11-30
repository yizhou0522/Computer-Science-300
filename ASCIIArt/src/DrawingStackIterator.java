import java.util.Iterator;

public class DrawingStackIterator implements Iterator<DrawingChange> {

  private Node<DrawingChange> currentNode;

  public DrawingStackIterator(Node<DrawingChange> node) {

    this.currentNode = node;
  }



  @Override
  public boolean hasNext() {

    return currentNode != null;
  }

  @Override
  public DrawingChange next() {
    DrawingChange d = currentNode.getData();
    currentNode = currentNode.getNext();
    return d;
  }


}
