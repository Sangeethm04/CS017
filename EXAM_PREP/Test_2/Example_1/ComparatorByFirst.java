import java.util.Comparator;

public class ComparatorByFirst <E1 extends Comparable<E1>, E2, E3, E4> implements Comparator<Tuple<E1, E2, E3, E4 >>{
    public int compare(Tuple<E1, E2, E3, E4 > t1, Tuple<E1, E2, E3, E4 > t2) {
        E1 t1first = t1.getFirst();
        E1 t2first = t2.getFirst();

       return t1first.compareTo(t2first);
    }
}
