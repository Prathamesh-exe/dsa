// https://leetcode.com/problems/merge-intervals/
import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));

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
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = new MergeIntervals().merge(intervals);    
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }   
    }
}