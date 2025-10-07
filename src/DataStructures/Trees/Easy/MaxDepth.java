package DataStructures.Trees.Easy;

import DataStructures.Trees.Traversal.LevelOrder;
import DataStructures.Trees.TreeNode;

import java.util.Objects;

public class MaxDepth {

    static int idx = -1;

    public static int maxDepth(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }

        return Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight())) + 1;
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

        TreeNode root = LevelOrder.buildTree(nodes);
        System.out.println("Maximum Depth of tree: " + maxDepth(root));
    }
}
