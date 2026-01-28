// https://leetcode.com/problems/jump-game-ii/description/

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        System.out.println(jump(nums1)); // 2
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0; // No jumps needed if array has 1 or no elements

        int jumps = 0;      // Number of jumps made
        int currentEnd = 0; // Farthest point reachable with the current number of jumps
        int maxJump = 0;   // Farthest point reachable with one more jump

        for (int i = 0; i < n - 1; i++) {  //n-1 because we don't need to jump from the last index
            // Update the farthest point reachable
            maxJump = Math.max(maxJump, i + nums[i]);
            // If we have reached the end of the current jump
            if (i == currentEnd) {
                jumps++;               // Make a jump
                currentEnd = maxJump; // Update the end to the farthest point reached
                // If we can reach or exceed the last index, break early
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}

//dry run for nums1 = [2,3,1,1,4]
// i=0, maxJump=0, currentEnd=0 -> maxJump = max(0, 0+2) = 2
// i=0 == currentEnd -> jumps=1, currentEnd=2
// i=1, maxJump=2 -> maxJump = max(2, 1+3) = 4
// i=2, maxJump=4 -> maxJump = max(4, 2+1) = 4
// i=2 == currentEnd -> jumps=2, currentEnd=4
// Since currentEnd >= n-1, break and return jumps=2    
