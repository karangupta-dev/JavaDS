package DataStructures.Trees;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.addNode(11);
        bst.addNode(2);
        bst.addNode(33);
        bst.addNode(14);

//        bst.printBST();
        System.out.println('\n');
        System.out.println(bst.root.right.left.value);

    }
}
