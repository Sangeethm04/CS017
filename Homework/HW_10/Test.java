import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        readFile("ratings.csv");
    }

    public static void readFile(String file) {
        try {
            Scanner files = new Scanner(new File(file));

            while (files.hasNextLine()) {
                String line = files.nextLine();
                String[] tokens = line.split("\\,");
                System.out.println(tokens[0] + " " + tokens[1] + " " + tokens[2]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}