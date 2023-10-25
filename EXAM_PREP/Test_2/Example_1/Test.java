import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
        ArrayList<Tuple<Integer, String, String, Double>> elements = new ArrayList<>();
        readElements(elements, "elements.txt");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the symbol of an element: ");
        String symbol = keyboard.next();
        int index = search(elements, symbol);
        if(index == -1){
            System.out.println("Element with symbol " + symbol + " not found.");
        }
        else{
            System.out.println("Element found: " + elements.get(index));
        }
        System.out.print("\nSelect the sort criterion (number/symbol): ");
        String type = keyboard.next();
        switch(type){
            case "number":
                // Uncomment the line below when you define ComparatorByFirst
                //elements.sort(new ComparatorByFirst());
                printList(elements);
                break;
            case "symbol":
                // Uncomment the line below when you define ComparatorByThird
                //elements.sort(new ComparatorByThird());
                printList(elements);
                break;
            default:
                System.out.println("Invalid criterion. Should be number or symbol");
        }
        index = findMax(elements);
        System.out.println("\nThe element with the largest atomic mass: " + elements.get(index));
    }

    public static void readElements(ArrayList<Tuple<Integer, String, String, Double>> list, 
                                    String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNext()){
                int number = read.nextInt();
                String name = read.next();
                String symbol = read.next();
                double mass = read.nextDouble();
                Tuple<Integer, String, String, Double> tuple = new Tuple<>(number, name, symbol, mass);
                list.add(tuple);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            System.exit(0);
        }
    }
    // Define search here
    public static <E1, E2, E3, E4> int search(ArrayList<Tuple<E1, E2, E3, E4>> list, E3 key){
        return -1;
    }
   
    // Define findMax here
    public static <E1, E2, E3, E4> int findMax(ArrayList<Tuple<E1, E2, E3, E4>> list){
        return 0;
    }
    public static <E1, E2, E3, E4> void printList(ArrayList<Tuple<E1, E2, E3, E4>> list){
        for(Tuple<E1, E2, E3, E4> t: list){
            System.out.println(t);
        }
    }
}