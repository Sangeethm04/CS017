import java.util.Comparator;

public class ComparatorByGPA implements Comparator < Student > {
    public int compare(Student a, Student b) {
        Double gpaa = a.getGPA();
        Double gpab = b.getGPA();

        return gpaa.compareTo(gpab);
    }
}