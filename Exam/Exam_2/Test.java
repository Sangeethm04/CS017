import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List < Message > [] messages = new List[2];
        messages[0] = new ArrayList < Message > ();
        messages[1] = new LinkedList < Message > ();

        readMessages(messages[0], "list1.txt");
        readMessages(messages[1], "list2.txt");

        Date d = new Date("01/26/2022");
        List < Message > list = findMessages(messages[0], d);
        if (list == null) {
            System.out.println("No messages found for the date " + d);
        } else {
            System.out.println(list.size() + " messages found for the date " + d + ":");
            print(list);
            System.out.println();
        }
        d = new Date("01/22/2022");
        list = findMessages(messages[1], d);
        if (list == null) {
            System.out.println("No messages found for the date " + d);
        } else {
            System.out.println(list.size() + " messages found for the date " + d + ":");
            print(list);
            System.out.println();
        }

        List < Message > unionList = new ArrayList < > ();
        union(messages[0], messages[1], unionList);
        System.out.println("Union of the two lists:");
        print(unionList);
        System.out.println();

        List < Message > intersectionList = new LinkedList < > ();
        intersection(messages[0], messages[1], intersectionList);
        System.out.println("Intersection of the two lists:");
        print(intersectionList);
        System.out.println();

        List < Message > unionNoDuplicatesList = new ArrayList < > ();
        unionNoDuplicates(messages[0], messages[1], unionNoDuplicatesList);
        System.out.println("Union of the two lists without duplicates:");
        print(unionNoDuplicatesList);
        System.out.println();

        unionList.sort(null);
        System.out.println("Union List sorted by sender:");
        print(unionList);
        System.out.println();
        unionList.sort(new ComparatorByRecipient());
        System.out.println("Union List sorted by recipient:");
        print(unionList);
        System.out.println();
        unionList.sort(new ComparatorByDate());
        System.out.println("Union List sorted by date:");
        print(unionList);
        System.out.println();
    }
    public static void readMessages(List < Message > list, String filename) {
        try {
            Scanner read = new Scanner(new File(filename));
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] tokens = line.split(",");
                Date date = new Date(tokens[0]);
                list.add(new Message(date, tokens[1], tokens[2], tokens[3]));
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + filename + "\" not found");
        }
    }
    // combines the elements from list1 and list 2 into list
    //O(n)
    public static < E > void union(List < E > list1, List < E > list2, List < E > list) {
        Iterator < E > iter = list1.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        Iterator < E > iter2 = list2.iterator();
        while (iter2.hasNext()) {
            list.add(iter2.next());
        }
        //sort list1
    }
    // the intersection of list1 and list2 in list using iterator
    //O(n^2)
    public static < E > void intersection(List < E > list1, List < E > list2, List < E > list) {
        Iterator < E > iter1 = list1.iterator();
        while (iter1.hasNext()) {
            E e1 = iter1.next();
            Iterator < E > iter2 = list2.iterator();
            while (iter2.hasNext()) {
                E e2 = iter2.next();
                if ((e1).equals(e2)) {
                    list.add(e1);
                    break;
                }
            }
        }

    }
    // combines list1 and list2 in list without duplicates with iterator
    //O(n)
    public static < E > void unionNoDuplicates(List < E > list1, List < E > list2, List < E > list) {
        Iterator < E > iter1 = list1.iterator();
        Iterator < E > iter2 = list2.iterator();
        Iterator < E > iter0 = list.iterator();
        ArrayList < E > vals = new ArrayList < > ();
        while (iter1.hasNext()) {
            E e1 = iter1.next();
            while (iter0.hasNext()) {
                if ((e1).equals(iter0.next())) {
                    vals.add(e1);
                }
            }
        }
        while (iter2.hasNext()) {
            E e2 = iter2.next();
            while (iter0.hasNext()) {
                if ((e2).equals(iter0.next())) {
                    vals.add(e2);
                }
            }
        }
        for (int i = 0; i < vals.size(); i++) {
            list.add(vals.get(i));
        }


    }
    // returns the list of  messages sent at the date d, null if no messages were found
    //O(n)
    public static ArrayList < Message > findMessages(List < Message > list, Date d) {
    ArrayList<Message> messages = new ArrayList<>();
    Iterator<Message> iter = list.iterator();
     return findMessages(d, iter, messages);


    }
    //Define the method findMessages that accepts a list of messages and a Date object d, and returns the list of messages that were sent on the date d. The method returns null if no messages were found. The method must be recursive and use an iterator.
    public static ArrayList < Message > findMessages(Date d, Iterator < Message > iter, ArrayList < Message > messages) {
        if(!iter.hasNext()) {
            return messages;
        }
        Message message = iter.next();
        if(message.getDate().equals(d)) {
            messages.add(message);
        } 
            return findMessages(d, iter, messages);

    }


    public static < E > void print(List < E > list) {
        Iterator < E > iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}