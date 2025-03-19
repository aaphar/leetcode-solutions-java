package slidingWindowFixedSized;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 */
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = {7,4,5,8,8,3,9,8,7,6};
        System.out.println(findMaxAverage(nums, 7));
    }

    public static double findMaxAverage(int[] nums, int k) {
        // Prefix sum
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        double maxAverage = (double) nums[k - 1] / k;
        int index = 0;
        // sliding window technique
        for (int i = k; i < nums.length; i++) {
            double average = (double) (nums[i] - nums[index]) / k;
            if (average > maxAverage) {
                maxAverage = average;
            }
            index++;
        }
        return maxAverage;
    }
}

/**
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */