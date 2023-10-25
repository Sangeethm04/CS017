import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Country implements Comparable < Country > {
    private String name;
    private LinkedList < Pair < Integer,Double >> carbonEmission;
    private LinkedList < Pair < Integer, Double >> carbonEmissionPerCapita;

    public Country(String name) {
        this.name = name;
        carbonEmission = new LinkedList<>();
        carbonEmissionPerCapita = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmission(int year, double tons) {
        carbonEmission.add(new Pair <Integer,Double> (year, tons));
    }

    public void addEmissionPerCapita(int year, double tons) {
        carbonEmissionPerCapita.add(new Pair<Integer, Double>(year, tons));
    }

    public ListIterator<Pair<Integer, Double>> getEmission(int year) {
        ListIterator<Pair<Integer, Double>> listIterator = carbonEmission.listIterator();
        while(listIterator.hasNext()) {
            if(listIterator.next().getFirst().equals(year)) {
                return listIterator;
            }
        }
        return null;
    }

    public ListIterator<Pair<Integer, Double>> getEmissionPerCapita(int year) {
        ListIterator<Pair<Integer, Double>> listIterator = carbonEmissionPerCapita.listIterator();
        while(listIterator.hasNext()) {
            if(listIterator.next().getFirst().equals(year)) {
                return listIterator;
            }
        }
        return null;
    }

    public double getTotalEmissions() {
        ListIterator<Pair<Integer, Double>> listIterator = carbonEmissionPerCapita.listIterator();
        double total = 0;
        while(listIterator.hasNext()) {
            total += listIterator.next().getSecond();
        }
        return total;
    }

    public String toString() {
        return name + "carbon Emission" + carbonEmission + "Carbon Emission Per capita" + carbonEmissionPerCapita;
    }

    //equals(Object o) returns true if the two countries being compared have the same name, false otherwise.
    public boolean equals(Object o) {
       if(o instanceof Country) {
        Country count = (Country) o;
        return this.getName().equals(count.getName());
       }
       return false;
    }

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