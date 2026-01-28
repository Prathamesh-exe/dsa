import java.util.*;

public class SortByFrequency {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 6, 4, 4, 3, 2, 2, 2};
        int[] sortedArr = sortByFrequency(arr);
        System.out.println(Arrays.toString(sortedArr));
                System.out.println(Arrays.toString(sortedArr));

    }

    private static int[] sortByFrequency(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        System.out.println("entry list -> "+entryList);
        // Sort entries by frequency in descending order
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println("sorted entry list -> "+entryList);

        List<Integer> resultList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : entryList) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                resultList.add(entry.getKey());
            }
        }

        // Convert List back to array
        int[] sortedArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            sortedArr[i] = resultList.get(i);
        }
        return sortedArr;
    }

    private static int[] sortByFrequencyBucketSort(int[] arr) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : arr) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    // Buckets: index = frequency
    List<Integer>[] buckets = new List[arr.length + 1];
    for (int i = 0; i <= arr.length; i++) {
        buckets[i] = new ArrayList<>();
    }

    for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
        buckets[e.getValue()].add(e.getKey());
    }

    int[] result = new int[arr.length];
    int idx = 0;

    for (int f = arr.length; f >= 1; f--) {
        for (int num : buckets[f]) {
            for (int i = 0; i < f; i++) {
                result[idx++] = num;
            }
        }
    }
    return result;
}

}
