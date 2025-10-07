package DataStructures.Trees.Medium;

import DataStructures.Trees.Easy.RootToNodePath;
import DataStructures.Trees.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class LowestCommonAncestor extends RootToNodePath {

    private static int getLowestCommonAncestor(TreeNode root, int nodeA, int nodeB) {

        Set<Integer> s1 = Arrays.stream(getPath(root, nodeA)).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(getPath(root, nodeB)).boxed().collect(Collectors.toSet());

        Set<Integer> intersection = new HashSet<Integer>(s1);
        intersection.retainAll(s2);
        return (int) Collections.max(intersection);
    }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, -1, -1};
        int nodeA = 8, nodeB = 5;

        TreeNode root = LowestCommonAncestor.buildTree(nodes);
        System.out.println("LowestCommonAncestor is: " + getLowestCommonAncestor(root, nodeA, nodeB));
    }
}
