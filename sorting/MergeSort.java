import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        arr = mergeSort(arr);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        
            int mid = arr.length / 2;

            // Sort first and second halves
           int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
           int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

            // Merge the sorted halves
           return merge(left, right);
        
    }
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Merge the two arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copy remaining elements of left array, if any
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Copy remaining elements of right array, if any
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

}
