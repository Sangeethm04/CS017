import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class that implements the hashtable with linear probing
 */
public class Test {
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        HashMapLP < Integer, Movie > map = new HashMapLP < > (63000);
        readFile("movies.csv", map);
        readFile2("ratings.csv", map);


        int[] ids = {
            1544,
            2156,
            31349,
            3048,
            4001,
            356,
            5672,
            6287,
            25738,
            26
        };
        for (int id: ids) {
            System.out.println("Movie id: " + id + " " + map.get(id));
        }

        ArrayList < HashMapEntry < Integer, Movie >> list = map.toList();
        ArrayList < Movie > movies = new ArrayList < > ();
        for (HashMapEntry < Integer, Movie > entry: list) {
            movies.add(entry.getValue());
        }


        movies.sort(null);

        System.out.println();
        System.out.println("Bottom Ten movies with at least 10,000 ratings");
        int count = 0;
        for (int i = 0; i <= movies.size(); i++) {
            if (movies.get(i).getRatings() >= 10000) {
                System.out.println(movies.get(i));
                count++;
            }
            if (count == 10) {
                break;
            }
        }
        System.out.println();
        System.out.println("Top Ten movies with at least 10,000 ratings");
        count = 0;
        for (int i = movies.size() - 1; i >=0 ; i--) {
            if (movies.get(i).getRatings() >= 10000) {
                System.out.println(movies.get(i));
                count++;
            }
            if (count == 10) {
                break;
            }
        }
        System.out.println();
        map.printClusters();

    }

    /**
     * Method to read the file and store the data in the hashtable
     * @param file file to be read
     * @param map hashtable to store the data
     */
    public static void readFile(String file, HashMapLP < Integer, Movie > map) {
        try {
            Scanner files = new Scanner(new File(file));

            while (files.hasNextLine()) {
                String line = files.nextLine();
                String[] tokens = line.split("\\,");

                int id = Integer.parseInt(tokens[0]);
                String title = tokens[1];
                String genre = tokens[2];
                map.put(id, new Movie(id, title, genre));

            }
            files.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * Method to read the file and store the data in the hashtable
     * @param file file to read from
     * @param map hashtable to store the data
     */
    public static void readFile2(String file, HashMapLP < Integer, Movie > map) {
        try {
            Scanner files = new Scanner(new File(file));

            while (files.hasNextLine()) {
                String line = files.nextLine();
                String[] tokens = line.split("\\,");

                int id = Integer.parseInt(tokens[1]);
                double rating = Double.parseDouble(tokens[2]);
                Movie movie = map.get(id);
                movie.addRating(rating);

            }
            files.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }


}