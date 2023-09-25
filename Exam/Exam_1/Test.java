import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[30];
        int count = readAnimals(animals, "animals.txt");
        if (count == 0) {
            System.out.println("No data read from the file animals.txt");
        } else {
            System.out.println("File animals.txt read successfully");
        }
        // cloning some animals
        animals[count++] = cloneAnimal(animals, count);
        animals[count++] = cloneAnimal(animals, count);
        animals[count++] = cloneAnimal(animals, count);
        animals[count++] = cloneAnimal(animals, count);

        // Display the list of animals
        System.out.println("List of Animals");
        System.out.printf("%-15s\t%-10s\t%-20s\t%10s\n", "Type", "Tag", "Name", "Weight");
        for (int i = 0; i < count; i++) {
            System.out.println(animals[i]);
        }

        // Display the animals that can fly
        System.out.println("\nList of Flying Animals");
        printFlying(animals, count);

        // Display the list of animals sorted by weight
        System.out.println("\nList of Animals sorted by weight");
        sortAnimals(animals, count);

        // Display the list of mammmals
        System.out.println("\nList of Mammals");
        printMammals(animals, count);

        // find an animal with a specific tag
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a tag:");
        String tag = keyboard.next();
        if (checkTag(tag)) {
            int index = findAnimal(animals, count, tag);
            if (index == -1) {
                System.out.println("No animal found with tag: " + tag);
            } else {
                System.out.println("Animal found: " + animals[index]);
            }
        }

    }
    public static int findAnimal(Animal[] list, int size, String tag) {
        for (int i = 0; i < size; i++) {
            if (list[i].getTag().equals(tag)) {
                return i;
            }
        }
        return -1;
    }
    public static boolean checkTag(String tag) {
        try {
            if (tag.matches("[A-Z]{2}-\\d{4}"));
            return true;
        } catch (Exception e) {
            System.out.println(" . Must have 2 letters followed by 4 digits");
        }
        return false;
    }
    public static int readAnimals(Animal[] list, String filename) {
        File file = new File(filename);
        int count = 0;
        try {
            String[] attributes = new String[6];
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                attributes = line.split("\\,");
                if (attributes[0].equals("Bat")) {
                    list[count] = new Bat(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]));
                }
                if (attributes[0].equals("Bear")) {
                    list[count] = new Bear(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]));
                }
                if (attributes[0].equals("Blue Jay")) {
                    list[count] = new BlueJay(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]));
                }
                if (attributes[0].equals("Humming Bird")) {
                    list[count] = new HummingBird(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]));
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return count;
    }

    public static void sortAnimals(Animal[] list, int size) {
        System.out.printf("%-15s\t%-10s\t%-20s\t%10s\n", "Type", "Tag", "Name", "Weight");
        java.util.Arrays.sort(list, 0, size);
        for (int i = 0; i < size; i++) {
            System.out.println(list[i]);
        }
    }
    public static void printMammals(Animal[] list, int size) {
        System.out.printf("%-15s\t%-10s\t%-20s\t%10s\t%-10s\n", "Type", "Tag", "Name", "Weight", "Gestation");
        for (int i = 0; i < size; i++) {
            if (list[i] instanceof Mammal) {
                System.out.println(list[i]);
            }
        }

    }
    public static void printFlying(Animal[] list, int size) {
        System.out.printf("%-15s\t%-20s\t%s\n", "Type", "Name", "Flying Speed (mph)");
        for (int i = 0; i < size; i++) {
            if (list[i] instanceof Bat) {
                Bat temp = (Bat)(list[i]);
                System.out.println(temp.flies());
            }
            if (list[i] instanceof BlueJay) {
                BlueJay temp = (BlueJay)(list[i]);
                System.out.println(temp.flies());
            }
            if (list[i] instanceof HummingBird) {
                HummingBird temp = (HummingBird)(list[i]);
                System.out.println(temp.flies());
            }
        }
    }

    public static Animal cloneAnimal(Animal[] list, int size) {
        int index = (int)(Math.random() * (size - 1));
        Animal a = null;
        if (list[index] instanceof BlueJay) {
            a = (BlueJay)(list[index].clone());
            ((BlueJay) a).setFlyingSpeed(((Bird) a).getFlyingSpeed() * 2);
        } else if (list[index] instanceof Bat) {
            a = (Bat)(list[index].clone());
            a.setName("Natalidae");
        } else if (list[index] instanceof Bear) {
            a = (Bear)(list[index].clone());
            ((Bear) a).setHibernation(6);
        } else {
            a = (Animal)(list[index].clone());
            a.setWeight(a.getWeight() + 2);
        }
        return a;
    }

}