/**
 * class Pair<E1, E2>
 */
public class Pair < E1, E2 > {
    private E1 first;
    private E2 second;

    /**
     * constructor for pair class
     * @param f
     * @param s
     */
    public Pair(E1 f, E2 s) {
        first = f;
        second = s;
    }

    /**
     * getter method for first
     * @return E1
     */
    public E1 getFirst() {
        return first;
    }

    /**
     * getter method for E2
     * @return E2
     */
    public E2 getSecond() {
        return second;
    }

    /**
     * setter method for first
     * @param f
     */
    public void setFirst(E1 f) {
        first = f;
    }

    /**
     * setter for s
     * @param s
     */
    public void setSecond(E2 s) {
        second = s;
    }

    /**
     * toString method for printing attributes
     * @return String of attributes
     */
    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

    /**
     * checks equals of pair
     * @return boolean
     * @param o object
     * 
     */
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair < E1, E2 > pair = (Pair) o;
            return this.first.equals(pair.first) && this.second.equals(pair.second);
        }
        return false;
    }
}