package ProgrammingProblems.Streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class FindDuplicateCharactersInAString {

    private static void countCharacters(String str) {

        Map<String, Integer> map = new LinkedHashMap<>();

        Arrays.stream(str.split("")).forEach(c -> {
            map.put(c, map.getOrDefault(c, 0) + 1);
        });

        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
            System.out.println(String.format("%s occurred %d times", entry.getKey(), entry.getValue()));
        });
    }

    public static void main(String[] args) {
        countCharacters("programming");

    }
}
