package DataStructures.LinkedLists;

public class LL_HasLoop extends LinkedList {

        /* goes in PSVM

          LL_HasLoop myLinkedList = new LL_HasLoop(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        // create a loop by connecting the tail to the second node
        myLinkedList.getTail().setNext(myLinkedList.getHead().getNext()) ;


        System.out.println("Has Loop:");
        System.out.print( myLinkedList.hasLoop());

     */


    public LL_HasLoop(final int value) {
        super(value);
    }

    public boolean hasLoop() {

        Node slow = getHead();
        Node fast = getHead();

        while (fast != null && fast.getNext() != null) {

            fast = fast.next.next;
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

}
