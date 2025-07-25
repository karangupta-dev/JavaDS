package ProgrammingProblems.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class MediumQuestions {

    public static void countDuplicates() {
        List<Integer> nums = List.of(1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3);

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }

    public static void groupWordsByLength() {
        List<String> words = List.of("one", "two", "three", "four");

        Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(String::length));
        map.entrySet().forEach(System.out::println);
    }

    public static void secondHighestNo() {
        List<Integer> nums = List.of(5, 1, 3, 9, 7);

        nums = nums.stream().distinct().sorted(Comparator.reverseOrder()).toList();

        if (nums.size() > 1) {
            System.out.println(nums.get(1));
        } else {
            System.out.println("Not enough distinct numbers in the list.");
        }
    }

    public static void doesAllStringsStartWithCapitalLetter() {
        List<String> names = List.of("John", "Alice", "Bob");

        boolean isValid = names.stream().allMatch(s -> s.charAt(0) >= 'A' && s.charAt(0) <= 'Z');

        System.out.println("All strings starts with Capital " + isValid);
    }

    public static void flattenList() {
        List<List<String>> nested = List.of(List.of("a", "b"), List.of("c", "d"));

        nested.stream().flatMap(List::stream).forEach(System.out::println);
    }

    public static void frequencyOfChar() {
        String s = "banana";

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        map.entrySet().forEach(entry -> System.out.println("char " + entry.getKey() + " appeared " + entry.getValue() + " times."));
    }

    public static void getLongestStringFromList() {
        List<String> words = List.of("apple", "banana", "kiwi");

//        List<String> reversedSortedWords = words.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());

        List<String> sortedWords = words.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());

        System.out.println(sortedWords.get(sortedWords.size() - 1));
    }

    public static void partitionList() {

        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0)).entrySet().forEach(System.out::println);

    }

    public static void main(String[] args) {
//        countDuplicates();
//        groupWordsByLength();
//        secondHighestNo();
//        doesAllStringsStartWithCapitalLetter();
//        flattenList();
//        frequencyOfChar();
//        getLongestStringFromList();
        partitionList();
    }
}
