/**
 * binary search tree implementation
 */
public class BST < E extends Comparable < E >> {
    private TreeNode root;
    private int size;
    public static int containsIterations,
    addIterations,
    removeIterations;
    private class TreeNode {
        E value;
        TreeNode left;
        TreeNode right;
        TreeNode(E val) {
            value = val;
            left = right = null;
        }
    }

    /**
     * bst constructor
     */
    public BST() {
        root = null;
        size = 0;
    }
// Implement the clone and equals methods for the BST class. Two BST trees are equal if they contain the same nodes. The clone method returns a deep copy of the tree. Determine the time complexity of the two methods.
    public BST<E> clone() {
        BST<E> copy = new BST<E>();
        copy.root = clone(root);
        copy.size = size;
        return copy;
    }

    private TreeNode clone(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(node.value);
        newNode.left = clone(node.left);
        newNode.right = clone(node.right);
        return newNode;
    }

    /**
     * size method
     * @return int size
     */
    public int size() {
        return size;
    }

    /**
     * isEmpty method
     * @return boolean
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * clear method
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Search Method
     * @param value E
     * @return boolean
     **/
    public boolean contains(E value) {
        containsIterations = 0;
        if (root == null) {
            return false;
        }
        TreeNode node = root;
        while (node != null) {
            containsIterations++;
            if (value.compareTo(node.value) < 0)
                node = node.left;
            else if (value.compareTo(node.value) > 0)
                node = node.right;
            else
                return true;
        }
        return false;
    }
    /**
     * insertion method
     * @param value E
     * @return boolean
     */
    // Insertion Method
    public boolean add(E value) {
        addIterations = 0;
        if (root == null)
            root = new TreeNode(value);
        else {
            TreeNode parent, node;
            parent = null;
            node = root;
            while (node != null) {
                addIterations++;
                parent = node;
                if (value.compareTo(node.value) < 0) {
                    node = node.left;
                } else if (value.compareTo(node.value) > 0) {
                    node = node.right;
                } else
                    return false;
            }
            if (value.compareTo(parent.value) < 0)
                parent.left = new TreeNode(value);
            else
                parent.right = new TreeNode(value);
        }
        size++;
        return true;
    }
    // Removal Method
    /**
     * removal method
     * @param value E
     * @return boolean
     */
    public boolean remove(E value) {
        removeIterations = 0;
        TreeNode parent, node;
        parent = null;
        node = root;
        // Find value first
        while (node != null) {
            removeIterations++;
            if (value.compareTo(node.value) < 0) {
                parent = node;
                node = node.left;
            } else if (value.compareTo(node.value) > 0) {
                parent = node;
                node = node.right;
            } else
                break; // value found
        }
        if (node == null) // value not in the tree
            return false;
        // Case 1: node has no children
        if (node.left == null && node.right == null) {
            if (parent == null) { // delete root
                root = null;
                size = 0;
            } else
            if (parent.left == node)
                parent.left = null;
            else
                parent.right = null;
        } else if (node.left == null) {
            //case 2: node has one right child
            if (parent == null)
                root = node.right;
            else
            if (parent.left == node)
                parent.left = node.right;
            else
                parent.right = node.right;
        } else if (node.right == null) {
            //case 2: node has one left child
            if (parent == null)
                root = node.left;
            else
            if (parent.left == node)
                parent.left = node.left;
            else
                parent.right = node.left;
        } else {
            // case 3: node has two children
            TreeNode rightMostParent = node;
            TreeNode rightMost = node.left;
            // go right on the left subtree
            while (rightMost.right != null) {
                removeIterations++;
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }
            // copy the value of rigthMost to node
            node.value = rightMost.value;
            //delete rigthMost
            if (rightMostParent.left == rightMost)
                rightMostParent.left = rightMost.left;
            else
                rightMostParent.right = rightMost.left;
        }
        size--;
        return true;
    }

    // Recursive Inorder Traversal Method
    /**
     * inorder method
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * inorder method
     * @param node
     */
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }
    /**
     *  Recursive Preorder Traversal Method
     **/
    public void preorder() {
        preorder(root);
    }

    /**
     * preorder method
     * @param node
     */
    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    /**
     * Recursive Postorder Traversal Method
     **/
    public void postorder() {
        postorder(root);
    }

    /**
     * postorder method
     * @param node treenode
     */
    private void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }
    //Time complexO(n)
    /**
     * height method
     * @return int
     */
    public int height() {
        return height(root);
    }

    /**
     * height method
     * @param node treenode
     * @return int height
     */
    private int height(TreeNode node) {
        //first base case
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) { /// node is a leaf
            return 1;
        }
        int heightL = height(node.left);
        int heightR = height(node.right);
        return 1 + Math.max(heightL, heightR);
    }

    /**
     * isBalanced method
     * @return boolean
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * isBalanced helper method
     * @return boolean
     * @param node treenode
     */
    private boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int heightL = height(node.left);
        int heightR = height(node.right);
        int diff = Math.abs(heightL - heightR);
        if (diff > 1) { // base case 2
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right); //recursive call

    }

}