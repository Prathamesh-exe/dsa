import java.util.*;

public class MergeKSortedArraysInOne {
    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        int[] mergedArray = mergeKSortedArrays(arrays);
        System.out.println(Arrays.toString(mergedArray));
    }

    private static int[] mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] array : arrays) {
            for (int num : array) {
                minHeap.add(num);
            }
        }
        int totalSize = 0;
        for (int[] array : arrays) {
            totalSize += array.length;
        }
        int[] result = new int[totalSize];
        for (int i = 0; i < totalSize; i++) {
            result[i] = minHeap.remove();
        }
        return result;
    }
}
