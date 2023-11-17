import java.util.Comparator;
/**
 * ComparatorByName class
 */
public class ComparatorByName implements Comparator < Student > {
    /**
     * compare method to implement the comparator interface
     * @param a first student
     * @param b second student
     * @return int
     */
    public int compare(Student a, Student b) {
        String nameA = a.getName();
        String nameB = b.getName();


        return nameA.compareTo(nameB);
    }
}