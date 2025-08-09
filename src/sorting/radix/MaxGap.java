package sorting.radix;

/**
 * https://leetcode.com/problems/maximum-gap/
 */
public class MaxGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int place = 1;

        while (max / place > 0) {
            countingSort(nums, place);
            place *= 10;
        }

        int maxGap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1];
            if (gap > maxGap) {
                maxGap = gap;
            }
        }

        return maxGap;

    }

    public void countingSort(int[] arr, int place) {
        int[] counts = new int[10];

        for (int i : arr) {
            int curr = i / place;
            counts[curr / 10] += 1;
        }

        int startIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = startIndex;
            startIndex += count;
        }


        int[] sortedArr = new int[arr.length];
        for (int i : arr) {
            int curr = i / place;
            sortedArr[counts[curr / 10]] = i;
            counts[curr / 10] += 1;
        }

        for (int i = 0; i < sortedArr.length; i++) {
            arr[i] = sortedArr[i];
        }
    }
}
