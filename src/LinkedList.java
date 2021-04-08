import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T extends PlanarShape> implements Iterable<T> {
    private final Node<T> sentinel;                                // Sentinel node for start/end of CLL (cannot be changed)
    private int size;                                           // size of CLL (Excluding sentinel)

    public LinkedList() {
        this.sentinel = new Node<T>(null);
        this.size = 0;
    }

    public void append(T inData) {
        this.add(inData, this.sentinel);
    }

    /**
     * prepend() method
     *
     * @param inData data to add to the start of the CLL
     */
    public void prepend(T inData) {
        this.add(inData, this.sentinel.getNextNode());
    }

    /**
     * add() method
     *
     * @param inData data to be inserted at the index of the given node
     * @param n      the node to determine where to insert the data (at this nodes index)
     */
    private void add(T inData, Node<T> n) {
        Node<T> temp = new Node<T>(inData);                           // Create new node
        temp.setNextNode(n);                                    // Set new nodes next
        temp.setPrevNode(n.getPrevNode());                      // set new nodes prev
        n.getPrevNode().setNextNode(temp);                      // set left nodes next to new node
        n.setPrevNode(temp);                                    // set right nodes prev to new node
        this.size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = sentinel.getNextNode(); // set current to head

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
}




