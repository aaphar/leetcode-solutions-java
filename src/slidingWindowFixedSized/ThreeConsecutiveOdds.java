package slidingWindowFixedSized;

/**
 * https://leetcode.com/problems/three-consecutive-odds/description
 */
public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
    }

    //	•	Time Complexity: O(n)
    //	•	Space Complexity: O(1)
    public static boolean threeConsecutiveOdds(int[] arr) {
        int start = 0;

        while (start < arr.length - 2) {
            int count = 0;
            while (count < 3) {
                if (arr[start + count] % 2 != 0) {
                    count++;
                } else {
                    break;
                }

                if (count == 3) {
                    return true;
                }

            }
            start++;
        }

        return false;
    }
}
