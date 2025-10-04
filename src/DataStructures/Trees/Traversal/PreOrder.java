package DataStructures.Trees.Traversal;

import DataStructures.Trees.Node;

public class PreOrder {
    static int idx = -1;

    public static Node buildPreOrderTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.setLeft(buildPreOrderTree(nodes));
        newNode.setRight(buildPreOrderTree(nodes));
        return newNode;
    }

    public static void printTreeInPreOrder(Node root) {

        if (root == null) {
            System.out.print(-1 + " "); // to represent null nodes
            return;
        }

        System.out.print(root.getData() + " ");
        printTreeInPreOrder(root.getLeft());
        printTreeInPreOrder(root.getRight());
    }

    public static void main(String args[]) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        PreOrder tree = new PreOrder();

        Node root = tree.buildPreOrderTree(nodes);
        printTreeInPreOrder(root);
    }


    public static int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
