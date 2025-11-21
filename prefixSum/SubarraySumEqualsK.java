// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.*;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int k = 2;
        int result = subarraySum(nums, k);
        System.out.println("Number of Subarrays: " + result);
    }

    private static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1); 
        int prefixSum = 0;
        int count = 0;
        for(int n: nums){
            prefixSum+=n;
            int expectedPrefixSum = prefixSum - k;
            if(prefixSumCount.containsKey(expectedPrefixSum)){
                count+=prefixSumCount.get(expectedPrefixSum);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
