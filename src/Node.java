/**
 * FileName: Node.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Generic Node class, used in the creation of the CLL
 */

public class Node<T> {
    private T data;                                                 // Data to store in the node
    private Node<T> nextNode;                                      // Node after this node
    private Node<T> prevNode;                                      // Node before this node

    /**
     * Node class constructor when no args are given
     */
    Node() {
        this.data = null;
        this.nextNode = null;
        this.prevNode = null;
    }

    /**
     * Node class constructor when data, next and prev nodes are given
     *
     * @param inData     data to be added too the node
     * @param inNextNode Node to set as the next node of this one
     * @param inPrevNode Node to set as the prev node of this one
     */
    Node(T inData, Node<T> inNextNode, Node<T> inPrevNode) {
        this();                                                 // Initialise values from base constructor
        this.data = inData;
        this.nextNode = inNextNode;
        this.prevNode = inPrevNode;
    }

    /**
     * Node class constructor when only data is given
     * Sets next and prev pointers too itself
     *
     * @param inData data to be added too the node
     */
    Node(T inData) {
        this();
        this.data = inData;
        this.setNextNode(this);                                 // Set next pointer to itself
        this.setPrevNode(this);                                 // Set prev pointer too itself
    }

    /**
     * getData() method
     *
     * @return the data stored in the node
     */
    public T getData() {
        return data;
    }

    /**
     * setData() method
     * Does not allow you to set the data to null
     *
     * @param inData data to set as the data of this node
     */
    public void setData(T inData) {
        if (inData != null) {                                   // Or else it will become a Sentinel, BAD!
            this.data = inData;
        }
    }

    /**
     * getNextNode() method
     *
     * @return the node that is after this node
     */
    public Node<T> getNextNode() {
        return nextNode;
    }

    /**
     * setNextNode() method
     *
     * @param nextNode Node to set as the next node of this one
     */
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * getPrevNode() method
     *
     * @return the node that is before this node
     */
    public Node<T> getPrevNode() {
        return prevNode;
    }

    /**
     * setPrevNode() method
     *
     * @param prevNode Node to set as the prev node of this one
     */
    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }
}
