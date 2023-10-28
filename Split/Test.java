import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String[] emails = new String[1600];
        File file = new File("emails.txt");
        try {

            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String nextLine = read.nextLine();
                emails = nextLine.split("\\,");

            }
            read.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        for (int i = 0; i < emails.length; i++) {
            System.out.println(emails[i]);
        }
    }
}