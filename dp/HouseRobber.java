// https://leetcode.com/problems/house-robber/

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(robTopDown(nums1)); // Output: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(robTopDown(nums2)); // Output: 12


        System.out.println(robBottomUp(nums1)); // Output: 4
        System.out.println(robBottomUp(nums2)); // Output: 12

        System.out.println(robSpaceOptimized(nums1)); // Output: 4
        System.out.println(robSpaceOptimized(nums2)); // Output: 12
    }

    private static int robTopDown(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 0) {
            return 0;
        }
        return robHelperTopDown(nums, 0, dp);
    }

    private static int robHelperTopDown(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        // Choose to rob the current house and skip the next one
        int robCurrent = nums[index] + robHelperTopDown(nums, index + 2, dp);
        // Choose not to rob the current house and move to the next one
        int skipCurrent = robHelperTopDown(nums, index + 1, dp);

        dp[index] = Math.max(robCurrent, skipCurrent);
        return dp[index];
    }

    private static int robBottomUp(int[] nums) {
        int n = nums.length;
        
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        // Base cases 
        dp[0] = nums[0];// First house
        dp[1] = Math.max(nums[0], nums[1]);// Max of first two houses

        // Fill the dp array
        for (int i = 2; i < n; i++) {
            // Either skip the current house(dp[i-1]) or rob it and add to the total from two houses back(dp[i-2])
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        // The last element contains the maximum amount that can be robbed
        return dp[n - 1];
    }

     private static int robSpaceOptimized(int[] nums) {
        int n = nums.length;
        
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int prev2 = 0; // Max amount that can be robbed up to house i-2
        int prev1 = nums[0]; // Max amount that can be robbed up to house i-1
        
        for (int i = 1; i < n; i++) {
            // Calculate the maximum amount that can be robbed up to the current house
            int current = Math.max(prev1, nums[i] + prev2); // prev1: skip current, nums[i] + prev2: rob current
            // Update prev2 and prev1 for the next iteration
            prev2 = prev1;
            prev1 = current;
        }
        // prev1 now contains the maximum amount that can be robbed
        return prev1;   
    }

}