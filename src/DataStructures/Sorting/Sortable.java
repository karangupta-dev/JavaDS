package DataStructures.Sorting;

public interface Sortable {

    int[] sort(int[] arr);

    default void printSortedList(int[] arr) {
        for (int j : arr) {
            System.out.println(j);
        }
    }

}
