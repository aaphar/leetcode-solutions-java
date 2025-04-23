package slidingWindowDynamicSized;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description
 */
public class LongestSubarrayOf1AfterDeletingOneElement {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 1, 1, 0, 1};
        System.out.println(longestSubarrayB(arr));
    }

    public static int longestSubarrayB(int[] nums) {
        int curr = 0, prev = 0, ans = 0, zeros = 0;
        for (int n : nums) {
            if (n == 0) {
                zeros++;
                ans = Math.max(ans, curr + prev);
                prev = curr;
                curr = 0;
            } else {
                curr++;
            }
        }
        ans = Math.max(ans, curr + prev);
        return (zeros == 0) ? ans - 1 : ans;
    }

    public static int longestSubarray(int[] nums) {
        int max = 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int countOfZero = 0;
        boolean foundZero = false;
        while (r < n) {
            if (nums[r] == 0) {
                ++countOfZero;
                foundZero = true;
            }
            while (countOfZero > 1) {
                if (nums[l] == 0) {
                    countOfZero--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1 - countOfZero);

            r++;
        }
        return foundZero ? max : max - 1;
    }
}
