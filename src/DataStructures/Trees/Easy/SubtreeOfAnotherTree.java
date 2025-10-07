package DataStructures.Trees.Easy;

import DataStructures.Trees.TreeNode;


import java.util.Objects;

public class SubtreeOfAnotherTree {
    static int idx = -1;

    private static boolean isSameTree(TreeNode nodeA, TreeNode nodeB) {
        boolean isRootAInvalid = Objects.isNull(nodeA);
        boolean isRootBInvalid = Objects.isNull(nodeB);

        if (isRootAInvalid && isRootBInvalid) {
            return true; // no trees to compare
        }

        if (isRootAInvalid || isRootBInvalid) {
            return false; // either of node is not present, cannot compare
        }

        if (nodeA.getData() == nodeB.getData()) { // if both nodes have same content then compare childs
            return isSameTree(nodeA.getLeft(), nodeB.getLeft()) && isSameTree(nodeA.getRight(), nodeB.getRight());
        }

        return false;
    }

    private static boolean isSubtreeOfAnotherTree(TreeNode root, TreeNode subRoot) {

        if (Objects.isNull(subRoot)) {
            return true;
        }

        if (Objects.isNull(root)) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtreeOfAnotherTree(root.getLeft(), subRoot) || isSubtreeOfAnotherTree(root.getRight(), subRoot);
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

    public static void main(String[] args) {
        int[] nodesOne = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int[] nodesTwo = {1, 2, 4, -1, -1, 5, -1, -1, -1};

        TreeNode nodeOne = SubtreeOfAnotherTree.buildTree(nodesOne);
        SubtreeOfAnotherTree.idx = -1;
        TreeNode nodeTwo = SubtreeOfAnotherTree.buildTree(nodesTwo);

        System.out.println("Is tree of another subtree? " + (SubtreeOfAnotherTree.isSubtreeOfAnotherTree(nodeOne, nodeTwo) ? "Yes" : "No"));
    }
}
