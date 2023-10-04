import java.util.Comparator;

/**
 * class ComparatorByFirst that implements comparator
 */
public class ComparatorByFirst < E1 extends Comparable < E1 > , E2 > implements Comparator < Pair < E1, E2 >> {
    /**
     * public class compare
     * @return int
     * @param Pair < E1, E2 > pair1, Pair < E1, E2 > pair2
     */
    public int compare(Pair < E1, E2 > pair1, Pair < E1, E2 > pair2) {
        E1 p1First = pair1.getFirst();
        E1 p2First = pair2.getFirst();
        return p1First.compareTo(p2First);
    }
}