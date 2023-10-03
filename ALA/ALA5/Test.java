import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String type = args[0];
        int operation = 0;
        Scanner keyBoard = new Scanner(System.in);
        if (type.equals("states")) {
            ArrayList < Pair < String, String >> states = new ArrayList < > ();
            readStates(states, "states.txt");
            do {
                printMenu();
                operation = Integer.parseInt(keyBoard.nextLine());
                switch (operation) {
                    case 1: //view
                        print(states);
                        break;
                    case 2: //search
                        System.out.println("Enter a state");
                        String state = keyBoard.nextLine();
                        int index = search(states, state);
                        if (index == -1) {
                            System.out.println("State not found");
                        } else {
                            System.out.println("State found: " + states.get(index));
                        }
                        break;
                    case 3: // sort by name
                        states.sort(new ComparatorByFirst());
                        print(states);
                        break;
                    case 4: //
                        states.sort(new ComparatorBySecond());
                        print(states);
                        break;
                    case 5:
                        break;
                }
            } while(operation != 5);
            } else if (type.equals("trees")) {
                ArrayList < Pair < String, Integer >> trees = new ArrayList < > ();
                readTrees(trees, "trees.txt");
            } else {
                System.out.println("Invalid type (states or trees only)");
            }



        }
        public static void printMenu() {
            System.out.println("Select an operation.");
            System.out.println("1: view the states");
            System.out.println("2: search for a state");
            System.out.println("3: sort by name");
            System.out.println("4: sort by capital");
            System.out.println("5: exit");
        }

        public static void readStates(ArrayList < Pair < String, String >> list, String filename) {
            try {
                Scanner read = new Scanner(new File(filename));
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String[] tokens = line.split("\\|");
                    String name = tokens[0];
                    String capital = tokens[1];
                    Pair < String, String > state = new Pair < > (name, capital);
                    list.add(state);
                }
                read.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }

        public static void readTrees(ArrayList < Pair < String, Integer >> trees, String filename) {
            try {
                Scanner read = new Scanner(new File(filename));
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String[] tokens = line.split("\\|");
                    String name = tokens[0];
                    Integer height = Integer.parseInt(tokens[1]);
                    Pair < String, Integer > tree = new Pair < > (name, height);
                    trees.add(tree);
                }
                read.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
        public static < E1, E2 > int search(ArrayList < Pair < E1, E2 >> list, E1 key) {
            for (int i = 0; i < list.size(); i++) {
                Pair < E1, E2 > pair = list.get(i); // get the pair at index i
                if (pair.getFirst().equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        public static < E > void print(ArrayList < E > list) {
            for (E element: list) {
                System.out.println(element); //toString called by deafult
            }
        }
    }