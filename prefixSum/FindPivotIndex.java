// https://leetcode.com/problems/find-pivot-index/

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int result = pivotIndex(nums);
        System.out.println("Pivot Index: " + result);
    }

    private static int pivotIndex(int[] nums) {
       int totalSum=0;
       for(int num: nums){
        totalSum+=num;
       }
       int leftSum=0;
       for(int i=0;i<nums.length;i++){
         int rightSum=totalSum-leftSum-nums[i];
         if(leftSum==rightSum){
            return i;
         }
         leftSum+=nums[i];
       }
       return -1;
    }
}
