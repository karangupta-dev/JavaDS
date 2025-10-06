package DataStructures.Trees.Traversal;

import DataStructures.Trees.TreeNode;

public class PostOrder {

    static int idx = -1;

    public static void printTreeInPostOrder(TreeNode root) {
        if (root == null) {
            System.out.print(-1 + " "); // to represent null nodes
            return;
        }

        printTreeInPostOrder(root.getLeft());
        printTreeInPostOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    public static TreeNode buildTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }

        TreeNode newTreeNode = new TreeNode(nodes[idx]);
        newTreeNode.setLeft(buildTree(nodes));
        newTreeNode.setRight(buildTree(nodes));
        return newTreeNode;
    }

    public static void main(String args[]) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        TreeNode root = PostOrder.buildTree(nodes);
        printTreeInPostOrder(root);
    }
}
