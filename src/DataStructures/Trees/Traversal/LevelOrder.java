package DataStructures.Trees.Traversal;

import DataStructures.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    static int idx = -1;
    static Queue<TreeNode> queue = new LinkedList<>();

    public static void printTreeInLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }
            System.out.print(node.getData() + " ");

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }

        }
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
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        TreeNode root = InOrder.buildInorderTree(nodes);
        queue.add(root);
        queue.add(null); // to represent levels
        printTreeInLevelOrder(root);
    }
}
