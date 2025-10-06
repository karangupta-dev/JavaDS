package DataStructures.Trees;


import java.util.Objects;

public class TreeOperations {

    static class TreeInfo {
        int height;
        int diam;

        TreeInfo(int height, int diam) {
            this.height = height;
            this.diam = diam;
        }
    }

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

    public static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = height(root.getLeft());
        int rightDepth = height(root.getRight());

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int diameter(TreeNode root) { //Complexity: O(N^2)
        if(root == null) {
            return 0;
        }

        int diam1 = height(root.left) + height(root.right) + 1;
        int diam2 = diameter(root.left);
        int diam3 = diameter(root.right);

        return Math.max(diam1, Math.max(diam2, diam3));
    }

    public static TreeInfo diameterOptimized(TreeNode root) {
        if(root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTI = diameterOptimized(root.getLeft());
        TreeInfo rightTI = diameterOptimized(root.getRight());

        int myHeight = Math.max(leftTI.height, rightTI.height) + 1;

        int diam1 = leftTI.height + rightTI.height + 1;

        int myDiam = Math.max(diam1, Math.max(leftTI.diam, rightTI.diam));

        return new TreeInfo(myHeight, myDiam);
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

        TreeNode root = TreeOperations.buildPreOrderTree(nodes);
//        System.out.println("Max Depth of the tree is: " + maxDepth(root));
//        System.out.println("Sum of all nodes in the tree is: " + sumOfNodes(root));
//        System.out.println("Count of all nodes in the tree is: " + countOfNodes(root));
//        System.out.println("Diameter of the tree is: " + diameter(root));
        System.out.println("Diameter of the tree is: " + diameterOptimized(root).diam);
    }
}
