package DataStructures.Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

    private static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>(); // or new ArrayList<>(Arrays.asList(intervals));
        Collections.addAll(result, intervals);

        result.add(newInterval);

        result.sort((a, b) -> Integer.compare(a[0], b[0]));

        return result.toArray(new int[result.size()][]);
    }

    private static int[][] merged(int[][] intervals) {

        if (intervals.length == 0) return new int[0][];

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = result.get(result.size() - 1);

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] result = insert(intervals, newInterval);
        int[][] withMergedIntervals = merged(result);
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }

        System.out.println("\n After merging the intervals: ");
        for (int[] interval : withMergedIntervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }
}
