package august;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/fruits-into-baskets-iii/description
 */
public class FruitsIntoBasketsIII {
    public static void main(String[] args) {
        int[] fruits = {4, 2, 5};
        int[] baskets = {3, 5, 4};
        System.out.println(numOfUnplacedFruits(fruits, baskets));
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        Arrays.sort(baskets);

        int index = 0;
        for (int i = 0; i < fruits.length; i++) {
            int left = index, end = baskets.length;

            while (left < end) {
                int mid = left + (end - left) / 2;

                if (baskets[mid] >= fruits[i]) {
                    baskets[mid] = 0;
                    int temp = baskets[index];
                    baskets[index] = baskets[mid];
                    baskets[mid] = temp;
                    index++;
                    break;
                } else if (baskets[mid] > fruits[i]) {
                    end = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return fruits.length - index;
    }
}
