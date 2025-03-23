/**
 * https://leetcode.com/problems/ransom-note/description
 */
public class RansomNote {

    // Time complexity: O(n + m) where n is the length of the ransom note and m is the length of the magazine
    // Space complexity: O(1)
    // Approach: Count the number of each character in the magazine and then check if the ransom note can be constructed
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];

        for (char c : magazine.toCharArray()) {
            alphabet[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (alphabet[c - 'a'] == 0) {
                return false;
            }
            alphabet[c - 'a']--;
        }
        return true;
    }


    // One for loop solution
    // Approach: For each character in the ransom note, find the index of the character in the magazine starting from the last index of the character in the magazine
    // Time complexity: O(n) where n is the length of the ransom note
    // Space complexity: O(1)
    public boolean canConstructWithOneForLoop(String ransomNote, String magazine) {
        int[] alphabet = new int[26];

        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, alphabet[c % 26]);
            if (i == -1) {
                return false;
            }

            alphabet[c % 26] = i + 1;

        }

        return true;

    }
}
