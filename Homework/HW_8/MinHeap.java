import java.util.NoSuchElementException;
import java.util.Comparator;
public class MinHeap<E> {
    // ArrayList where the nodes of the heap are stored
    private ArrayList<E> list;
    private Comparator<E> comp;
    /**
     * Default Constructor
     */
    public MinHeap(){// use the natural ordering
        list = new ArrayList<>();
        comp = null;
    }
    /**
     * Constructor with one parameter
     * @param c a comparator object to order the nodes of the heap
     */
    public MinHeap(Comparator<E> c){// use the natural ordering
        list = new ArrayList<>();
        comp = c;
    }
    /**
     * Method size
     * @return the number of nodes in the heap
     */
    public int size(){
        return list.size(); 
    }
    /**
     * Method isEmpty
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    /**
     * Method to empty the heap
     */
    public void clear(){
        list.clear(); 
    }
    /**
     * Method toString
     * @return a formatted string containing the values of the nodes of the heap
     */
    public String toString(){
        return list.toString();
    }
    /**
     * Method getRoot
     * @return the value of the root
     */
    public E getRoot(){
        if (list.isEmpty()){
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
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(value))
                return true;
        }
        return false;
    }
    /**
     * Method add
     * @param value to be added to the heap
     * reconstructs the heap to keep the MaxHeap properties
     */
    public void add(E value) {
        list.add(value);
        int currentIndex = list.size()-1; 
        while(currentIndex > 0) {
            ArrayList.sortIterations++;
            LinkedList.sortIterations++;
            int parentIndex = (currentIndex-1)/2;
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            int result = 0;
            if(comp == null){ // natural oredering
                result = ((Comparable)current).compareTo(parent);
            }
            else{ // use comparator
                result = comp.compare(current, parent);
            }
            if(result < 0) {
                list.set(currentIndex, parent);
                list.set(parentIndex, current);
            }
            else
                break;
            currentIndex = parentIndex;
        }
    }
    /**
     * Method remove
     * @return the value of the root, null if the heap is empty
     * reconstructs the heap to keep the MaxHeap properties
     */
    public E remove() {
        if(list.isEmpty()) 
            return null;
        E removedItem = list.get(0);
        list.set(0, list.get(list.size()-1)); // value of the root = value of the last node in the heap
        list.remove(list.size()-1);// remove the last node
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            ArrayList.sortIterations++;
            LinkedList.sortIterations++;

            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            if (left >= list.size()) 
                break;
            // finding the smallest of the two children
            int minIndex = left;
            E min = list.get(minIndex);//left child is the min
            if (right < list.size()){
                int result = 0;
                if(comp ==  null){
                    result = ((Comparable)min).compareTo(list.get(right));
                }
                else{
                    result = comp.compare(min, list.get(right));
                }
                if(result > 0)// right child is the smallest
                    minIndex = right;//set minIndex to the index of the right child
            }
            E current = list.get(currentIndex);
            min = list.get(minIndex); 
            int result = 0;
            if(comp == null){
                result = ((Comparable)current).compareTo(min);
            }  
            else{
                result = comp.compare(current, min);
            }         
            if(result > 0){
                list.set(minIndex, current);
                list.set(currentIndex, min);
                currentIndex = minIndex;
            }
            else
                break;
        }
        return removedItem;
    }
}