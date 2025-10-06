package DataStructures.Trees.Medium;

import DataStructures.Trees.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    static int idx = -1;

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> response = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        queue.add(root);
        queue.add(null); // to represent levels

        while (!queue.isEmpty()) {

            Integer n = getTreeNodeData(queue);

            if (Objects.isNull(n)) {
                response.add(subList);
                subList = new ArrayList<>();
            } else {
                subList.add(n);
            }

        }
        return response;
    }

    private static Integer getTreeNodeData(Queue<TreeNode> queue) {
        TreeNode node = queue.poll();
        if (node == null) {
            if (!queue.isEmpty()) {
                queue.add(null);
            }
            return null;
        }

        if (node.getLeft() != null) {
            queue.add(node.getLeft());
        }
        if (node.getRight() != null) {
            queue.add(node.getRight());
        }
        return node.getData();
    }

    public static TreeNode buildTree(int[] nodes) {
        idx++;
        TreeNode newTreeNode = new TreeNode();

        if (idx < nodes.length && nodes[idx] == -1) {
            return null;
        }

        if (!(idx < nodes.length)) {
            return newTreeNode;
        }

        newTreeNode.setData(nodes[idx]);
        newTreeNode.setLeft(buildTree(nodes));
        newTreeNode.setRight(buildTree(nodes));
        return newTreeNode;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        TreeNode root = BinaryTreeLevelOrderTraversal.buildTree(nodes);
        BinaryTreeLevelOrderTraversal.levelOrder(root);
    }

}
