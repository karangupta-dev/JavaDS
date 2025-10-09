package DataStructures.Recursion;

public class Medium {

    private static void towerOfHanoi(int n, String src, String helper, String dest) {

        if (n == 1) {
            System.out.println("Transfer disk " + n + " from src " + src + " to dest " + dest);
            return;
        }

        towerOfHanoi(n - 1, src, dest, helper);
        System.out.println("Transfer disk " + n + " from src " + src + " to dest " + dest);
        towerOfHanoi(n - 1, helper, src, dest);
    }

    private static void firstAndLastOccurrenceOfElement(String str, char c, int currentIndex, int firstIndex, int lastIndex) {


        if (currentIndex == str.length() - 1) {

            if (firstIndex == -1 && firstIndex == lastIndex) {
                System.out.println("not found");
                return;
            }

            if (firstIndex != -1 && lastIndex == -1) {
                System.out.println("Only one occurrence at index: " + firstIndex);
                return;
            }

            System.out.println("first occurrence at index: " + firstIndex);
            System.out.println("last occurrence at index: " + lastIndex);
            return;
        }


        if (str.charAt(currentIndex) == c) {
            if (firstIndex == -1) {
                firstIndex = currentIndex;
            } else {
                lastIndex = currentIndex;
            }
        }

        firstAndLastOccurrenceOfElement(str, c, currentIndex + 1, firstIndex, lastIndex);
    }

    public static void main(String[] args) {

//        int n = 3; // tower of hanoi
//        towerOfHanoi(n, "S", "H", "D"); // tower of hanoi

//        String str = "mumbai";
//        firstAndLastOccurrenceOfElement(str, 'm', 0, -1, -1);
    }
}
