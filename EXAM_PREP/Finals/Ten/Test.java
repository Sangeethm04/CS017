public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();

        for (int i = 0; i < 10; i++) {
            int num = (int)(Math.random() * 1000);
            bst.add(num);
        }

        //print bst
        bst.inorder();

        BST<Integer> bst2 = bst.clone();

        //print bst2

        bst2.inorder();
    }
}
