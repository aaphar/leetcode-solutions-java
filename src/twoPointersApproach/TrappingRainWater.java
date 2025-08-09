package twoPointersApproach;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int l = height.length;

        int[] leftMax = new int[l];
        leftMax[0] = height[0];
        int[] rightMax = new int[l];
        rightMax[0] = height[l - 1];

        for (int i = 1; i < l; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = l - 1; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        //water[i] = min(leftMax[i], rightMax[i]) - height[i]

        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return sum;
    }
}
