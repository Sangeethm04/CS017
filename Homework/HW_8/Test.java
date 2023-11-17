import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * test class
 */
public class Test {
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        ArrayList < Student > al = new ArrayList < > ();
        LinkedList < Student > ll = new LinkedList < > ();
        readFile(al, ll, "students.txt");
        Scanner scan = new Scanner(System.in);
        int input;
        do {
            System.out.println("Select an operation:\n1: sort by id\n2: sort by name\n3: sort by gpa\n4: view performance\n5: quit");
            input = scan.nextInt();
            switch (input) {
                case 1:
                    System.out.println("ArrayList sorted by ID");
                    al.sort(null);
                    System.out.println(al);
                    System.out.println();
                    System.out.println("LinkedList sorted by ID");
                    ll.sort(null);
                    System.out.println(ll);
                    break;
                case 2:
                    System.out.println("ArrayList sorted by Name");
                    al.sort(new ComparatorByName());
                    System.out.println(al);
                    System.out.println();
                    System.out.println("LinkedList sorted by Name");
                    ll.sort(new ComparatorByName());
                    System.out.println(ll);
                    break;
                case 3:
                    System.out.println("ArrayList sorted by GPA");
                    al.sort(new ComparatorByGPA());
                    System.out.println(al);
                    System.out.println();

                    System.out.println("LinkedList sorted by GPA");
                    ll.sort(new ComparatorByGPA());
                    System.out.println(ll);
                    break;
                case 4:
                    System.out.println("Performance of the sort method (# iterations)");
                    System.out.println("List            by ID           by Name         by GPA");
                    System.out.print("ArrayList: ");
                    al.sort(null);
                    System.out.print(ArrayList.sortIterations + "\t");
                    al.sort(new ComparatorByName());
                    System.out.print(ArrayList.sortIterations + "\t");
                    al.sort(new ComparatorByGPA());
                    System.out.println(ArrayList.sortIterations + "\t");
                    System.out.print("LinkedList: ");
                    ll.sort(null);
                    System.out.print(LinkedList.sortIterations + "\t");
                    ll.sort(new ComparatorByName());
                    System.out.print(LinkedList.sortIterations + "\t");
                    ll.sort(new ComparatorByGPA());
                    System.out.print(LinkedList.sortIterations + "\t");
                    System.out.println();
                    break;
                case 5:
                    break;
            }
        } while (input != 5);

    }

    /**
     * file that reads data from file
     * @param al
     * @param ll
     * @param filename
     */
    public static void readFile(ArrayList < Student > al, LinkedList < Student > ll, String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double gpa = Double.parseDouble(tokens[2]);
                Student s = new Student(id, name, gpa);
                al.add(s);
                ll.add(s);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }





}