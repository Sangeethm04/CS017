import java.util.ArrayList;

public class Utility {
    /**
     * Helper method to use mergeSort to sort array
     */
    //time complexity: O(nlogn)
    private void mergeSort() {
        mergeSort(accounts, count);
    }


    /**
  Merge sort method
  @param list to be sorted
  @param size # of items to sort
    */
    //time complexity: O(nlogn)
    private static void mergeSort(ArrayList < E > list, Comparator<E> c) {
        if (size > 1) { // length==1: base case
            // split list into two halves
            ArrayList < BankAccount > firstHalf = new ArrayList < > (size / 2);
            ArrayList < BankAccount > secondHalf = new ArrayList < > (size - (size / 2));
            // copy the first half of list into the array firstHalf
            System.arraycopy(list, 0, firstHalf, 0, size / 2);
            // copy the second half of list into the array secondtHalf
            System.arraycopy(list, size / 2, secondHalf, 0, size - (size / 2));
            // recursive call on each half
            mergeSort(firstHalf, size / 2);
            mergeSort(secondHalf, size - (size / 2));
            // merge the sorted halves back into list
            merge(firstHalf, secondHalf, list);
        }
    }
    /**
      merge method used by mergeSort
      @param list where the merged elements will be stored
      @param list1 the first sorted list to be merged
      @param list2 the second sorted list to be merged
    */
    //time complexity: O(n)
    private static void merge(ArrayList < BankAccount > list1, ArrayList < BankAccount > list2, ArrayList < BankAccount > list) {
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

    private ArrayList<E> subList() {

    }
}