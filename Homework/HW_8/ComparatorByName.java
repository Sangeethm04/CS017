import java.util.Comparator;

public class ComparatorByName implements Comparator < Student > {
    public int compare(Student a, Student b) {
        String nameA = a.getName();
        String nameB = b.getName();


        return nameA.compareTo(nameB);
    }
}