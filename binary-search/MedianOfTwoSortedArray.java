// https://leetcode.com/problems/median-of-two-sorted-arrays/

public class MedianOfTwoSortedArray{
    public static void main(String[] args){
        int[] nums1 = {1, 3};
        int[] nums2 = {2,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        
    }

    private static double  findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] merged = new int[m+n];
        int i=0, j=0, k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                merged[k]=nums1[i];
                i++;
            } else {
                merged[k]=nums2[j];
                j++;    
            }
            k++;
        }
        while(i<m){
            merged[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            merged[k]=nums2[j];
            j++;
            k++;
        }
        int totalLength = m+n;
        if(totalLength%2==0){
            return (merged[totalLength/2 - 1] + merged[totalLength/2]) / 2.0;
        } else {
            return merged[totalLength/2];   
    }
    
}
}