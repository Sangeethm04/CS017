public class Hello {
    public static void main(String[] args) {
        ArrayList<Sleds<String, String>> collection = new ArrayList();
        collection.add(new Sleds<String,String>("chicken", "nothing"));
        collection.add(new Sleds<String,String>("cow", "eating"));


        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.get(i).toString());
            collection.get(i).Sound();
        }

    }
}