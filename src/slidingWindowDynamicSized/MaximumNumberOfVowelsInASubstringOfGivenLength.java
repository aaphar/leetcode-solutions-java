package slidingWindowDynamicSized;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 */

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    // Time complexity: O(n)
    // Space complexity: O(1)l
    public int maxVowels(String s, int k) {
        // 97, 101, 105, 111, 117
        int max = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            if (isVowel(s.charAt(right))) {
                count++;
            }
            if (right - left + 1 > k) {
                if (isVowel(s.charAt(left))) {
                    count--;
                }
                left++;
            }
            right++;
            max = Math.max(max, count);
        }
        return max;
    }

    boolean isVowel(char ch) {
        return ch == 97 || ch == 101 || ch == 105 || ch == 111 || ch == 117;
    }
}
