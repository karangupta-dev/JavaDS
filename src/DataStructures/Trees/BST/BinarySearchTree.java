package DataStructures.Trees.BST;


public class BinarySearchTree {

    static class Node {

        Node left;
        Node right;
        int value;

        Node(int val) {
            this.value = val;
            this.left = null;
            this.right = null;
        }

    }

    Node root;

    public boolean addNode(int value) {

        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        // traverse whole tree to put the node in correct place.
        return traverseAndUpdateTree(root, newNode) != null;
    }

    private Node traverseAndUpdateTree(Node root, Node newNode) {
        Node temp = root;
        while (temp != null) {

            if (temp.value == newNode.value) {
                break;
            }

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return temp;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return temp;
                }
                temp = temp.right;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.addNode(11);
        bst.addNode(2);
        bst.addNode(33);
        bst.addNode(14);

//        bst.printBST();
        System.out.println('\n');
        System.out.println(bst.root.right.left.value);

    }

}
