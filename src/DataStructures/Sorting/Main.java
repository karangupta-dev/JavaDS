package DataStructures.Sorting;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter " + size + " integers:");

        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

//        Sortable sortable = new BubbleSort();
        Sortable sortable = new SelectionSort();

        sortable.printSortedList(sortable.sort(nums));

    }

}
