import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Test {
    public static void main(String[] args) {
        ArrayList < Student > al = new ArrayList < > ();
        LinkedList < Student > ll = new LinkedList < > ();
        readFile(al, ll, "students.txt");
        // System.out.println("By name ll sort:");
        // ll.sort(new ComparatorByName());
        // System.out.println("By gpa ll sort:");
        // ll.sort(new ComparatorByGPA());
        // System.out.println("By name al sort:");
        al.sort(new ComparatorByName());
        System.out.println("By gpa al sort:");
        al.sort(new ComparatorByGPA());
        System.out.println(al);
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