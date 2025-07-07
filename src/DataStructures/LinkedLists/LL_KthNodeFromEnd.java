package DataStructures.LinkedLists;

public class LL_KthNodeFromEnd extends LinkedList {

    /*
    *   LL_KthNodeFromEnd myLinkedList = new LL_KthNodeFromEnd(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        int k = 2;
        int result = myLinkedList.findKthFromEnd(k).getValue();

        System.out.println(result); // Output: 4
    *
    *
    * */


    public LL_KthNodeFromEnd(final int value) {
        super(value);
    }

    public Node findKthFromEnd(final int index) {

        Node slow = getHead();
        Node fast = getHead();

        for (int i = 0; i < index; i++) {
            if (fast == null) {
                return null;
            }

            fast = fast.next;
        }

        while (fast != null) {

            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


}
