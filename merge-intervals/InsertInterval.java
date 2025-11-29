// https://leetcode.com/problems/insert-interval/

import java.util.*;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] resultNotOptimized = insertNotOptimized(mergeArrays(intervals, newInterval));
        for (int[] interval : resultNotOptimized) {
            System.out.println(Arrays.toString(interval));
        }

        int[][] resultOptimized = insertOptimized(intervals, newInterval);
        for (int[] interval : resultOptimized) {
            System.out.println(Arrays.toString(interval));
    }
}

    public static int[][] insertOptimized(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        // Add all intervals ending before newInterval starts (0=start,1=end)
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        // Add remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

 

    public static int[][] insertNotOptimized(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] current : intervals) {
            if (current[0] <= newInterval[1]) {//0=start,1=end
                newInterval[1] = Math.max(newInterval[1], current[1]);
            } else {
                newInterval = current;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);

    }

       public static int[][] mergeArrays(int[][] intervals, int[] newInterval) {
        int[][] merged = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, merged, 0, intervals.length);
        merged[intervals.length] = newInterval;
        return merged;
    }
}
