/**
 * https://leetcode.com/problems/second-largest-digit-in-a-string/
 */
public class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        int firstLargeNo = -1;
        int secondLargeNo = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                if (num > firstLargeNo) {
                    secondLargeNo = firstLargeNo;
                    firstLargeNo = num;
                } else if (num > secondLargeNo && num != firstLargeNo) {
                    secondLargeNo = num;
                }
            }
        }

        return secondLargeNo;
    }

    /**
     * •	'0' is the character '0' in ASCII (which has a value of 48).
     * •	When you subtract '0' from s.charAt(i), you convert the character digit to its integer value.
     * •	For example, if s.charAt(i) = '5':
     * int num = '5' - '0'; // 53 - 48 = 5
     * This works because in ASCII, digits '0' to '9' are sequentially ordered ('0' = 48, '1' = 49, …, '9' = 57).
     *
     * @param s
     * @return
     */

    public int secondHighestBestApproach(String s) {
        int count = 1;
        for (char c = '9'; c >= '0'; c--) {
            if (s.indexOf(c) != -1) {
                if (count-- <= 0) {
                    return c - '0';
                }
            }
        }
        return -1;
    }
}
