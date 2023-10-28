import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * Country class for country data
 */
public class Country implements Comparable < Country > {
    private String name;
    private LinkedList < Pair < Integer,Double >> carbonEmission;
    private LinkedList < Pair < Integer, Double >> carbonEmissionPerCapita;

    /**
     * Default constructor for country
     * @param name
     */
    public Country(String name) {
        this.name = name;
        carbonEmission = new LinkedList < Pair < Integer,Double >> ();
        carbonEmissionPerCapita = new LinkedList < Pair < Integer,Double >> ();
    }

    /**
     * Getter for name
     * @return String for name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name to change
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * adds pair to carbonEmission
     * @param year
     * @param tons
     */
    public void addEmission(int year, double tons) {
        carbonEmission.add(new Pair <Integer,Double> (year, tons));
    }

    /**
     * adds pair to carbonEmissionPerCapita
     * @param year 
     * @param tons
     */
    public void addEmissionPerCapita(int year, double tons) {
        carbonEmissionPerCapita.add(new Pair<Integer, Double>(year, tons));
    }

    /**
     * returns listIterator for carbonEmission
     * @param year
     * @return
     */
    public ListIterator<Pair<Integer, Double>> getEmission(int year) {
        ListIterator<Pair<Integer, Double>> listIterator = carbonEmission.listIterator();
        while(listIterator.hasNext()) {
            if(listIterator.next().getFirst().equals(year)) {
                listIterator.previous();
                return listIterator;
            }
        }
        return null;
        
    }

    /**
     * returns listIterator for carbonEmissionPerCapita
     * @param year
     * @return
     */
    public ListIterator<Pair<Integer, Double>> getEmissionPerCapita(int year) {
        ListIterator<Pair<Integer, Double>> listIterator = carbonEmissionPerCapita.listIterator();
        while(listIterator.hasNext()) {
            if(listIterator.next().getFirst().equals(year)) {
                listIterator.previous();
                return listIterator;
            }
        }
        return null;
    }

    /**
     * returns total emissions
     * @return double for total emissions
     */
    public double getTotalEmissions() {
        ListIterator<Pair<Integer, Double>> listIterator = carbonEmission.listIterator();
        double total = 0;
        while(listIterator.hasNext()) {
            total += listIterator.next().getSecond();
        }
        return total;
    }

    /**
     * returns attributes of country
     * @return String for attributes
     */
    public String toString() {//check again
        String str = "";
        str += name + "\n";
        str += "Carbon emissions: \n";
        ListIterator<Pair<Integer, Double>> listIterator = carbonEmission.listIterator();
        while(listIterator.hasNext()) {
            Pair<Integer, Double> pair = listIterator.next();
            str += pair.getFirst() + ": " + pair.getSecond() + "\n";
        }
        str += "Carbon emissions per capita: \n";
        listIterator = carbonEmissionPerCapita.listIterator();
        while(listIterator.hasNext()) {
            Pair<Integer, Double> pair = listIterator.next();
            str += pair.getFirst() + ": " + pair.getSecond() + "\n";
        }
        return str;
    }

    /**
     * checks if two countries are equal
     * @param o
     * @return boolean for equality
     */
    public boolean equals(Object o) {
       if(o instanceof Country) {
        Country count = (Country) o;
        return this.getName().equals(count.getName());
       }
       return false;
    }

    /**
     * compares two countries
     * @param c
     * @return int for comparison
     */
    public int compareTo(Country c) {
        if (this.getTotalEmissions() < c.getTotalEmissions()) {
            return -1;
        } else if(this.getTotalEmissions() > c.getTotalEmissions()) {
            return 1;
        } else {
            return 0;
        }
    }
}