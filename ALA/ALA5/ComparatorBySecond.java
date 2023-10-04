import java.util.Comparator;
/**
 * class ComparatorByFirst that implements comparator
 */
public class ComparatorBySecond < E1, E2 extends Comparable < E2 >> implements Comparator < Pair < E1, E2 >> {
    /**
     * public class compare
     * @return int
     * @param Pair < E1, E2 > pair1, Pair < E1, E2 > pair2
     */
    public int compare(Pair < E1, E2 > pair1, Pair < E1, E2 > pair2) {
        E2 p1Second = pair1.getSecond();
        E2 p2Second = pair2.getSecond();
        return p1Second.compareTo(p2Second);
    }
}