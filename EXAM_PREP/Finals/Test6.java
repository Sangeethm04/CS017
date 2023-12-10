import java.util.Iterator;

public class Test6 {
    public static void main(String[] args) {
        LinkedList < Integer > ll = new LinkedList < > ();

        for (int i = 0; i < 5000000; i++) {
            int num = (int)(Math.random() * 1000);
            ll.add(num);
        }

        for (int i = 0; i < ll.size(); i++) {
            ll.get(i);
        }
        Iterator < Integer > iter = ll.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }



        //System.out.println("last index is: " + ll.lastIndexOf(4));

        ll.reverse();

    }
}