package DataStructures.Trees.BST.Medium;


import DataStructures.Trees.TreeNode;

import java.util.Objects;

public class BinarySearchTree {

    TreeNode root;

    public boolean addNode(int value) {

        TreeNode newNode = new TreeNode(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        // traverse whole tree to put the node in correct place.
        return traverseAndUpdateTree(root, newNode) != null;
    }

    private TreeNode traverseAndUpdateTree(TreeNode root, TreeNode newNode) {
        TreeNode temp = root;
        while (temp != null) {

            if (temp.getData() == newNode.getData()) {
                break;
            }

            if (newNode.getData() < temp.getData()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return temp;
                }
                temp = temp.getLeft();
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(newNode);
                    return temp;
                }
                temp = temp.getRight();
            }
        }

        return null;
    }

    private static boolean validateLeftSubtree(final TreeNode root, final TreeNode node) {

        if (Objects.isNull(node)) {
            return true;
        }

        boolean isValid = validateLeftSubtree(node, node.getLeft());
        return root.getData() > node.getData() && isValid;
    }

    private static boolean validateRightSubtree(final TreeNode root, final TreeNode node) {

        if (Objects.isNull(node)) {
            return true;
        }

        boolean isValid = validateRightSubtree(node, node.getRight());
        return root.getData() < node.getData() && isValid;
    }

    private static boolean validateBST(final TreeNode node) {

        if (Objects.isNull(node)) {
            return false;
        }

        boolean isLeftValid = validateLeftSubtree(node, node.getLeft());
        boolean isRightValid = validateRightSubtree(node, node.getRight());

        return isLeftValid && isRightValid;
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.addNode(3);
        bst.addNode(1);
        bst.addNode(2);

//        bst.printBST();
//        System.out.println('\n');
//        System.out.print(bst.root.getData() + " ");
//        System.out.print(bst.root.getRight().getData() + " ");
//        System.out.print(bst.root.getRight().getRight().getData() + " ");

        System.out.println("\nIs valid BST: " + validateBST(bst.root));
    }

}
