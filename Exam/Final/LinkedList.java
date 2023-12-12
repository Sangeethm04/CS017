import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;
/**
 * LinkedList class to model a list with linked nodes
 */
public class LinkedList < E > {
    // Data members
    private Node head,
    tail;
    private int size;
    /**
     * Inner class to model the nodes of the list
     */
    private class Node {
        //data members
        E value;
        Node next;
        /**
         * Constructor
         * @param initialValue of the node value
         */
        Node(E initialValue) {
            value = initialValue;
            next = null;
        }
    }
    /**
     * Default constructor
     * creates an empty linked list
     */
    public LinkedList() {
        head = tail = null;
        size = 0;
    }
    /**
     * Method addFirst
     * @param value of the new node to be added to the head of the list
     * @return true
     */
    public boolean addFirst(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }
    /**
     * Method addLast
     * @param value of the new node to be added to the tail of the list
     * @return true 
     */
    public boolean addLast(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }
    /**
     * Method add
     * @param value of the new node to be added to the list (end of the list)
     * @return true
     */
    public boolean add(E item) {
        return addLast(item);
    }
    /**
     * Method getFirst
     * @return the value of the first node in the list
     * @throws NoSuchElementException if such node does not exist
     */
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }
    /**
     * Method getLast
     * @return the value of the last node in the list
     * @throws NoSuchElementException if such node does not exist
     */
    public E getLast() {
        if (head == null)
            throw new NoSuchElementException();
        return tail.value;
    }
    /**
     * Method removeFirst
     * @return true if the first node of the list was removed
     * @throws NoSuchElementException if such node does not exist
     */
    public boolean removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return true;
    }
    /**
     * Method removeLast
     * @return true if the last node of the list was removed
     * @throws NoSuchElementException if such node does not exist
     */
    public boolean removeLast() {
        if (head == null)
            throw new NoSuchElementException();
        if (size == 1)
            return removeFirst();
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        size--;
        return true;
    }
    /**
     * Method toString
     * @return a formatted list with the values of the all the nodes in the list
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
     * Method clear to reset the list to an empty list
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }
    /**
     * Method isEmpty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * Method size
     * @return the number of nodes in the list
     */
    public int size() {
        return size;
    }

    /**
     * Method iterator
     * @return an iterator object positioned at the first node of the list
     */
    public Iterator < E > iterator() {
        return new LinkedListIterator();
    }
    /**
     * Inner class to implement the interface Iterator for this linked list
     */
    private class LinkedListIterator implements Iterator < E > {
        // Data member
        private Node current = head;
        /**
         * Method hasNext
         * @return true if the current node is not null
         */
        public boolean hasNext() {
            return (current != null);
        }
        /**
         * Method next
         * @return the value of the node current and moves current to point to the next node
         */
        public E next() {
            if (current == null)
                throw new NoSuchElementException();
            E value = current.value;
            current = current.next;
            return value;
        }
    }

    /**
     * Search method
     * @param o object being searched in the linked list
     * @return true if a node with value o was found in the list, false otherwise
     */
    public boolean contains(Object o) {
        E value = (E) o;
        Iterator < E > iter = iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(value)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Find method
     * @param value to be searched in the linked list
     * @return the value of the node whose value is equal to the parameter value
     */
    public E find(E value) {
        Iterator < E > iter = iterator();
        while (iter.hasNext()) {
            E nodeValue = iter.next();
            if (nodeValue.equals(value)) {
                return nodeValue;
            }
        }
        return null;
    }
    /**
     * Method get
     * @param index of the node being accesses
     * @return the value of the node at position index
     * @throws ArrayIndexOutOfBoundsException if index is not a valid index
     */
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    /**
     * Method set
     * @param index of the node being modified
     * @param newValue of the node at position index
     * @return the old value of the node at position index
     * @throws ArrayIndexOutOfBoundsException if index is not a valid index
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        E oldValue = node.value;
        node.value = newValue;
        return oldValue;
    }
    /**
     * Method remove
     * @param o the value of the node to be removed if found
     * @return true if a node with value is found and removed, false if no node was not found
     */
    public boolean remove(Object o) {
        Node current = head;
        Node previous = null;
        E value = (E) o;
        while (current != null && !current.value.equals(value)) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (previous == null) {
            return removeFirst();
        }
        previous.next = current.next;
        if (current == tail) {
            tail = previous;
        }
        size--;
        return true;
    }
    /**
     * Method sort
     * @param comp the comparator object used to sort the nodes of the list
     * The method uses the bubble sort algorithm
     */
    public void sort(Comparator < E > comp) {
        boolean sorted = false;
        for (int k = 1; k < size() && !sorted; k++) {
            sorted = true;
            for (int i = 0; i < size() - k; i++) {
                if (comp.compare(this.get(i),this.get(i + 1)) > 0) {
                    Node current = head;
                    for(int j =0; j < i; j++) {
                        current = current.next;
                    }
                    Node old = current.next;
                    current = old;
                    sorted = false;
                }
            }
        }

    }
}