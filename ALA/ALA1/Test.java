public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Student(123456789, "Paul Leister", "972 4th Street, Allentown", "610-331-7177", "pleister@gmail.com", "CSE");
        people[1] = new Employee(334422110, "Beth Down", "234 Main Street, Philadelphia", "484-222-4433", "bdown@gmail.com", "System Administrator", 75000.00);
        people[2] = new Faculty(222222222, "Mark Jones", "21 Orchid Street, Bethlehem", "610-333-2211", "mjones@gmail.com", "Faculty", 100000.00, "Associate Professor");
       
        System.out.println("Original List");
        printArray(people);
        
        System.out.println("List sorted by name:");
        sortArray(people, true);
        printArray(people);

        System.out.println("List sorted by id:");
        sortArray(people, false);
        printArray(people);
    }

    public static void printArray(Person[] list) {
        for (Person p: list) {
            System.out.println(p);
        }
    }

    public static void sortArray(Person[] list, boolean nameOrId) {
        for (int i = 0; i < list.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++)
                if (!nameOrId) { //sort by id
                    if (list[j].getID() < list[minIndex].getID())
                        minIndex = j;
                } else {
                    String name1 = list[j].getName();
                    String name2 = list[minIndex].getName();
                    if (name1.compareTo(name2) < 0)
                        minIndex = j;
                }
            Person temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
}