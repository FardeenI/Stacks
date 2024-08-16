import java.util.Iterator;

class RStack<E> implements Stack<E> {
    public Iterator<E> iterator()
    {
        return new Iterator<E>()
        {
            public boolean hasNext()
            {
                return curr != null;
            }
            public E next()
            {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }
            Node<E> curr = head;
        };
    }


    private class Node<T> { // Node class objects to implement linked-list based stack data structure
        private T data;
        private Node(T data)
        {
            this.data = data;
        }
        private Node<T> next;
    }

    private Node<E> head; // Head Node for end management

    public void push(E data) // Method to insert an element onto the stack
    {
        Node<E> temp = new Node<E>(data); // Create a new node to store desired data
        temp.next = head; // Establish a pointer from the new node to the head of the data structure to maintain list linkage
        head = temp; // Establish the new node as the new reference to the head of the list
    }

    public E pop() // Method to return the element at the top of the stack
    {
        E temp = null; // Establish a variable to store the desired data
        if (head != null) { // End management: Checking if the linked-list exists/If the data structure is empty
            temp = head.data; // Copy the data from the top/head node into the temporary variable, temp
            head = head.next; // Move the current reference to the head node to the subsequent node in the linked-list, effectively removing the current head and establishing the next node as the head
        }
        return temp; // Return the data at the head
    }
}
