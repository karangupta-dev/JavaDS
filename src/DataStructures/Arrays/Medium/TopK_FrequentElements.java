package DataStructures.Arrays.Medium;

public class TopK_FrequentElements {

    private static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency Counting
        java.util.Map<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // Step 2: Sorting and Selecting Top K
        return frequencyMap.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(k)
                .map(java.util.Map.Entry::getKey)
                .mapToInt(i -> i)
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
