import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
    LinkedList Generic Class
 */
public class LinkedList < E > {
    // Data members
    private Node head,
    tail;
    private int size;
    /**
        Inner class Node
    */
    private class Node {
        E value;
        Node next;
        Node previous;
        Node(E initialValue) {
            value = initialValue;
            next = null;
            previous = null;
        }
    }
    /**
        Default Constructor
        creates an empty linkedlist
        Time complexity: O(1)
    */
    public LinkedList() {
        head = tail = null;
        size = 0;
    }
    /**
        Adding a value at the head of the list
        @param value to be added
        @return true if the operation was successful
        Time complexity: O(1)
    */
    public boolean addFirst(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
        return true;
    }
    /**
        Adding a value at the tail of the list
        @param value to be added
        @return true if the operation was successful
        Time complexity: O(1)
    */
    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
        return true;
    }
    /**
        Adding a value at the tail of the list
        calls addLast
        @param value to be added
        @return true if the operation was successful
        Time complexity: O(1)
    */
    public boolean add(E item) {
        return addLast(item);
    }
    /**
        Get the value of the node at the head of the list
        @return value of the node at the head
        @throws NoSuchElementException if the list is empty
        Time complexity: O(1)
    */
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }
    /**
        Get the value of the node at the tail of the list
        @return value of the node at the tail
        @throws NoSuchElementException if the list is empty
        Time complexity: O(1)
     */
    public E getLast() {
        if (head == null)
            throw new NoSuchElementException();
        return tail.value;
    }
    /**
        Removes the node at the head of the list
        @return true if the remove operation was successful and decrements the size
        @throws NoSuchElementException if the list is empty
        Time complexity: O(1)
     */
    public boolean removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        head.next.previous = null;
        head = head.next;
        if (head == null) // removed the only node in the LL
            tail = null;
        size--;
        return true;
    }
    /**
        Removes the node at the tail of the list
        @return true if the remove operation was successful and decrements the size
        @throws NoSuchElementException if the list is empty
        Time complexity: O(n)
    */
    public boolean removeLast() {
        if (head == null)
            throw new NoSuchElementException();
        if (size == 1)
            return removeFirst();
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next.previous = null;
        current.next = null;
        tail = current;
        size--;
        return true;
    }
    /**
        toString method
        @return a formatted string that contains the values of all the nodes in the list
        Time complexity: O(n)
    */
    public String toString() {
        String output = "[";
        Node node = head;
        while (node != null) {
            output += node.value + " ";
            node = node.next;
        }
        output += "]";
        return output;
    }
    /**
        clear method
        restes size to 0 and head and tail to null
        Time complexity: O(1)
    */
    public void clear() {
        head = tail = null;
        size = 0;
    }
    /**
        isEmpty method
        @return true if the list is empty
        Time complexity: O(1)
    */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
        size method
        @return the number of nodes in the list
        Time complexity: O(1)
    */
    public int size() {
        return size;
    }

    /**
        iterator method
        @override iterator() from the interface Collection
        @return an iterator object pointing to the first value in the list
        Time complexity: O(1)
    */
    public ListIterator < E > listIterator() {
        return new LinkedListListIterator();
    }

    public ListIterator < E > listIterator(int index) {
        return new LinkedListListIterator(index);
    }
    /**
        Inner class that implements the interface Iterator
    */
    private class LinkedListListIterator implements ListIterator < E > {
        private Node current = head;
        public LinkedListListIterator() {

        }

        public LinkedListListIterator(int index) {

        }
        /**
            hasNext method
            @return true if the current is not null
            Time complexity: O(1)
         */
        public boolean hasNext() {
            return (current != null);
        }
        /**
            next method
            @return the value of the node referenced by current and 
                    modifies current to hold the reference of the next node
            @throws NoSuchElementException if current is null
            Time complexity: O(1)
         */
        public E next() {
            if (current == null)
                throw new NoSuchElementException();
            E value = current.value;
            current = current.next;
            return value;
        }

        public boolean hasPrevious() {
            return (current.previous != null);
        }

        public E previous() {
            if (current == null)
                throw new NoSuchElementException();
            E value = current.previous.value;
            current = current.previous;
            return value;
        }

        public void add(E value) {
            add(value);
        }

        public void remove() {
            if (head == null) {
                throw new NoSuchElementException();
            } else if (current == head) {
                removeFirst();
            } else if (current == tail) {
                removeLast();
            } else {
                current.next.previous = current.previous;
                current.previous = current.next;
            }
        }

        public void set(E value) {
            current.value = value;
        }

        public int nextIndex() {
            int index = 0;
            Node currents = head;
            while (current.next.equals(currents)) {
                current = current.next;
                index++;
            }
            index++;
            return index;
        }

        public int previousIndex() {
            int index = 0;
            Node currents = head;
            while (current.next.equals(currents)) {
                current = current.next;
                index++;
            }
            index--;
            return index;
        }
    }
}