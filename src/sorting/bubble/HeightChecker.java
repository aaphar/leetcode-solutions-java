package sorting.bubble;

/**
 * https://leetcode.com/problems/height-checker/description/
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] arr = heights.clone();

        bubbleSort(heights);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != heights[i]) {
                count++;
            }
        }

        return count;
    }

    private static void bubbleSort(int[] heights) {
        boolean hasSwapped = true;

        while (hasSwapped) {
            hasSwapped = false;

            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    hasSwapped = true;
                }
            }
        }
    }
}
