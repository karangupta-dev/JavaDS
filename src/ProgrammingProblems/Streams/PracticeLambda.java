package ProgrammingProblems.Streams;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class PracticeLambda {

    public static void filterEventNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> evens = numbers.stream()
                .filter(number -> (number % 2) == 0) //  Use a Predicate<Integer> inside .filter()
                .collect(toList());

        System.out.println("Even numbers: " + evens); // Output: [2, 4, 6]
    }

    public static void customerUpperCase() {
        List<String> names = List.of("tom", "jerry", "bob");

        List<String> upperNames = names.stream()
                .map(String::toUpperCase) //Use a Function<String, String> inside .map()
                .toList(); // alternate of .collect(Collectors.toList())

        System.out.println("Uppercase: " + upperNames); // Output: [TOM, JERRY, BOB]
    }

    public static void printElements() {
        List<String> fruits = List.of("apple", "banana", "cherry");

        fruits.forEach(System.out::println); //Use a Consumer<String> inside .forEach()
    }

    public static void supplierFunction() {
        Supplier<Double> randomSupplier = Math::random;

        System.out.println("Random number: " + randomSupplier.get());
    }

    public static void chainLambdas() {
        Function<String, String> trimAndUpper =
                s -> s.trim().toUpperCase();

        // Test it
        System.out.println(trimAndUpper.apply("  hello ")); // Output: HELLO

    }

    public static void flattenList() {
        List<List<String>> names = List.of(
                List.of("Tom", "Jerry"),
                List.of("Spike", "Tyke")
        );

        names.stream().flatMap(List::stream).toList().forEach(System.out::println);// check how can i print along this

        System.out.println();

        Map<Character, List<String>> groupedByFirstLetter = names.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(s -> {
                    return s.charAt(0);
                }));

        System.out.println("Names grouped by first letter \n");

        System.out.println(groupedByFirstLetter.values());

    }

    public static void groupByFirstLetter() {
        List<String> words = List.of("apple", "banana", "apricot", "blueberry", "cherry");
        Map<Character, List<String>> groupedByFirstLetter = words.stream()
                .collect(Collectors.groupingBy(s -> {
                    return s.charAt(0);
                }));

//        System.out.println(groupedByFirstLetter.values());

        //        how to print hashmap with streams
        groupedByFirstLetter.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }

    public static void variationsOfReduce() {
        List<Integer> nums = List.of(3, 4, 5, 6);

        System.out.println("Minimum number in the list is: " + nums.stream().map(i -> i.floatValue()).reduce(0.5f, Float::min));
        System.out.println("Maximum number in the list is: " + nums.stream().reduce(0, Integer::max));

        System.out.println("Sum of all the numbers in the list is: " + nums.stream().reduce(0, Integer::sum));
        System.out.println("Product of all the numbers in the list is: " + nums.stream().reduce(1, Math::multiplyExact));
    }

    public static void reverseListOfNums() {

        List<Integer> nums = List.of(3, 4, 5, 6);

        List<Integer> reversed = nums.stream()
            .collect(collectingAndThen(toList(), list -> {
                Collections.reverse(list);
                return list;
            }));

        System.out.println(reversed);
    }

    class Inner{

        public Inner(){
            System.out.println("inner created");
        }

    }

    public void testOptional() {
        String name = "Alice";
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.orElse("")); // print correct value of name

        // print value of name but eagerly creates object of Inner
        System.out.println(opt.orElse(new Inner().toString()));

        // print value of name but lazily creates object of Inner only when name is null
        System.out.println(opt.orElseGet(() -> new Inner().toString()));


    }

    public static void main(String[] args) {
//        filterEventNumber();
//        customerUpperCase();
//        printElements();
//        supplierFunction();
//        chainLambdas();
//        flattenList();
//        groupByFirstLetter();
//        variationsOfReduce();
//        reverseListOfNums();

        PracticeLambda lmb = new PracticeLambda();
        lmb.testOptional();
    }
}
