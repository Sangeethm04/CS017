public class Pair < E1, E2 > {
    private E1 first;
    private E2 second;

    public Pair(E1 f, E2 s) {
        first = f;
        second = s;
    }

    public E1 getFirst() {
        return first;
    }

    public E2 getSecond() {
        return second;
    }

    public void setFirst(E1 f) {
        first = f;
    }

    public void setSecond(E2 s) {
        second = s;
    }

    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair < E1, E2 > pair = (Pair) o;
            return this.first.equals(pair.first) && this.second.equals(pair.second);
        }
        return false;
    }
}