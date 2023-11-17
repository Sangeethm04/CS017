import java.util.Comparator;
/**
 * ComparatorByGPA class
 */
public class ComparatorByGPA implements Comparator < Student > {
    /**
     * compare method to implement the comparator interface
     * @param a first student
     * @param b second student
     * @return int
     */
    public int compare(Student a, Student b) {
        Double gpaa = a.getGPA();
        Double gpab = b.getGPA();

        return gpaa.compareTo(gpab);
    }
}