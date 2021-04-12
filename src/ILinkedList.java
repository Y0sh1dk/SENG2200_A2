/**
 * FileName: ILinkedList.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Generic Linked List interface, ensures that Linked List complies to spec
 */

public interface ILinkedList<T> {
    public void append(T inData);
    public void prepend(T inData);
    public void insertInOrder(T inData);
    public T take();
}
