import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String[] emails = new String[1600];
        File file = new File("emails.txt");
       
        try {
            try (PrintWriter prints = new PrintWriter("meo.txt")) {
                Scanner read = new Scanner(file);
                    String nextLine = read.nextLine();
                    emails = nextLine.split("\\,");

                for (int i = 0; i < emails.length; i++) {
                //print to print writer
                prints.println(emails[i]);
      }
                read.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        
    }
}