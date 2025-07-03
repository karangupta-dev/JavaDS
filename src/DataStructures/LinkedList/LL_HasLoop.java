package DataStructures.LinkedList;

public class LL_HasLoop extends LinkedList {

        /* goes in PSVM

         LL_HasLoop myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        // create a loop by connecting the tail to the second node
        myLinkedList.getTail().next = myLinkedList.getHead().next;


        System.out.println("Has Loop:");
        System.out.println( myLinkedList.hasLoop());

     */


    public LL_HasLoop(final int value) {
        super(value);
    }

    public boolean hasLoop() {
        return true;
    }

}
