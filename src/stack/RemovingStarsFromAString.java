package stack;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/description
 */
public class RemovingStarsFromAString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStarsB(s));
    }

    public static String removeStarsB(String s) {
        var arr = s.toCharArray();
        int offset = 0;
        for (int i = 0; i < arr.length; ++i) {
            var c = arr[i];
            if (c == '*') --offset;
            else {
                arr[offset] = c;
                ++offset;
            }
        }

        return new String(arr, 0, offset);
    }

    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                sb.deleteCharAt(j);
                sb.deleteCharAt(j - 1);
                j--;
            } else {
                j++;
            }
        }

        return sb.toString();
    }

}
