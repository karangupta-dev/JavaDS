package DataStructures.Sorting;

public interface Sortable {

    int[] sort(int[] nums);

    default void printSortedList(int[] nums) {
        for (int j : nums) {
            System.out.println(j);
        }
    }

}
