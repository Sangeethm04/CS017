import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
        ArrayList<Country> countries = new ArrayList<>();
        readFile(countries, "countries.txt");
        System.out.println("Data read from the file: " + countries.size() + " countries");

        Country c = new Country("United States of America");
        ListIterator<Country> listIter = findCountry(countries, c);
        if(listIter == null){
            System.out.println(c.getName() + " not found.");
        }
        else{
            System.out.println(c.getName() + " found.");
        }

        //next country to USA
        if(listIter.hasNext()){
            System.out.println("Next country: " + listIter.next().getName());
        }
        //previous country to USA
        Country c1 = listIter.previous();
        c1 = listIter.previous();
        if(listIter.hasPrevious()){
            System.out.println("Previous country: " + listIter.previous().getName());
        }
        // Go forward to USA
        c = listIter.next();
        c = listIter.next();

        int year = 2015;
        // Get carbon emission in 2015
        ListIterator<Pair<Integer,Double>> emissionIter = c.getEmission(year);
        if(emissionIter == null){
            System.out.println("No carbon emission found for the year " + year);
        }
        else{
            System.out.println("Carbon emission of " + c.getName() + " in " +
                               year + " = " + emissionIter.next().getSecond() + " tons");
        }

        // Get carbom emission for the 3 previous years
        emissionIter.previous();
        int index = 0;
        System.out.println("\nCarbon emission of " + c.getName() + " for the previous three years:");
        while(index < 3 && emissionIter.hasPrevious()){
            Pair<Integer,Double> pair = emissionIter.previous();
            System.out.println("\t" + pair.getFirst() + " = " + pair.getSecond() + " tons");
            index++;
        }
        // get Carbon emission per capita in 2015
        ListIterator<Pair<Integer,Double>> capitaIter = c.getEmissionPerCapita(year);
        if(capitaIter == null){
            System.out.println("\nNo carbon emission per capita found for the year " + year);
        }
        else{
            System.out.println("\nCarbon emission per capita of " + c.getName() + " in " +
                               year + " = " + capitaIter.next().getSecond() + " tons per capita");
        }
         System.out.println("\nCarbon emission per capita of " + c.getName() + " for the next three years:");

        // Get carbon emission per capita for the next 3 years
        index = 0;
        while(index < 3 && capitaIter.hasNext()){
            Pair<Integer,Double> pair = capitaIter.next();
            System.out.println("\t" + pair.getFirst() + " = " + pair.getSecond() + " tons per capita");
            index++;
        }

        // Determine the countries with extreme carbon emissions in 2015 and 2019
        c = extremeEmission(countries, 2015, true, true);
        System.out.println("\nHighest Carbon Emission in 2015: " + c.getName() + " " +
                           c.getEmission(2015).next().getSecond() + " tons");

        c = extremeEmission(countries, 2015, false, true);
        System.out.println("Lowest Carbon Emission in 2015: " + c.getName() + " " +
                           c.getEmission(2015).next().getSecond() + " tons");

        c = extremeEmission(countries, 2019, true, true);
        System.out.println("\nHighest Carbon Emission in 2019: " + c.getName() + " " +
                           c.getEmission(2019).next().getSecond() + " tons");

        c = extremeEmission(countries, 2019, false, true);
        System.out.println("Lowest Carbon Emission in 2019: " + c.getName() + " " +
                           c.getEmission(2019).next().getSecond() + " tons");

        // Determine the countries with extreme carbon emissions per capita in 2015 and 2019
        c = extremeEmission(countries, 2015, true, false);
        System.out.println("\nHighest Carbon Emission (per capita) in 2015: " + c.getName() + " " +
                           c.getEmissionPerCapita(2015).next().getSecond() + " tons");

        c = extremeEmission(countries, 2015, false, false);
        System.out.println("Lowest Carbon Emission (per capita) in 2015: " + c.getName() + " " +
                           c.getEmissionPerCapita(2015).next().getSecond() + " tons");

        c = extremeEmission(countries, 2019, true, false);
        System.out.println("\nHighest Carbon Emission (per capita) in 2019: " + c.getName() + " " +
                           c.getEmissionPerCapita(2019).next().getSecond() + " tons");

        c = extremeEmission(countries, 2019, false, false);
        System.out.println("Lowest Carbon Emission (per capita) in 2019: " + c.getName() + " " +
                           c.getEmissionPerCapita(2019).next().getSecond() + " tons");

        // sort the list of countries by total emissions(compareTo in class Country)
        countries.sort(null);
        // print the top ten countries with the lowest carbon emission from 2005 to 2019
        printTenTopLowestEmissions(countries);
        // print the top ten countries with the highest carbon emission from 2005 to 2019
        printTenTopHighestEmissions(countries);


    }
    /**
        Read the carbon emission data from filename
        @param list where data will be stored
        @param filename where data will be read from
     */
    public static void readFile(ArrayList<Country> list, String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            String line = read.nextLine();
            String[] tokens = line.split(",");
            String country = tokens[0];
            int year = Integer.parseInt(tokens[1]);
            double tons = Double.parseDouble(tokens[2]);
            Country c = new Country(country);
            while(read.hasNextLine()){
                c.addEmission(year, tons);
                line = read.nextLine();
                tokens = line.split(",");
                String country_new = tokens[0];
                int year_new = Integer.parseInt(tokens[1]);;
                tons = Double.parseDouble(tokens[2]);
                int index = 1;
                while(country.equals(country_new) && year!=year_new && read.hasNextLine()){
                    c.addEmission(year_new, tons);
                    index++;
                    line = read.nextLine();
                    tokens = line.split(",");
                    country_new = tokens[0];
                    year_new = Integer.parseInt(tokens[1]);;
                    tons = Double.parseDouble(tokens[2]);
                }
                if(year == year_new){
                    for(int i=0; i<index; i++){
                        c.addEmissionPerCapita(year_new, tons);
                        if(i<index-1){
                            line = read.nextLine();
                            tokens = line.split(",");
                            country_new = tokens[0];
                            year_new = Integer.parseInt(tokens[1]);;
                            tons = Double.parseDouble(tokens[2]);
                        }
                    }
                }
                if(read.hasNextLine()){
                    list.add(c);
                    line = read.nextLine();
                    tokens = line.split(",");
                    country_new = tokens[0];
                    year_new = Integer.parseInt(tokens[1]);;
                    tons = Double.parseDouble(tokens[2]);
                    c = new Country(country_new);
                    year = year_new;
                    country = country_new;
                }
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            System.exit(0);
        }
    }
    /**
     * search method in the list of countries
     * @param list of countries
     * @param c the country the method is searching for
     * @return a ListIterator object pointing to the country found in list, null if c is not found
     */
    
    public static ListIterator<Country> findCountry(ArrayList<Country> list, Country c){
        ListIterator<Country> listIter = list.listIterator();
        while(listIter.hasNext()){
            if(listIter.next().getName().equals(c.getName())){
                return listIter;
            }
        }
        return null;
    }
    /**
        Find the country with extreme carbon emission
        @param list the array list of countries
        @param year the year at which the extreme values are extracted
        @param minMax true for finding the highest emission, false for the lowest emission
        @param type true for carbon emissions in tons, false for carbo emission in tons per capita
        @return the country with the extreme emission at the given year
     */
    //returns the country with the highest (minMax = true) or the lowest (minMax = false) carbon emissions in tons (type = true) or carbon emission per capita 
    public static Country extremeEmission(ArrayList<Country> list, int year, boolean minMax, boolean type){
        Country a = list.get(0);
        if(minMax) {
            if(type) {
                for(int i = 0; i<list.size(); i++) {
                    if(list.get(i).getEmission(year).next().getSecond() > a.getEmission(year).next().getSecond()) {
                        a = list.get(i);
                    }
                }
            } else {
                for(int i = 0; i<list.size(); i++) {
                    if(list.get(i).getEmissionPerCapita(year).next().getSecond() > a.getEmissionPerCapita(year).next().getSecond()) {
                        a = list.get(i);
                    }
                }
            }
        } else {
             if(type) {
                for(int i = 0; i<list.size(); i++) {
                    if(list.get(i).getEmission(year).next().getSecond() < a.getEmission(year).next().getSecond()) {
                        a = list.get(i);
                    }
                }
            } else {
                for(int i = 0; i<list.size(); i++) {
                    if(list.get(i).getEmissionPerCapita(year).next().getSecond() < a.getEmissionPerCapita(year).next().getSecond()) {
                        a = list.get(i);
                    }
                }
            }
        }
        return a;
    }
    /**
     * method to print the ten top countries with the lowest carbon emissions from 2005 to 2019
     * this method must use a forward iterator
     * @param list of countries sorted by their total carbon emissions
     */
    //prints the top ten countries with the lowest carbon emissions. The list is sorted by the total carbon emissions. This method should use a forward iterator to print the first ten countries from the list. You must define this method.
    public static void printTenTopLowestEmissions(ArrayList<Country> list){
        ListIterator<Country> listIter = list.listIterator();

        for(int i = 0; i<10; i++) {
            System.out.println(listIter.next().getName());
        }
    }
    /**
     * method to print the ten top countries with the highest carbon emissions from 2005 to 2019
     * this method must use a backward iterator
     * @param list of countries sorted by their total carbon emissions
     */
    public static void printTenTopHighestEmissions(ArrayList<Country> list){
        ListIterator<Country> listIter = list.listIterator();

        for(int i = list.size(); i<list.size()-10; i++) {
            System.out.println(listIter.previous().getName());
        }
 
    }
}
