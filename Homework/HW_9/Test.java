import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Test class
 * There are more duplicates in the comparator classes than the natural ordering because of the way they're inserted into the bst. The set does not allow duplicates and therefore using the natural ordering of city names will have more duplicates than numbers or lat or long which explains why there are far more cities in the comparator sorts than the natural ordering version.
 */
public class Test{
    /**
     * main method
     * @param args command line arguments
     */
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int selection = 0;
        TreeSet<City> cityTree;
        do{
            System.out.println("\nSelect an operation:");
            System.out.println("1: USA Cities by name");
            System.out.println("2: USA Cities by latitude");
            System.out.println("3: USA Cities by longitude");
            System.out.println("4: Exit");
            selection = keyboard.nextInt();
            switch(selection){
                case 1: // natural oredering
                    cityTree = new TreeSet<>();
                    readCities(cityTree, "cities.txt");
                    System.out.println("\nNumber of cities in the set: " + cityTree.size());
                    System.out.println("Is \"Philadelphia\" in the set? " + cityTree.contains(new City("Philadelphia", null, 0.0, 0.0)));
                    System.out.println("Is \"Paris\" in the set? " + cityTree.contains(new City("Paris", null, 0.0, 0.0)));
                    cityTree.inorder();
                    break;
                case 2: // ordering by latitude
                    cityTree = new TreeSet<>(new ComparatorByLatitude());
                    readCities(cityTree, "cities.txt");
                    System.out.println("\nNumber of cities in the set: " + cityTree.size());
                
                    cityTree.inorder();
                    System.out.println("\nCity with the lowest latitude:\n" + cityTree.first());
                    System.out.println("City with the highest latitude:\n" + cityTree.last());
                    break;
                case 3: // ordering by longitude
                    cityTree = new TreeSet<>(new ComparatorByLongitude());
                    readCities(cityTree, "cities.txt");
                    System.out.println("\nNumber of cities in the set: " + cityTree.size());
                    cityTree.inorder();
                    System.out.println("\nCity with the lowest longitude:\n" + cityTree.first());
                    System.out.println("City with the highest longitude:\n" + cityTree.last());
                    break;
                
            }
        } while(selection != 4);
    }

    /**
     * readCities method to read cities from file
     * @param tree to add to
     * @param filename to read from
     */
    public static void readCities(TreeSet<City> tree, String filename){
        try{
            Scanner read = new Scanner(new File(filename));
            while(read.hasNextLine()){
                String line = read.nextLine();
                //System.out.println(line);
                String[] tokens = line.split(",");
                City c = new City(tokens[0],
                                  tokens[1],
                                  Double.parseDouble(tokens[2]),
                                  Double.parseDouble(tokens[3]));
                tree.add(c);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}