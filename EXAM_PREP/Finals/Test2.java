import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        //1
        //reverseString("india");

        //2
        ArrayList < String > array = new ArrayList < > ();
        array.add("aello");
        array.add("aangeeth");
        array.add("aello");
        array.add("zob");
        ArrayList < Integer > array2 = new ArrayList < > ();
        array2.add(1);
        array2.add(1);
        array2.add(33333);
        array2.add(4);
                array2.add(444);

                
        quickSort(array2);

        for (int i = 0; i < array2.size(); i++) {
            System.out.println(array2.get(i));
        }


    }

    //2
    public static void reverseString(String word) {
        String news = "";
        System.out.println(reverseString(word, news));
    }

    public static String reverseString(String word, String fixed) {
        if (word.length() == 0) {
            return fixed;
        } else {
            fixed += word.charAt(word.length()-1);
            return reverseString(word.substring(0, word.length() - 1), fixed);

        }
    }
    // Write a generic recursive method removeDuplicates that removes duplicates from an ArrayList. The method returns a new ArrayList that contains the distinct elements from the original list.
    public static < E > void removeDuplicates(ArrayList < E > array) {
        ArrayList < E > newArray = new ArrayList < > ();

            removeDuplicates(array, newArray, 0);
        for (int i = 0; i < newArray.size(); i++) {
            System.out.println(newArray.get(i));
        }
    }

    public static < E > void removeDuplicates(ArrayList < E > array, ArrayList < E > newArray, int index) {
        if (index == array.size()) {
            return;
        } else {
            if(!newArray.contains(array.get(index))) {
                newArray.add(array.get(index));
            }
            removeDuplicates(array, newArray, ++index);
      
        }
    }


    public static <E extends Comparable<E>> E findMax(ArrayList<E> arr) {
        E max = arr.get(0);

        for(int i =0; i< arr.size(); i++) {
            if(arr.get(i).compareTo(max) > 0) {
                max = arr.get(i);
            }
        }
        return max;
    }


    /**
     * QuickSort Method
     * @param list to be sorted
     * Time complexity: O(nlogn) to O(n^2)
     */
    public static < E extends Comparable < E >> void quickSort(ArrayList<E> list) {
        quickSort(list, 0, list.size() - 1);
    }
    /**
     * QuickSort Recursie Helper Method
     * @param list to be sorted
     * @param first the index where to start quicksorting
     * @param last the index where to stop quicksorting
     * Time complexity: O(nlogn) to O(n^2)
     */
    // The quicksort algorithm covered in class selects the first element in the list as the pivot. Revise it by selecting the median among the first, middle, and the last elements in the list.
    public static < E extends Comparable < E >> void quickSort(ArrayList<E> list, int first, int last) {
        if (first < last) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    /**
     * Partition method used by quicksort
     * @param list to be sorted
     * @param first the index where to start the partitioning
     * @param last the index where to stop partitioning
     * @return the index where the pivot is placed
     * Time complexity: O(n)
     */
    //The quicksort algorithm covered in class selects the first element in the list as the pivot. Revise it by selecting the median among the first, middle, and the last elements in the list.
    public static < E extends Comparable < E >> int partition(ArrayList<E> list, int first, int last) {
        E pivot;
        int middle = (first + last) / 2;
    
        // Get the median of first, middle, and last elements
        E firstElem = list.get(first);
        E middleElem = list.get(middle);
        E lastElem = list.get(last);
    
        int pivotIndex;
        if ((firstElem.compareTo(middleElem) <= 0 && firstElem.compareTo(lastElem) >= 0) || 
            (firstElem.compareTo(middleElem) >= 0 && firstElem.compareTo(lastElem) <= 0)) {
            pivotIndex = first;
        } else if ((middleElem.compareTo(firstElem) <= 0 && middleElem.compareTo(lastElem) >= 0) || 
                   (middleElem.compareTo(firstElem) >= 0 && middleElem.compareTo(lastElem) <= 0)) {
            pivotIndex = middle;
        } else {
            pivotIndex = last;
        }
    
        pivot = list.get(pivotIndex);
        swap(list, first, pivotIndex); // Move pivot to the start
    
        int i = first + 1;
        for (int j = first + 1; j <= last; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                swap(list, i, j);
                i++;
            }
        }
        swap(list, first, i - 1); // Move pivot to its final place
        return i - 1;
    }

    public static < E > void swap(ArrayList < E > list, int index1, int index2) {
        if (index1 < 0 || index1 >= list.size() || index2 < 0 || index2 >= list.size())
            throw new ArrayIndexOutOfBoundsException();
        E temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

}