package binarySearch;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        int ans = right;

        // left, right binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            long calcH = calculate(mid, piles);
            if (calcH <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private static long calculate(int mid, int[] arr) {
        long hours = 0;
        for (int pile : arr) {
            hours += pile / mid;
            if (pile % mid != 0) {
                hours++;
            }
        }
        return hours;
    }


    // 1-3
    // 2-4
    // 3-2
    // 4-4
    // 5-3
    // 6-4
    // 7-4
    // 8-3

    // l=4, h=8, min=1, max=11

    // piles[i]/k<=1 -> +1
}
