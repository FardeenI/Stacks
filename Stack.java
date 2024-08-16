interface Stack<E> extends Iterable<E> {
    E pop();
    void push(E data);
}
