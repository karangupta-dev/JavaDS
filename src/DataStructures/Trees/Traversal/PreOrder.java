package DataStructures.Trees.Traversal;

import DataStructures.Trees.TreeNode;

public class PreOrder {
    static int idx = -1;

    public static TreeNode buildPreOrderTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        TreeNode newTreeNode = new TreeNode(nodes[idx]);
        newTreeNode.setLeft(buildPreOrderTree(nodes));
        newTreeNode.setRight(buildPreOrderTree(nodes));
        return newTreeNode;
    }

    public static void printTreeInPreOrder(TreeNode root) {

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

        TreeNode root = tree.buildPreOrderTree(nodes);
        printTreeInPreOrder(root);
    }
}
