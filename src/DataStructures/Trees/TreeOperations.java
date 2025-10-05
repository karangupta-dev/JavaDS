package DataStructures.Trees;


import java.util.Objects;

public class TreeOperations {

    static int idx = -1;

    public static int countOfNodes(TreeNode root) {
        if(Objects.isNull(root)){
            return 0;
        }

        return 1 + countOfNodes(root.getLeft()) + countOfNodes(root.getRight());
    }

    public static int sumOfNodes(TreeNode root) {
        if(Objects.isNull(root)){
            return 0;
        }

        return root.getData() + sumOfNodes(root.getLeft()) + sumOfNodes(root.getRight());
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());

        return Math.max(leftDepth, rightDepth) + 1;
    }

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

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeOperations ops = new TreeOperations();

        TreeNode root = TreeOperations.buildPreOrderTree(nodes);
//        System.out.println("Max Depth of the tree is: " + maxDepth(root));
//        System.out.println("Sum of all nodes in the tree is: " + sumOfNodes(root));
        System.out.println("Count of all nodes in the tree is: " + countOfNodes(root));
    }
}
