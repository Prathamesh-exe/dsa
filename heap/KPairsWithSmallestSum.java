// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
import java.util.*;

public class KPairsWithSmallestSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = kSmallestPairs(nums1, nums2, k);
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        // Min-heap to store pairs based on their sums(sum, index in nums1, index in nums2)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] , b[0] )
        );
        
        // Initialize the min-heap with pairs from both arrays
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!minHeap.isEmpty() && result.size() < k) {
            int[] currentPair = minHeap.remove();
            int sum = currentPair[0];
            int index1 = currentPair[1];
            int index2 = currentPair[2];
            
            result.add(Arrays.asList(nums1[index1], nums2[index2]));
            // If there's a next element in nums2, add the new pair to the heap
            if (index2 + 1 < nums2.length) {
                minHeap.add(new int[]{
                    nums1[index1] + nums2[index2 + 1],
                    index1,
                    index2 + 1
                });
            }
        }
        return result;
        
    }
}
