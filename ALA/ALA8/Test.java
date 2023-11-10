import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Test {
    public static void main(String[] args) {
        PriorityQueue < Patient > emergencyRoom = new PriorityQueue < > ();
        readPatients(emergencyRoom, "patients.txt");
        int counter = 0, total = 0;
        System.out.println("\n\nPerfomance of poll()");
        while (!emergencyRoom.isEmpty()) {
            Patient p = emergencyRoom.poll();
            total += MinHeap.addIterations;
            if (counter % 25 == 0) {
                System.out.println(p + "\t" + MinHeap.removeIterations);
            }
            counter++;
        }
        System.out.println("Average: " + "\t\t" + total / counter);
    }

    public static void readPatients(PriorityQueue < Patient > pq, String filename) {
        try {
            Scanner read = new Scanner(new File(filename));
            int counter = 0, total = 0;
            System.out.println("\nPerfomance of poll(E)");
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] tokens = line.split(",");
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                int type = Integer.parseInt(tokens[2]);
                Patient p = new Patient(name, age, type);
                pq.offer(p);
                total += MinHeap.addIterations;
                if (counter % 25 == 0) {
                    System.out.println(p + "\t" + MinHeap.addIterations);
                }
                counter++;
            }
            System.out.println("Average: " + "\t\t" + total / counter);
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}