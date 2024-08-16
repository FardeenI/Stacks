import java.util.Iterator;

class AStack<E> implements Stack<E> {
    private class StackIterator<E> implements Iterator<E>
    {
        private int curr = top;


        public boolean hasNext()
        {
            return curr > 0;
        }
        public E next()
        {
            return (E)stack[--curr];
        }
    }


    public Iterator<E> iterator() {
        return new StackIterator<E>();
    }


    private Object[] stack = new Object[10]; // Array object to hold stack data structure
    private int top; // Integer for end management


    public void push(E data) { // Method to insert an element onto the stack
        if (top >= stack.length) {
            grow(); // Managing end by calling grow() to expand data structure, preventing stack overflow
        }
        stack[top++] = data;
    }


    public E pop() { // Method to return the element at the top of the stack
        if (stack.length > 10 && top <= stack.length / 3) {
            shrink(); // Managing end by calling shrink() to minimize data structure, de-allocatinng unused memory
        }
        E temp = null;
        if (top > 0) {
            temp = (E)stack[--top];
        }
        return temp;
    }


    private void grow() { // Method to expand data structure
        Object[] temp = new Object[stack.length * 2];
        for (int i = 0; i < stack.length; ++i) {
            temp[i] = stack[i];
        }
        stack = temp;
    }


    public void shrink() { // Method to minimize data structure
        Object[] temp = new Object[stack.length / 2];
        for (int i = 0; i < temp.length; ++i) {
            temp[i] = stack[i];
        }
        stack = temp;
    }
}
