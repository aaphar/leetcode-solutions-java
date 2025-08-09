package august;

/**
 * https://leetcode.com/problems/fruits-into-baskets-ii/description
 */
public class FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
//        Input: fruits = [4,2,5], baskets = [3,5,4]
        int count = fruits.length;

        for (int i = 0; i < fruits.length; i++) {
            int index = 0;
            while (index < baskets.length && baskets[index] < fruits[i]) {
                index++;
            }

            if (baskets[index] >= fruits[i]) {
                baskets[index] = 0;
                count--;
            }
        }

        return count;

    }

}
