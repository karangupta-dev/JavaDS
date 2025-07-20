package ProgrammingProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithNoDuplicates {

    public static int getLengthOfLongestSubstring(String s) {

        int slow, fast;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        HashSet<Character> visitedChar = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            slow = i;
            fast = i + 1;

            visitedChar.add(s.charAt(slow));

            while (fast < s.length() && !visitedChar.contains(s.charAt(fast))) {
                visitedChar.add(s.charAt(fast));
                fast++;
            }

            hashSet.add(visitedChar.size());
            visitedChar.clear();
//            i = fast;
        }

        return Collections.max(hashSet);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string:");
        String s = scanner.nextLine();

        System.out.println("Longest string:" + getLengthOfLongestSubstring(s));
    }
}
