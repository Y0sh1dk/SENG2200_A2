import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T extends PlanarShape> implements Iterable<T>, ILinkedList<T> {
    private final Node<T> sentinel;                                // Sentinel node for start/end of CLL (cannot be changed)
    private int size;                                           // size of CLL (Excluding sentinel)

    public LinkedList() {
        this.sentinel = new Node<T>(null);
        this.size = 0;
    }

    @Override
    public void append(T inData) {
        this.add(inData, this.sentinel);
    }

    /**
     * prepend() method
     *
     * @param inData data to add to the start of the CLL
     */
    @Override
    public void prepend(T inData) {
        this.add(inData, this.sentinel.getNextNode());
    }

    @Override
    public void insertInOrder(T inData) {
        // TODO: this
    }

    /**
     * add() method
     *
     * @param inData data to be inserted at the index of the given node
     * @param n      the node to determine where to insert the data (at this nodes index)
     */
    private void add(T inData, Node<T> n) {
        Node<T> temp = new Node<T>(inData);                     // Create new node
        temp.setNextNode(n);                                    // Set new nodes next
        temp.setPrevNode(n.getPrevNode());                      // set new nodes prev
        n.getPrevNode().setNextNode(temp);                      // set left nodes next to new node
        n.setPrevNode(temp);                                    // set right nodes prev to new node
        this.size++;
    }

    //TODO: test
    @Override
    public T take() {
        T outData = this.sentinel.getNextNode().getData();
        this.sentinel.getNextNode().getNextNode().setPrevNode(this.sentinel);
        this.sentinel.setNextNode(this.sentinel.getNextNode().getNextNode());
        if (outData != null) {
            this.size--; // TODO: can become negative, fix
        }
        return outData;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = sentinel; // set current to sentinel

            @Override
            public boolean hasNext() {
                return current.getNextNode().getData() != null;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                current = current.getNextNode();
                return current.getData();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(T o : this) {
            str.append(o); // objects stored have to have toString() overwritten
            str.append("\n");
        }
        return str.toString();
    }

    public int getSize() {
        return this.size;
    }
}




