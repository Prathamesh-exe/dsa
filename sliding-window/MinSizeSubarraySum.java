// https://leetcode.com/problems/minimum-size-subarray-sum/

public class MinSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        int result = minSubArrayLen(target, nums);
        System.out.println("Minimum size of subarray with sum >= " + target + ": " + result);
    }

    public static int minSubArrayLen(int target, int[] nums) {

          int left=0; 
          int right=0;
          int minLength=Integer.MAX_VALUE;
          int sum=0;

          while(right<nums.length){
            sum+=nums[right];

            //shrink window till sum>=target
            while(sum>=target){
             minLength=Math.min(minLength, right-left+1);
             sum-=nums[left];
             left++;                
            }
            right++;
          }
          return minLength==Integer.MAX_VALUE ? 0 : minLength;
    }
}
