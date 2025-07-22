package binarySearch;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};

        successfulPairs(spells, potions, 16);
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int start = 0, end = m - 1;
            long target = success / spells[i];
            if (success % spells[i] != 0) {
                target++;
            }

            while (start < end) {
                int mid = start + (end - start) / 2;
                if (potions[mid] >= target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            if (result[i] == 0 && potions[start] >= target) {
                result[i] = m - start;
            }
        }

        return result;
    }
}
