import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

/**
 * class animaltree
 */
public class AnimalTree {
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        BST < String > animalBST = new BST < > ();
        ArrayList < String > animalAL = new ArrayList < > ();

        readFile(animalBST, "animals.txt", animalAL);
        testContains(animalBST, animalAL);
        testRemove(animalBST, animalAL);
        System.out.println("");
        System.out.println("BST properties (random data)");
        System.out.println("BST Height: " + animalBST.height());
        System.out.println("BST is balanced? " + animalBST.isBalanced());
        animalBST.clear();
        animalAL.sort(null);
        for (String animal: animalAL) {
            animalBST.add(animal);
        }
        System.out.println("");
        System.out.println("BST properties (sorted data)");
        System.out.println("BST Height: " + animalBST.height());
        System.out.println("BST is balanced? " + animalBST.isBalanced());
    }

    /**
     * testContains method
     * @param bst 
     * @param al
     */
    public static void testContains(BST < String > bst, ArrayList < String > al) {
        int total = 0;
        System.out.println("\nTesting the BST contains method");
        System.out.printf("%-25s\t%-10s\n", "Animal name", "Iterations");
        for (int i = 0; i < 20; i++) {
            int index = (int)(Math.random() * al.size());
            String animal = al.get(index);
            bst.contains(animal);
            System.out.printf("%-25s\t%-10d\n", animal, BST.containsIterations);
            total += BST.containsIterations;
        }
        System.out.printf("%-25s\t%-10d\n", "Average", total / 20);

    }

    /**
     * testRemove method
     * @param bst
     * @param al
     */
    public static void testRemove(BST < String > bst, ArrayList < String > al) {
        int total = 0;
        System.out.println("\nTesting the BST remove method");
        System.out.printf("%-25s\t%-10s\n", "Animal name", "Iterations");
        for (int i = 0; i < 20; i++) {
            int index = (int)(Math.random() * al.size());
            String animal = al.get(index);
            bst.remove(animal);
            System.out.printf("%-25s\t%-10d\n", animal, BST.removeIterations);
            total += BST.removeIterations;
        }
        System.out.printf("%-25s\t%-10d\n", "Average", total / 20);

    }

    /**
     * readFile method
     * @param bst
     * @param filename
     * @param al
     */
    public static void readFile(BST < String > bst, String filename, ArrayList < String > al) {
        try {
            Scanner read = new Scanner(new File(filename));
            int counter = 0, total = 0;
            System.out.println("Testing the BST add method");
            System.out.printf("%-25s\t%-10s\n", "Animal name", "Iterations");

            while (read.hasNextLine()) {
                String animal = read.nextLine();
                bst.add(animal);
                total += BST.addIterations;
                al.add(animal);
                if (counter % 25 == 0) {
                    System.out.printf("%-25s\t%-10d\n", animal, BST.addIterations);
                }
                counter++;
            }
            System.out.printf("%-25s\t%-10d\n", "Average", total / counter);
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("not found");
        }
    }
}