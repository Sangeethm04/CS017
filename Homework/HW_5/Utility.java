import java.util.ArrayList;
import java.util.Comparator;

public class Utility {


    /**
  Merge sort method
  @param list to be sorted
  @param size # of items to sort
    */
    //time complexity: O(nlogn)
    public static < E > void mergeSort(ArrayList < E > list, Comparator < E > c) {
        if (list.size() > 1) { // length==1: base case
            // split list into two halves
            ArrayList < E > firstHalf = subList(list, 0, list.size() / 2);
            ArrayList < E > secondHalf = subList(list, list.size() / 2, (list.size() - (list.size() / 2)));
            // copy the first half of list into the array firstHalf
            firstHalf = subList(list, 0, list.size() / 2);
            // copy the second half of list into the array secondtHalf
            secondHalf = subList(list, 0, list.size() - (list.size() / 2));
            // recursive call on each half
            mergeSort(firstHalf, c);
            mergeSort(secondHalf, c);
            // merge the sorted halves back into list
            merge(firstHalf, secondHalf, list, c);
        }
    }

    public static < E > ArrayList < E > subList(ArrayList < E > ray, int start, int end) throws ArrayIndexOutOfBoundsException {
        if (start > ray.size() || start < 0 || end > ray.size() || end < 0 || start > end) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (start == end) {
            return null;
        }
        ArrayList < E > tempArray = new ArrayList < > ();
        for (int i = start; i < end; i++) {
            tempArray.add(ray.get(i));
        }
        return tempArray;
    }
    /**
      merge method used by mergeSort
      @param list where the merged elements will be stored
      @param list1 the first sorted list to be merged
      @param list2 the second sorted list to be merged
    */
    //time complexity: O(n)
    public static < E > void merge(ArrayList < E > 11, ArrayList < E > 12, ArrayList < E > 1, Comparator < E > c) {
        int list1Index = 0;
        int list2Index = 0;
        int listIndex = 0;
        while (list1Index < list1.size() && list2Index < list2.size()) {
            // order array by owners name
            if (list1.get(list1Index).getOwner().compareTo(list2.get(list2Index).getOwner()) < 0)
                list[listIndex++] = list1[list1Index++];
            else
                list[listIndex++] = list2[list2Index++];
        }
        // copy the remaining elements of list1 if list1 is longer than list2
        while (list1Index < list1.length)
            list[listIndex++] = list1[list1Index++];
        // copy the remaining elements of list2 if list2 is longer than list1
        while (list2Index < list2.size())
            list[listIndex++] = list2[list2Index++];
    }
}