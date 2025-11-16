public class MaxSubarraySum {

    public static void main(String[] args) {
        int[] nums = {6, 6,2, 3, 4, 5};
        int maxSum = maxSubArrayLength3(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }

   private static int maxSubArrayLength3(int[] nums) {
    int windowSize = 3;

    if (nums.length < windowSize) {
        return 0; // Not enough elements for one window
    }

    // Step 1: Calculate first window sum
    int sum = 0;
    for (int i = 0; i < windowSize; i++) {
        sum += nums[i];
    }

    int max = sum;

    // Step 2: Slide the window
    for (int i = windowSize; i < nums.length; i++) {
        sum += nums[i] - nums[i - windowSize]; // add new, remove old
        max = Math.max(max, sum);
    }

    return max;
}


}
