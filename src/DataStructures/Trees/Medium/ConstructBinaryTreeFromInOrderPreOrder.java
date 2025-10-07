package DataStructures.Trees.Medium;

import DataStructures.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInOrderPreOrder {

    static final Map<Integer, Integer> inorderElementsMap = new HashMap<>();

    private static void setInOrderMap(final int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderElementsMap.put(inorder[i], i);
        }
    }

    private static TreeNode constructTree(int[] preOrder, Map<Integer, Integer> inorderElementsMap, int rootIndex, int left, int right) {

        TreeNode node = new TreeNode(preOrder[rootIndex]);
        int mid = inorderElementsMap.get(preOrder[rootIndex]);

        if (mid > left) {
            node.setLeft(constructTree(preOrder, inorderElementsMap, rootIndex + 1, left, mid - 1));
        }

        if (mid < right) {
            node.setRight(constructTree(preOrder, inorderElementsMap, rootIndex + mid - left + 1, mid + 1, right));
        }

        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {2, 1, 3, 4};

        setInOrderMap(inorder);
        TreeNode root = constructTree(preorder, inorderElementsMap, 0, 0, preorder.length - 1);
        System.out.println(root);
    }
}
