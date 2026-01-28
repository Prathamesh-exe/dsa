// https://leetcode.com/problems/jump-game/

public class JumpGame {
    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        System.out.println(canJump(nums1)); // true

        int[] nums2 = {3,2,1,0,4};
        System.out.println(canJump(nums2)); // false
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;

        for (int i = 0; i < n; i++) {
            // If the current index is beyond the farthest reachable index, return false
            if (i > maxJump) {
                return false;
            }
            // Update the farthest reachable index
            maxJump = Math.max(maxJump, i + nums[i]);
            // If we can reach or exceed the last index, return true
            if (maxJump >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
 //dry run for nums1 = [2,3,1,1,4]
 // i=0, maxJump=0 -> maxJump = max(0, 0+2) = 2
 // i=1, maxJump=2 -> maxJump = max(2, 1+3) = 4
 //i=2, maxJump=4 -> maxJump = max(4, 2+1) = 4
 //i=3, maxJump=4 -> maxJump = max(4, 3+1) = 4
 //i=4, maxJump=4 -> maxJump = max(4, 4+4) = 8
 // Since maxJump >= n-1 at i=1, return true

 //dry run for nums2 = [3,2,1,0,4]
 // i=0, maxJump=0 -> maxJump = max(0, 0+3) = 3
 // i=1, maxJump=3 -> maxJump = max(3, 1+2) = 3
 //i=2, maxJump=3 -> maxJump = max(3, 2+1) = 3
 //i=3, maxJump=3 -> maxJump = max(3, 3+0) = 3
 //i=4, maxJump=3 -> i > maxJump, return false