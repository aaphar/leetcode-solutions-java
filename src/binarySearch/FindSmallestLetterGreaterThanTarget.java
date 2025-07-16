package binarySearch;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetterBinarySearch(new char[]{'c', 'f', 'j'}, 'd'));
    }

    public static char nextGreatestLetterBinarySearch(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        char min = letters[letters.length - 1];
        boolean updated = false;
        for (int i = letters.length - 1; i >= 0; i--) {
            if (letters[i] > target) {
                min = (char) Math.min(letters[i], min);
                updated = true;
            }
        }


        return updated ? min : letters[0];
    }

}
