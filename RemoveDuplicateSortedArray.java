
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int uniqueElements = removeDuplicates(nums);
        System.out.print("\nNumber of unique elements : " + uniqueElements);
        int uniqueElements2 = removeDuplicates2(nums);
        System.out.print("\nNumber of unique elements : " + uniqueElements2);

    }

    public static int removeDuplicates(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeDuplicates2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return set.size();
    }

}
