package august;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fruit-into-baskets/description
 */
public class FruitIntoBaskets {

    /**
     * Example 1:
     * <p>
     * Input: fruits = [1,2,1]
     * Output: 3
     * Explanation: We can pick from all 3 trees.
     * <p>
     * Example 2:
     * <p>
     * Input: fruits = [0,1,2,2]
     * Output: 3
     * Explanation: We can pick from trees [1,2,2].
     * If we had started at the first tree, we would only pick from trees [0,1].
     * <p>
     * Example 3:
     * <p>
     * Input: fruits = [1,2,3,2,2]
     * Output: 4
     * Explanation: We can pick from trees [2,3,2,2].
     * If we had started at the first tree, we would only pick from trees [1,2].
     *
     * @param fruits
     * @return
     */


    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        System.out.println(totalFruit(arr));
    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while (left <= right && right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() >= 3) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;

        }

        return max;

    }
}
