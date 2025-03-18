package twoPointersApproach;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    /**
     * explanationWithImages/ContainerWithMostWater.png
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     * In this case, the max area of water (blue section) the container can contain is 49.
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int maxArea = 0;

        while (left <= right) {
            int width = right - left;
            int minHeight = Math.min(height[right], height[left]);
            int area = width * minHeight;
            maxArea = Math.max(area, maxArea);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}
