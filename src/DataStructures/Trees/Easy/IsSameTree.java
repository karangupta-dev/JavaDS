package DataStructures.Trees.Easy;

import DataStructures.Trees.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class IsSameTree {

    static int idx = -1;

    private static boolean checkIfSameTrees(TreeNode a, TreeNode b) {
        List<Integer> listOne = new LinkedList<Integer>();
        List<Integer> listTwo = new LinkedList<Integer>();

        getNodesInPreorder(listOne, a);
        getNodesInPreorder(listTwo, b);

        return listOne.equals(listTwo);
    }

    public static void getNodesInPreorder(List<Integer> list, TreeNode root) {

        if (Objects.isNull(root)) {
            list.add(null);
            return;
        }

        list.add(root.getData());
        getNodesInPreorder(list, root.getLeft());
        getNodesInPreorder(list, root.getRight());
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
        int[] nodesOne = {1, 2, 3};
        int[] nodesTwo = {1, 2, 3};

        TreeNode nodeOne = IsSameTree.buildTree(nodesOne);
        IsSameTree.idx = -1;
        TreeNode nodeTwo = IsSameTree.buildTree(nodesTwo);

        System.out.println("are both trees same? " + (IsSameTree.checkIfSameTrees(nodeOne, nodeTwo) ? "Yes" : "No"));
    }
}
