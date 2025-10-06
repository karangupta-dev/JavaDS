package DataStructures.Sorting;

public class SelectionSort implements Sortable {

    // pull smallest number to the beginning of the array
    public int[] sort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[smallest] > nums[j]) {
                    smallest = j;
                }
            }
            int temp = nums[smallest];
            nums[smallest] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }

}
