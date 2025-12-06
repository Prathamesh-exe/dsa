// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 3;
        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int pivot=findPivot(nums);
        if(pivot==0){
            return binarySearch(nums,target,0,nums.length-1);
    }
        if(nums[pivot]==target){
            return pivot;
        }
        if(target>=nums[0]){
            return binarySearch(nums,target,0,pivot-1);
        }
        return binarySearch(nums,target,pivot+1,nums.length-1);
    }

    private static int findPivot(int[]nums){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[end]){
                start=mid+1;
            }else{
                end=mid;
            }
    }
        return start;
    }

    private static int binarySearch(int[] nums,int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
