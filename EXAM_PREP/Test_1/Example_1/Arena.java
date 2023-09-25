package Example_1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Arena {
    public static void main(String[] args) {
        Robot[] robots = new Robot[20];
        int trackLength = 1000;
        int count = readRobots(robots, "robots.txt");
        if (count > 0) {
            // Creating 5 clone robots and changing their names
            for (int i = 0; i < 5; i++) {
                String name = "Robot" + (10 + i + 1);
                int rIndex = (int)(Math.random() * count);
                robots[count] = (Robot)(robots[rIndex].clone());
                robots[count].setName(name);
                count++;
            }
            System.out.println("Robot race started ...");
            // Loop to implement the robot race

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < count; j++) {
                    try {
                        robots[j].move(trackLength);
                    } catch (OutOfRangeException e) {
                        System.out.println(robots[j].getName() + "\t\t" + robots[j].getPosition() + e);
                    }
                }
            }
            // Displaying the final position of the robots
            System.out.println("Robot race ended.\n");
            System.out.println("Robot positions at the end of the race");
            print(robots, count);
            // Sorting the robots by position
            java.util.Arrays.sort(robots, 0, count);
            System.out.println("\nRobot ranking at the end of the race");
            print(robots, count);
            // Finding the robot with the max position, but not out of range 
            int winner = 0;
            for (int i = 0; i < count; i++) {
                if (robots[i].getPosition() > robots[winner].getPosition() &&
                    robots[i].getPosition() <= trackLength) {
                    winner = i;
                }
            }
            System.out.println("The race winner: " + robots[winner]);
        } else {
            System.out.println("There are no robots in the race.");
        }
    }
    public static int readRobots(Robot[] list, String filename) {
        File fileReader = new File(filename);
        int counts = 0;
        try {
            Scanner input = new Scanner(fileReader);
            while (input.hasNext()) {
                String type = input.next();
                String name = input.next();
                int position = input.nextInt();
                if (type.equals("Turbo")) {
                    list[counts] = new TurboRobot(name, position);
                } else if (type.equals("Fast")) {
                    list[counts] = new FastRobot(name, position);
                } else if (type.equals("Sonic")) {
                    list[counts] = new SonicRobot(name, position);
                }
                counts++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return counts;
    }
    public static void print(Robot[] list, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(list[i]);
        }
    }
}