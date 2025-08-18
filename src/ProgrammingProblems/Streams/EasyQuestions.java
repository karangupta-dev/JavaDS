package ProgrammingProblems.Streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class EasyQuestions {

    public static void filterEvenNumber() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        nums.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    public static void convertToUpperCase() {
        List<String> names = List.of("alice", "bob");
        names.stream().map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public static void sumOfAllNums() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    public static void removeDuplicates() {
        List<Integer> nums = List.of(1, 2, 2, 3, 3, 3);
        nums.stream().distinct().forEach(System.out::println);
    }

    public static void sortListOfString() {
        List<String> list = List.of("banana", "apple", "cherry");

        list.stream().sorted().forEach(System.out::println);
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    public static void startsWithNAlphabet() {
        List<String> list = List.of("Tom", "Jerry", "Alice");
        list.stream().filter(s -> s.toUpperCase().startsWith("A")).forEach(System.out::println);
    }

    public static void doubleUp() {
        int n = 2;
        for (int i = 0; i < 7; i++) {
            System.out.println(n);
            n *= 2;
        }
    }

    public static void main(String[] args) {
//        filterEvenNumber();
//        convertToUpperCase();
//        sumOfAllNums();
//        removeDuplicates();
//        sortListOfString();
//        startsWithNAlphabet();
//        doubleUp();
    }

}
