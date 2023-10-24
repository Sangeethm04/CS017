import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
public class Country implements Comparable < E > {
    private String name;
    private LinkedList < Pair < Integer,
    Double >> carbonEmission;
    private LinkedList < Pair < Integer,
    Double >> carbonEmissionPerCapita;

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
//addEmission(int year, double tons) adds the pair (year, tons) to the linked list carbonEmission.
    public void addEmission(int year, double tons) {
        carbonEmission.add(new Pair <Integer,Double> (year, tons));
    }

    public void addEmissionPerCapita(int year, double tons) {
        carbonEmissionPerCapita.add(new Pair<Integer, Double>(year, tons));
    }

    public ListIterator<Pair<Integer, Double>> getEmission(int year) {

    }

      public ListIterator<Pair<Integer, Double>> getEmissionPerCapita(int year) {

    }

    public String toString() {

    }

    public boolean equals(Object o) {

    }
    
    public int compareTo(Country c) {
        
    }

}