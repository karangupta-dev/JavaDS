package DataStructures.Recursion;

public class Easy {

    static int presum = 0;
    static int sum = 1;

    private static int fibInternal(int presum, int sum, int n) {

        if (sum <= n) {
            int r = presum + sum;
            presum = sum;
            sum = r;
            System.out.println(r);
            return fibInternal(presum, sum, n);
        }

        return sum;
    }

    private static int fibonacci(int n) {
        System.out.println(presum);
        System.out.println(sum);

        return fibInternal(presum, sum, n);
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        n *= factorial(n - 1);
        return n;
    }

    private static int stackHeight(int n, int pow) {

        if (pow == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        return n * stackHeight(n, pow - 1);
    }

    private static void printStringInReverse(String str, int n) {

        if (n < 0) {
            return;
        }

        System.out.print(str.charAt(n));
        printStringInReverse(str, --n);
    }

    private static boolean isSorted(int[] nums, int currentIdx) {

        if (currentIdx == nums.length - 1) {
            return true;
        }

        int currentNum = nums[currentIdx];
        int nextNum = nums[currentIdx + 1];
        if (currentNum < nextNum && nextNum - currentNum == 1) {
            return isSorted(nums, currentIdx + 1);
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(Easy.factorial(5));
//        Easy.fibonacci(5);
//        System.out.println(Easy.stackHeight(3, 75));
//        System.out.println((float) 7 / 2);

//        String name = "lambda";
//        printStringInReverse(name, name.length() - 1);

        System.out.println("Array is sorted: " + isSorted(new int[]{1, 2, 3}, 0));
    }

}
