public interface ILinkedList<T> {
    public void append(T inData);
    public void prepend(T inData);
    public void insertInOrder(T inData);
    public T take();
}
