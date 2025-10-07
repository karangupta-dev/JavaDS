package DataStructures.Trees.Medium;

import DataStructures.Trees.Easy.RootToNodePath;
import DataStructures.Trees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;


public class LowestCommonAncestor extends RootToNodePath {

    private static int getLowestCommonAncestor(TreeNode root, int nodeA, int nodeB) {

        Set<Integer> s1 = Arrays.stream(getPath(root, nodeA)).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(getPath(root, nodeB)).boxed().collect(Collectors.toSet());

        Set<Integer> intersection = new HashSet<Integer>(s1);
        intersection.retainAll(s2);
        return (int) Collections.max(intersection);
    }

    private static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode nodeA, TreeNode nodeB) {

        if (Objects.isNull(root) || root.getData() == nodeA.getData() || root.getData() == nodeB.getData()) {
            return root;
        }

        TreeNode left = getLowestCommonAncestor(root.getLeft(), nodeA, nodeB);

        TreeNode right = getLowestCommonAncestor(root.getRight(), nodeA, nodeB);

        boolean isLeftNull = Objects.isNull(left);
        boolean isRightNull = Objects.isNull(right);


        if (!isLeftNull && !isRightNull) {
            return root;
        } else if (isLeftNull && !isRightNull) {
            return right;
        } else if (!isLeftNull) {
            return left;
        }

        return null;
    }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, -1, -1};

//      Unoptimized Solution
//        int nodeA = 8, nodeB = 5;
//
//        TreeNode root = LowestCommonAncestor.buildTree(nodes);
//        System.out.println("LowestCommonAncestor is: " + getLowestCommonAncestor(root, nodeA, nodeB));
//

//        Optimized Solution

        TreeNode nodeA = new TreeNode(5);
        TreeNode nodeB = new TreeNode(4);
        TreeNode root = LowestCommonAncestor.buildTree(nodes);
        TreeNode lca = getLowestCommonAncestor(root, nodeA, nodeB);

        System.out.println("LowestCommonAncestor is: " + lca.getData());

    }
}
