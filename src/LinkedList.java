import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * FileName: LinkedList.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Generic Doubly Linked List  w/ Sentinel data structure
 */
public class LinkedList<T extends PlanarShape> implements Iterable<T> {
    private final Node<T> sentinel;                             // Sentinel node for start/end of CLL (cannot be changed)
    private int size;                                           // size of CLL (Excluding sentinel)
    private int modCount;                                       // Modifications to the LL

    public LinkedList() {
        //Setup sentinel node
        this.sentinel = new Node<T>(null);
        this.sentinel.setNextNode(this.sentinel);
        this.sentinel.setPrevNode(this.sentinel);

        this.size = 0;
        this.modCount = 0;
    }

    /**
     * append() method
     *
     * @param inData data to add to the end of the LL
     */
    public void append(T inData) {
        this.add(inData, this.sentinel);
    }

    /**
     * prepend() method
     *
     * @param inData data to add to the start of the LL
     */
    public void prepend(T inData) {
        this.add(inData, this.sentinel.getNextNode());
    }

    /**
     * insertInOrder() method
     *
     * @param inData data to insider into the LL (in order)
     */
    public void insertInOrder(T inData) {
        if (this.size == 0) { // LL is empty
            append(inData);
            return;
        }
        Node<T> temp = sentinel.getNextNode();
        for (int i = 0; i < this.size; i++) {
            if (inData.compareTo(temp.getData()) > 0) {
                add(inData, temp);
                return;
            }
            temp = temp.getNextNode();
        }
        this.append(inData);
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
        this.modCount++;
    }

    /**
     * take() method
     *
     * @return data stored at head of the list and delete the node
     */
    public T take() {
        T outData = this.sentinel.getNextNode().getData();
        this.sentinel.getNextNode().getNextNode().setPrevNode(this.sentinel);
        this.sentinel.setNextNode(this.sentinel.getNextNode().getNextNode());
        if (outData != null) {
            this.size--;
            this.modCount++;
        }
        return outData;
    }

    /**
     * iterator() method
     *
     * @return a iterator instance
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = sentinel; // set current to sentinel
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if(this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return current.getNextNode() != sentinel;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                current = current.getNextNode();
                return current.getData();
            }

            @Override
            public void remove() {
                this.current.getNextNode().setPrevNode(this.current.getPrevNode());
                this.current.getPrevNode().setNextNode(this.current.getNextNode());
                this.expectedModCount++; // fine because done inside iterator
                modCount++;
                size--;
            }
        };
    }

    /**
     * toString() method
     *
     * @return string representation of the LL
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(T o : this) {
            str.append(o); // objects stored have to have toString() overwritten
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * getSize() method
     *
     * @return the size of the LL
     */
    public int getSize() {
        return this.size;
    }
}




