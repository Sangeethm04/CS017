import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

public class MinHeap < E > {
    // ArrayList where the nodes of the heap are stored
    private ArrayList < E > list;
    private Comparator < E > comp;
    public static int addIterations,
    removeIterations;
    /**
     * Default Constructor
     */
    public MinHeap() { //create a heap that uses the natural ordering of E to order the nodes
        list = new ArrayList < > ();
        comp = null;
    }
    /**
     * Constructor with one parameter
     * @param c comparator used to order the nodes of the heap
     */
    public MinHeap(Comparator < E > c) { //create a heap that uses the comparator of E to order the nodes
        list = new ArrayList < > ();
        comp = c;
    }
    /**
     * Method size
     * @return the number of nodes in the heap
     */
    public int size() {
        return list.size();
    }
    /**
     * Method isEmpty
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    /**
     * Method to empty the heap
     */
    public void clear() {
        list.clear();
    }
    /**
     * Method toString
     * @return a formatted string containing the values of the nodes of the heap
     */
    public String toString() {
        return list.toString();
    }
    /**
     * Method getRoot
     * @return the value of the root
     */
    //O(1)
    public E getRoot() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }
    /**
     * Method contains
     * @param value the value being searched in the heap
     * @return true if the value is found, false otherwise
     */
    public boolean contains(E value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value))
                return true;
        }
        return false;
    }
    /**
     * Method add
     * @param value to be added to the heap
     * reconstructs the heap to keep the MaxHeap properties
     */
    //log(n)
    public void add(E value) {
        addIterations = 0;
        list.add(value);
        int currentIndex = list.size() - 1;
        while (currentIndex > 0) {
            addIterations++;
            int parentIndex = (currentIndex - 1) / 2;
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            int result = 0;
            if (comp == null) { //compareTo
                result = ((Comparable) current).compareTo(parent);
            } else { // use comp.compare
                result = comp.compare(current, parent);
            }
            if (result < 0) {
                list.set(currentIndex, parent);
                list.set(parentIndex, current);
            } else
                break;
            currentIndex = parentIndex;
        }
    }
    /**
     * Method remove
     * @return the value of the root, null if the heap is empty
     * reconstructs the heap to keep the MaxHeap properties
     */
    //log(n)
    public E remove() {
        removeIterations = 0;
        if (list.isEmpty())
            return null;
        E removedItem = list.get(0);
        list.set(0, list.get(list.size() - 1)); // value of the root = value of the last node in the heap
        list.remove(list.size() - 1); // remove the last node
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            removeIterations++;
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            if (left >= list.size())
                break;
            //finding smallest of the two children of current node
            int minIndex = left;
            E min = list.get(minIndex);
            if (right < list.size()) {
                int result = 0;
                if (comp == null) {
                    result = ((Comparable) min).compareTo(list.get(right));
                } else {
                    result = comp.compare(min, list.get(right));
                }
                if (result > 0)
                    minIndex = right;
            }

            E current = list.get(currentIndex);
            min = list.get(minIndex);
            //compare the node to the smallest of its children
            int result = 0;
            if (comp == null) {
                result = ((Comparable) current).compareTo(min);
            } else {
                result = comp.compare(current, min);
            }
            if (result > 0) {
                list.set(minIndex, current);
                list.set(currentIndex, min);
                currentIndex = minIndex;
            } else
                break;
        }
        return removedItem;
    }
}