import java.util.Comparator;

public class PriorityQueue<E> {
    private MinHeap<E> elements;
    public PriorityQueue() {///natural ordering
        elements = new MinHeap<>();
    }
    public PriorityQueue(Comparator<E> c) {
        elements = new MinHeap<>(c);
    }
    public boolean contains(E item) {
        return elements.contains(item);
    }
    public void offer(E item) {//o(logn)
        elements.add(item);
    }
    public E poll() {//o(logn)
        return elements.remove();
    }
    public E peek() {//o(1)
        return elements.getRoot();
    }
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    public int size() {
        return elements.size();
    }
    public void clear() {
        elements.clear();
    }
    public String toString() {
        return elements.toString();
    }
}