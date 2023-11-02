import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class AnimalList {
    public static void main(String[] args) {
        ArrayList < String > animalAL = new ArrayList < > ();
        LinkedList < String > animalLL = new LinkedList();

        readAnimals(animalAL, animalLL, "animals.txt");
        testContains(animalAL, animalLL);
        testAdd(animalAL, animalLL);
                testRemove(animalAL, animalLL);

    }

    public static void readAnimals(ArrayList < String > al, LinkedList < String > ll, String filename) {
        try {
            Scanner read = new Scanner(new File(filename));
            while (read.hasNextLine()) {
                String animal = read.nextLine();
                al.add(animal);
                ll.add(animal);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void testContains(ArrayList<String> al, LinkedList<String> ll) {
        int totalAL = 0, totalLL = 0;
         System.out.println("");
         System.out.printf("%-30s\t%-15s\t%-15s\n", 
        "Animal Name", "Iterations(AL)", "Iterations(LL)");
        for(int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random() * (al.size()));
            System.out.println(randomIndex + " " + al.size());

            String randomAnimal = al.get(randomIndex);
            al.contains(randomAnimal);
            ll.contains(randomAnimal);
            System.out.printf("%-30s\t%-15d\t%-15d\n", 
            randomAnimal, ArrayList.containsIterations, LinkedList.containsIterations);
            totalAL += ArrayList.containsIterations;
            totalLL += LinkedList.containsIterations;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", 
        "Average", totalAL/20, totalLL/20);
    }

     public static void testAdd(ArrayList<String> al, LinkedList<String> ll) {
        int totalAL = 0, totalLL = 0;
         System.out.println("");
         System.out.printf("%-30s\t%-15s\t%-15s\n", 
        "Animal Name", "Iterations(AL)", "Iterations(LL)");
        for(int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random()) * al.size();
            String randomAnimal = al.get(randomIndex);
            al.add(randomIndex, randomAnimal);
            ll.add(randomIndex, randomAnimal);
            System.out.printf("%-30s\t%-15d\t%-15d\n", 
            randomAnimal, ArrayList.containsIterations, LinkedList.containsIterations);
            totalAL += ArrayList.addIterations;
            totalLL += LinkedList.addIterations;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", 
        "Average", totalAL/20, totalLL/20);
    }

    public static void testRemove(ArrayList<String> al, LinkedList<String> ll) {
        int totalAL = 0, totalLL = 0;
         System.out.println("\n Comparing the mothods remove(oBject)");
         System.out.printf("%-30s\t%-15s\t%-15s\n", 
        "Animal Name", "Iterations(AL)", "Iterations(LL)");
        for(int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random()) * al.size();
            String randomAnimal = al.get(randomIndex);
            al.remove(randomAnimal);
            ll.remove(randomAnimal);
            System.out.printf("%-30s\t%-15d\t%-15d\n", 
            randomAnimal, ArrayList.removeIterations, LinkedList.removeIterations);
            totalAL += ArrayList.removeIterations;
            totalLL += LinkedList.removeIterations;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", 
        "Average", totalAL/20, totalLL/20);
    }

}