package slidingWindowDynamicSized;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

    }

    /**
     * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
     * In one operation, you can choose any character of the string and change it to any other uppercase English character.
     * You can perform this operation at most k times in total.
     * Find the length of the longest substring containing the same letter you can get after performing at most k operations.
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int maxi = 0; // Final answer
        int n = s.length();
        int[] arr = new int[26]; // Frequency of characters in current window
        int l = 0, r = 0; // Sliding window pointers
        int maxiFreq = 0; // Frequency of the most common character in current window
        while (r < n) {
            arr[s.charAt(r) - 'A']++; // Add current character to frequency array
            maxiFreq = Math.max(maxiFreq, arr[s.charAt(r) - 'A']); // Update max frequency

            // If (window size - maxFreq) > k, we can't fix all other chars with k changes
            while ((r - l + 1) - maxiFreq > k) {
                arr[s.charAt(l) - 'A']--; // Shrink window from left
                l++;
            }

            // Update the max length of valid window
            maxi = Math.max(maxi, (r - l + 1));
            r++; // Expand window to the right
        }
        return maxi; // Return the maximum length of valid window
    }
}
