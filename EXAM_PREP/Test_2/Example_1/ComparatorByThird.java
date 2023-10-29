import java.util.Comparator;

public class ComparatorByThird <E1 , E2, E3 extends Comparable<E3>, E4> implements Comparator<Tuple<E1, E2, E3, E4 >>{
    public int compare(Tuple<E1, E2, E3, E4 > t1, Tuple<E1, E2, E3, E4 > t2) {
        E3 t1first = t1.getThird();
        E3 t2first = t2.getThird();

       return t1first.compareTo(t2first);
    }
}
