import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        ArrayList < Student > students = new ArrayList < > ();
        readFile("students.txt", students);
        students.sort(null);
        for(Student studentss: students) {
            System.out.println(studentss.getGPA());
            System.exit(0);
        }

    }

    public static void readFile(String file, ArrayList < Student > students) {
        try {
            Scanner scan = new Scanner(new File(file));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split("\\ ");
                
                students.add(new Student(tokens[0], Double.parseDouble(tokens[1])));
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
    }
}