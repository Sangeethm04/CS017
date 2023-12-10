import java.util.Iterator;

public class Test5 {
    public static void main(String[] args) {
        ArrayList < Integer > array2 = new ArrayList < > ();
        array2.add(1);
        array2.add(2);
        array2.add(33333);
        array2.add(4);
        ArrayList < Integer > array3 = new ArrayList < > ();
        array3.add(4);
        array3.add(1);
        array3.add(52);
        array3.add(4455);
        Object[] arr = (array2.toArray());
        for(int i = 0; i<arr.length;i++) {
            System.out.println("hello" + arr[i]);
        }        

       Iterator<Integer> iter = array2.iterator();
       while(iter.hasNext()) {
        System.out.println(iter.next());
       }
        
    }
}
