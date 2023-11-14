import java.util.Comparator;
/**
 * priority queue implemented with min heap
 */
public class PriorityQueue<E> {
    private MinHeap<E> elements;
    /**
     * default constructor
     */
    public PriorityQueue() {///natural ordering
        elements = new MinHeap<>();
    }
    /**
     * constructor with one parameter
     * @param c comparator for ordering
     */
    public PriorityQueue(Comparator<E> c) {
        elements = new MinHeap<>(c);
    }

    /**
     * check if contains item
     * @param item item to check
     * @return boolean 
     */
    public boolean contains(E item) {
        return elements.contains(item);
    }

    /**
     * add item to queue
     * @param item to add
     */
    public void offer(E item) {//o(logn)
        elements.add(item);
    }

    /**
     * remove item from queue
     * @return item removed
     */
    public E poll() {//o(logn)
        return elements.remove();
    }

    /**
     * get item at front of queue
     * @return E item
     */
    public E peek() {//o(1)
        return elements.getRoot();
    }

    /**
     * check if queue is empty
     * @return boolean isempty
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * get size of queue
     * @return int size
     */
    public int size() {
        return elements.size();
    }

    /**
     * clear queue
     */
    public void clear() {
        elements.clear();
    }

    /**
     * tostring method
     * @return String
     */
    public String toString() {
        return elements.toString();
    }
}