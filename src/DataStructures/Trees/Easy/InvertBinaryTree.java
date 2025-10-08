package DataStructures.Trees.Easy;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class InvertBinaryTree {


    public static TreeNode buildTreeLevelOrder(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }


    private static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) {
            System.out.println("Root is null.");
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            extractNeighboursInStack(node, stack);

            queue.add(node);
        }

        return root;
    }

    private static void extractNeighboursInStack(TreeNode node, Stack<TreeNode> stack) {
        if (node != null && node.left != null) {
            stack.push(node.left);
        }

        if (node != null && node.right != null) {
            stack.push(node.right);
        }
    }


    public static void main(String[] args) {
        Integer[] n = {4,2,7,1,3,6,9};
        TreeNode root = buildTreeLevelOrder(n);
        invertBinaryTree(root);
    }
}
