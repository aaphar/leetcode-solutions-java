package sorting.counting;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColor {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num] += 1;
        }

        int startingIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int[] sorted = new int[nums.length];
        for (int num : nums) {
            sorted[counts[num]] = num;
            counts[num] += 1;
        }

        for (int i = 0; i < sorted.length; i++) {
            nums[i] = sorted[i];
        }

    }
}
