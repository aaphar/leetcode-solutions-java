package monotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/description/
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }

            stack.push(i);
        }
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums1.length; i++) {
            if (map.getOrDefault(nums1[i], -1) != -1) {
                ans[i] = map.get(nums1[i]);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}
