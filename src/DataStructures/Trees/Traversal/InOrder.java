package DataStructures.Trees.Traversal;

import DataStructures.Trees.TreeNode;

public class InOrder {

    static int idx = -1;

    public static void printTreeInInOrder(TreeNode root) {
        if (root == null) {
            System.out.print(-1 + " "); // to represent null nodes
            return;
        }

        printTreeInInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        printTreeInInOrder(root.getRight());

    }

    public static TreeNode buildInorderTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }

        TreeNode newTreeNode = new TreeNode(nodes[idx]);
        newTreeNode.setLeft(buildInorderTree(nodes));
        newTreeNode.setRight(buildInorderTree(nodes));
        return newTreeNode;
    }

    public static void main(String args[]) {
//        int[] nodes = {-1, 4, -1, 2, -1, 5, -1, 1, -1, 3, -1, 6, -1};
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        TreeNode root = InOrder.buildInorderTree(nodes);
        printTreeInInOrder(root);
    }
}
