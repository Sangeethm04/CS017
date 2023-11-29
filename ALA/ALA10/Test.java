import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //read the data to shuffle it and remove duplicates
        HashMap < String, String > hashWords = new HashMap < > (50000);
        readWords(hashWords, "dictionary.txt"); //remove duplicates and shuffle the order
        System.out.println(hashWords.size());
        ArrayList < HashMapEntry < String, String >> words = hashWords.toList();
        LinkedList < String > llWords = new LinkedList < > ();
        BST < String > bstWords = new BST < > ();
        hashWords.clear();
        testAdd(words, llWords, bstWords, hashWords);
        System.out.println();
        testContains(words, llWords, bstWords, hashWords);
        System.out.println();
        testRemove(words, llWords, bstWords, hashWords);

        System.out.println("\nThe maximum number of collisions: " + hashWords.collisions());


    }

    public static void readWords(HashMap < String, String > hm, String filename) {
        try {
            Scanner read = new Scanner(new File(filename));
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] tokens = line.split("\\|");
                hm.put(tokens[0], tokens[1]); // pair (word, definition)
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void testAdd(ArrayList < HashMapEntry < String, String >> al,
        LinkedList < String > ll, BST < String > bst, HashMap < String, String > hm) {
        int counter = 0, totalLL = 0, totalBST = 0, totalHM = 0;
        int frequency = al.size() / 20;
        System.out.println("Testing the add method");
        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Word", "LL add", "BST add", "HashMap put");

        for (HashMapEntry < String, String > entry: al) {
            String word = entry.getKey();
            ll.add(word);
            bst.add(word);
            hm.put(word, entry.getValue());
            totalLL += LinkedList.addIterations;
            totalBST += BST.addIterations;
            totalHM += HashMap.putIterations;
            if (counter % frequency == 0) {
                System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", word, LinkedList.addIterations, BST.addIterations, HashMap.putIterations);
            }
            counter++;
        }
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Average", totalLL / al.size(), totalBST / al.size(), totalHM / al.size());

    }
    public static void testContains(ArrayList < HashMapEntry < String, String >> al,
        LinkedList < String > ll, BST < String > bst, HashMap < String, String > hm) {
        int totalLL = 0, totalBST = 0, totalHM = 0;
        System.out.println("Testing the search method");
        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Word", "LL contains", "BST contains", "HashMap get");

        for (int i = 0; i < 1000; i++) {
            int index = (int)(Math.random() * al.size());
            String word = al.get(index).getKey();
            ll.contains(word);
            bst.contains(word);
            hm.get(word);
            totalLL += LinkedList.containsIterations;
            totalBST += BST.containsIterations;
            totalHM += HashMap.getIterations;
            if (i % 50 == 0) {
                System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", word, LinkedList.containsIterations, BST.containsIterations, HashMap.getIterations);
            }
        }
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Average", totalLL / 1000, totalBST / 1000, totalHM / 1000);

    }

    public static void testRemove(ArrayList < HashMapEntry < String, String >> al,
        LinkedList < String > ll, BST < String > bst, HashMap < String, String > hm) {
        int totalLL = 0, totalBST = 0, totalHM = 0;
        System.out.println("Testing the remove method");
        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Word", "LL remove", "BST remove", "HashMap remove");

        for (int i = 0; i < 1000; i++) {
            int index = (int)(Math.random() * al.size());
            String word = al.get(index).getKey();
            ll.remove(word);
            bst.remove(word);
            hm.remove(word);
            totalLL += LinkedList.removeIterations;
            totalBST += BST.removeIterations;
            totalHM += HashMap.removeIterations;
            if (i % 50 == 0) {
                System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", word, LinkedList.removeIterations, BST.removeIterations, HashMap.removeIterations);
            }
        }
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Average", totalLL / 1000, totalBST / 1000, totalHM / 1000);

    }
}