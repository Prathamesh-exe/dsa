
import java.util.*;

// https://leetcode.com/problems/count-days-without-meetings/
// https://www.youtube.com/watch?v=VFYTULYpApM
public class CountDaysWithoutMeetings{
    public static void main(String[] args) {
        int[][] meetings = {{5,7},{1,3},{9,10}};
        int days = 10;
        int result = resultNotOptimized(days, meetings);
        int resultOptimized = resultOptimized(days, meetings);
        System.out.println("Not Optimized Result: " + result);
        System.out.println("Optimized Result: " + resultOptimized);}

    private static int resultNotOptimized(int days, int[][] meetings) {
       int[] set=new int[days+1];
       for(int[] meeting:meetings){
        for(int i=meeting[0];i<=meeting[1];i++){
            set[i]=1;
    }
         }
         int count=0;
         for(int i=1;i<=days;i++){
          if(set[i]==0){
                count++;
          }
         }
         return count;
     }

    private static int resultOptimized(int days, int[][] meetings) {
         Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
         int previousEnd = 0;
         for(int[] meeting:meetings){
            int currentStart = meeting[0];
            int currentEnd = meeting[1];            

            int effectiveStart = Math.max(currentStart, previousEnd + 1);

            int meetingLength = Math.max(0, currentEnd - effectiveStart + 1);

            days -= meetingLength;

            previousEnd = Math.max(previousEnd, currentEnd);
         }
         return days;
    }
}