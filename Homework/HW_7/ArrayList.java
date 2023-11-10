import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
    Generic class to impelment an array based list
 */
public class ArrayList < E > {
  // data member: array for the list elements
  private E[] elements;
  // data member: size of the list
  private int size;
  /**
       Default constructor creates the array with a default length of 10 and sets size to 0
       Time complexity: O(1)
   */
  public ArrayList() {
    elements = (E[]) new Object[10];
    size = 0;
  }
  /**
       Constructor with one parameter creates the array with length equal to capacity and sets size to 0
       @param capacity length of the arrat elements
       Time complexity: O(1)
   */
  public ArrayList(int capacity) {
    elements = (E[]) new Object[capacity];
    size = 0;
  }
  /**
       Method to add a new item at the end of the list
       @param item the value of the item to be added
       @return true if item was added successfully, false otherwise
       Time complexity: O(1) or O(n) if the array capacity needs to grow
   */
  public boolean add(E item) {
    return add(size, item);
  }
  /**
      Method to add a new item a given position index
      @param index the position where item should be added
      @param item the value of the element to be added
      @return true if item was added successfully, false otherwise
      @throws ArrayIndexOutOfBoundsException if index < 0 or index > size
      Time complexity: O(n)
  */
  public boolean add(int index, E item) {
    if (index > size || index < 0)
      throw new ArrayIndexOutOfBoundsException();
    ensureCapacity();
    for (int i = size - 1; i >= index; i--) {
      elements[i + 1] = elements[i];
    }
    elements[index] = item;
    size++;
    return true;
  }
  /**
      Get the value of the element at index
      @param index of the element being accessed
      @return the value of the element at index
      @throws ArrayIndexOutofBounds if index < 0 or index >= size
      Time complexity: O(1)
   */
  public E get(int index) {
    checkIndex(index);
    return elements[index];
  }
  /**
      Set the value of the element at index
      @param index of the element being modified
      @param value new value of the element at index
      @return the old value of the element at index
      @throws ArrayIndexOutofBounds if index < 0 or index >= size
      Time complexity: O(1)
   */
  public E set(int index, E newValue) {
    checkIndex(index);
    E oldValue = elements[index];
    elements[index] = newValue;
    return oldValue;
  }
  /**
      Get the size of the list
      @return the number of elements in the list
      Time complexity: O(1)
   */
  public int size() {
    return size;
  }
  /**
      Clear the list by setting size to 0
      Time complexity: O(1)
   */
  public void clear() {
    size = 0;
  }
  /**
      Predicate to check if the list is empty
      @return true if the list is empty, false otherwise
      Time complexity: O(1)
   */
  public boolean isEmpty() {
    return (size == 0);
  }
  /**
      Remove the element at a given index
      @param index the position of the element to be removed
      @return true if the elements was removed successfully, false otherwise
      @throws ArrayIndexOutofBoundsException if index < 0 or index >= size
      Time complexity: O(n)
   */
  public boolean remove(int index) {
    checkIndex(index);
    for (int i = index; i < size - 1; i++)
      elements[i] = elements[i + 1];
    size--;
    return true;
  }
  /**
      Resize the length of the array 'elements' to the size of the list
      Time complexity: O(n) if trimming needed
   */
  public void trimToSize() {
    if (size != elements.length) {
      E[] newElements = (E[]) new Object[size];
      for (int i = 0; i < size; i++)
        newElements[i] = elements[i];
      elements = newElements;
    }
  }
  /**
       Grow the length of the array 'elements' by 1.5 if it is full
       Time complexity: O(n) if the size reaches the capacity
   */
  private void ensureCapacity() {
    if (size >= elements.length) {
      int newCap = (int)(elements.length * 1.5);
      E[] newElements = (E[]) new Object[newCap];
      for (int i = 0; i < size; i++)
        newElements[i] = elements[i];
      elements = newElements;
    }
  }
  /**
      Check if the index is valid
      @param index to be checked
      @throws ArrayIndexOutOFBoundsException is index is out of bounds
      Time complexity: O(1)
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new ArrayIndexOutOfBoundsException(
        "Index out of bounds. Must be between 0 and " + (size - 1));
  }
  /**
      @override toString() from class Object
      @return a formatted string containing the elements of the list
      Time complexity: O(n)
   */
  public String toString() {
    String output = "[";
    for (int i = 0; i < size - 1; i++)
      output += elements[i] + " ";
    output += elements[size - 1] + "]";
    return output;
  }
  /**
      @override iterator() from the interface Collection
      @return iterator object pointing to the first element the list
      Time complexity: O(1)
   */
  public ListIterator < E > listIterator() {
    return new ArrayListIterator();
  }

  public ListIterator < E > listIterator(int index) {
    return new ArrayListIterator(index);
  }
  /**
      Inner class to implement the interface Iterator<E>
   */
  private class ArrayListIterator implements ListIterator < E > {
    // data member current: the index of the element at which the iterator is pointing
    private int current = 0;
    /**
        Default constructor
        Time complexity: O(1)
     */
    public ArrayListIterator() {

    }

    /**
     * Constructor with one parameter
     * @param index
     */
    public ArrayListIterator(int index) {
      current = index;
    }

    /**
        @return true if current did not reach the end of the list, false otherwise
        Time complexity: O(1)
     */
    public boolean hasNext() {
      return current < size;
    }
    /**
        @return the value of the current element and moves the index current to the next element
        @throws ArrayIndexOutOfBoundsException if current is out of bounds
        Time complexity: O(1)
     */
    public E next() {
      if (current < 0 || current >= size)
        throw new ArrayIndexOutOfBoundsException("No more elements");
      return elements[current++];
    }

    /**
     * checks if there is a previous element
     * @return true if there is a previous element, false otherwise
     */
    public boolean hasPrevious() {
      return (elements[current - 1] != null);
    }

    /**
     * returns the previous element
     * @return the previous element
     */
    public E previous() {
      if (elements[current - 1] == null) {
        throw new NoSuchElementException();
      }
      E one = elements[(current - 1)];
      current -= 1;
      return one;
    }

    /**
     * adds an element to the list
     * @param value to be added
     */
    public void add(E value) {
      ensureCapacity();
      for (int i = size - 1; i >= current; i--)
        elements[i + 1] = elements[i];
      elements[current] = value;
      size++;
    }

    /**
     * removes an element from the list
     */
    public void remove() {
      checkIndex(current);
      for (int i = current; i < size - 1; i++)
        elements[i] = elements[i + 1];
      size--;
    }

    /**
     * sets an element to the list
     * @param value to be set
     */
    public void set(E value) {
      elements[current] = value;
    }

    /**
     * returns the next index
     * @return int the next index
     */
    public int nextIndex() {
      return (current + 1);
    }

    /**
     * returns the previous index
     * @return int the previous index
     */
    public int previousIndex() {
      return (current - 1);
    }
  }
}