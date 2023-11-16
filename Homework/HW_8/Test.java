import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Test {
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
                    System.out.println(LinkedList.sortIterations);
                    System.out.println(ArrayList.sortIterations);
                    break;
                case 5:
                    break;
            }
        } while (input != 5);

    }

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