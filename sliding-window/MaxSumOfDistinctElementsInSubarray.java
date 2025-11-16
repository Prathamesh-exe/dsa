// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/

import java.util.*;

public class MaxSumOfDistinctElementsInSubarray {
    public static long maximumSubarraySum(int[] nums, int k) {
        int i=0; int j=0;
        Set<Integer> set=new HashSet<>();
        long maxSum=0; long currSum=0;
        
        while(j<nums.length){
            //check duplicate
            while(set.contains(nums[j])){
                currSum-=nums[i];
                set.remove(nums[i]);
                i++;
            }

            //if not duplicate calculate sum
            currSum+=nums[j];
            set.add(nums[j]);

            //if window==k
            if(j-i+1==k){
                maxSum=Math.max(maxSum,currSum);
                currSum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;

        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,1,4,5};
        int k = 3;
        long result = maximumSubarraySum(nums, k);
        System.out.println("Maximum sum of distinct elements in subarrays of size " + k + ": " + result);
    }
}

