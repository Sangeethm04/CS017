import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TestHashMap{
    public static void main(String[] args){
        HashMap<String, String> states = new HashMap<>();
        readStates(states, "states.txt");
        System.out.println(states);

    }
    
    public static void readStates(HashMap<String,String> hm, String filename){
        try{
            Scanner read = new Scanner(new File(filename));
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] tokens = line.split("\\|");
                String state = tokens[0];
                String capital = tokens[1];
                hm.put(state, capital);
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}