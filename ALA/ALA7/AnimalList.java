import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
/**
 * Class to test the ArrayList and LinkedList
 */
public class AnimalList {
    /**
     * main method to test arraylist and ll
     * @param args
     */
    public static void main(String[] args) {
        ArrayList < String > animalAL = new ArrayList < > ();
        LinkedList < String > animalLL = new LinkedList();

        readAnimals(animalAL, animalLL, "animals.txt");
        testContains(animalAL, animalLL);
        testAdd(animalAL, animalLL);
        testRemove(animalAL, animalLL);

    }

    /**
     * method to read animals from file
     * @param al
     * @param ll
     * @param filename
     */
    public static void readAnimals(ArrayList < String > al, LinkedList < String > ll, String filename) {
        try {
            Scanner read = new Scanner(new File(filename));
            while (read.hasNextLine()) {
                String animal = read.nextLine();
                al.add(animal);
                ll.add(animal);
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * method to test contains
     * @param al
     * @param ll
     */
    public static void testContains(ArrayList < String > al, LinkedList < String > ll) {
        int totalAL = 0, totalLL = 0;
        System.out.println("\nComparing the methods contains(object)");
        System.out.printf("%-30s\t%-15s\t%-15s\n",
            "Animal Name", "Iterations(AL)", "Iterations(LL)");
        for (int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random() * al.size());
            String randomAnimal = al.get(randomIndex);
            al.contains(randomAnimal);
            ll.contains(randomAnimal);
            System.out.printf("%-30s\t%-15d\t%-15d\n",
                randomAnimal, ArrayList.containsIterations, LinkedList.containsIterations);
            totalAL += ArrayList.containsIterations;
            totalLL += LinkedList.containsIterations;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n",
            "Average", totalAL / 20, totalLL / 20);
    }

    /**
     * method to test add
     * @param al the arraylist
     * @param ll the linkedlist
     */
    public static void testAdd(ArrayList < String > al, LinkedList < String > ll) {
        int totalAL = 0, totalLL = 0;
        System.out.println("\nComparing the methods add(int, E)");
        System.out.printf("%-30s\t%-15s\t%-15s\n",
            "Animal Name", "Iterations(AL)", "Iterations(LL)");
        for (int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random() * al.size());
            String randomAnimal = al.get(randomIndex);
            al.add(randomIndex, randomAnimal);
            ll.add(randomIndex, randomAnimal);
            System.out.printf("%-30s\t%-15d\t%-15d\n",
                randomAnimal, ArrayList.addIterations, LinkedList.addIterations);
            totalAL += ArrayList.addIterations;
            totalLL += LinkedList.addIterations;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n",
            "Average", totalAL / 20, totalLL / 20);
    }

    /**
     * method to test remove
     * @param al the arraylist
     * @param ll the linkedlist
     */
    public static void testRemove(ArrayList < String > al, LinkedList < String > ll) {
        int totalAL = 0, totalLL = 0;
        System.out.println("\nComparing the mothods remove(oBject)");
        System.out.printf("%-30s\t%-15s\t%-15s\n",
            "Animal Name", "Iterations(AL)", "Iterations(LL)");
        for (int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random() * al.size());
            String randomAnimal = al.get(randomIndex);
            al.remove(randomAnimal);
            ll.remove(randomAnimal);
            System.out.printf("%-30s\t%-15d\t%-15d\n",
                randomAnimal, ArrayList.removeIterations, LinkedList.removeIterations);
            totalAL += ArrayList.removeIterations;
            totalLL += LinkedList.removeIterations;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n",
            "Average", totalAL / 20, totalLL / 20);
    }

}