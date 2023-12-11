public class Test {
    public static void main(String[] args) {
        HashMap < Integer, String > map = new HashMap < > ();
        map.put(5, "Hello");
        map.put(54, "hbe");

        map.put(25, "sdf");
        map.put(54, "asdf");
        map.put(12, "sfpiwo");
        map.put(2342344, "sfpiwo");

        map.put(122342234, "sfpiwo");
        


        //use the keys method 
        for (Integer key: map.keys()) {
            System.out.println(key + " " + map.get(key));

        }
System.out.println(map.containsValue("asdfd"));
    }
}