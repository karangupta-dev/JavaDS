package DataStructures.Trees.Easy;

import DataStructures.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RootToNodePath {

    static int idx = -1;

    private static boolean dfs(final TreeNode node, final List<Integer> path, final int target) {

        if (Objects.isNull(node)) {
            return false;
        }

        path.add(node.getData());

        if (node.getData() == target) {
            return true;
        }

        boolean foundInLeftSubtree = dfs(node.getLeft(), path, target);
        boolean foundInRightSubtree = dfs(node.getRight(), path, target);

        if (foundInLeftSubtree || foundInRightSubtree) {
            return true;
        } else {
            path.removeLast();
            return false;
        }

    }

    private static int[] getPath(final TreeNode node, final int target) {

        List<Integer> path = new ArrayList<Integer>();

        if (Objects.isNull(node)) {
            return path.stream().mapToInt(Integer::intValue).toArray();
        }

        dfs(node, path, target);

        return path.stream().mapToInt(Integer::intValue).toArray();
    }

    private static TreeNode buildTree(final int[] nodes) {
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
        int[] nodes = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, -1, -1};
        int target = 8;

        TreeNode root = RootToNodePath.buildTree(nodes);

        for (int i : getPath(root, target)) {
            System.out.print(i + " ");
        }
    }
}
