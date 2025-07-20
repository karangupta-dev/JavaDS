package ProgrammingProblems.Streams;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class TopN_FrequentWords {

    public void printTopNFrequentWords(String str, int n) {
        if (Objects.isNull(str) || str.trim().isEmpty()) {
            System.out.println("Invalid input.");
            return;
        }

        Map<String, Integer> map = new HashMap<>();
        List<String> listOfStrings = List.of(str.split(" "));

        for (String s : listOfStrings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(n)
                .forEach(entry -> System.out.println(entry.getKey() + "->" + entry.getValue()));

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a sentence: ");
        String s = input.nextLine();

        System.out.println("Enter the number of keywords you want to count: ");
        int n = input.nextInt();

        TopN_FrequentWords topN_FrequentWords = new TopN_FrequentWords();
        topN_FrequentWords.printTopNFrequentWords(s, n);

    }

}
