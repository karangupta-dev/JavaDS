package ProgrammingProblems.Streams;

import java.util.*;

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

}
