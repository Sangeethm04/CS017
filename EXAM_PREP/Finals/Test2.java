import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        //1
        //reverseString("india");

        //2
        ArrayList<String> array = new ArrayList<>();
        array.add("Hello");
        array.add("Sangeeth");
        array.add("Hello");
        array.add("bob");
        removeDuplicates(array);
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(1);
        array2.add(2);
        array2.add(1);
        array2.add(4);
        removeDuplicates(array2);


    }

    //2
    public static void reverseString(String word) {
        String news = "";
        System.out.println(reverseString(word, news));
    }

    public static String reverseString(String word, String fixed) {
       if(word.length()==0) {
        return fixed;
       } else {
        fixed+= word.charAt(word.length()-1);
        return reverseString(word.substring(0, word.length()-1), fixed);

       }
    }
// Write a generic recursive method removeDuplicates that removes duplicates from an ArrayList. The method returns a new ArrayList that contains the distinct elements from the original list.
    public static <E> void removeDuplicates(ArrayList<E> array) {
       ArrayList <E> newArray = new ArrayList<>();

       for(int i =0; i < array.size(); i++) {
         removeDuplicates(array, newArray, i);
       }
       for(int i =0; i < newArray.size(); i++) {
        System.out.println(newArray.get(i));
       }
    }

    public static <E> void removeDuplicates(ArrayList<E> array, ArrayList<E> newArray, int index) {
        if(index == array.size()) {
            return;
        } else {
            if(!newArray.contains(array.get(index))) {
                newArray.add(array.get(index));
            }
            removeDuplicates(array, newArray, index+1);
        }
    }

   

    
}