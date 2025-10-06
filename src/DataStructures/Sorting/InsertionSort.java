package DataStructures.Sorting;

public class InsertionSort implements Sortable {


    //1. divide array into two halves
    //2. assume first half has sorted elements and the second half has unsorted elements
    //3. one element is then moved from unsorted half to sorted half
    //4. elements are shifted in sorted half to make place for new element.
    public int[] sort(int[] nums) {

        for (int i = 1; i <= nums.length - 1; i++) {
            int current = nums[i];
            int j = i - 1;
            while (j >= 0 && current < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = current;
        }

        return nums;
    }

}
