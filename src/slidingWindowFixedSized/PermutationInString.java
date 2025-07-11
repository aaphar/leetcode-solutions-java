package slidingWindowFixedSized;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public static void main(String[] args) {
        String s2 = "ab";
        String s1 = "ab";
        System.out.println(checkInclusion(s1, s2));
    }

    // TODO

    public static boolean checkInclusion(String s1, String s2) {
        int s1l = s1.length();
        int s2l = s2.length();

        if (s2l < s1l) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s1l; i++) {
            arr1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2l; i++) {
            arr2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2l - s1l + 1; i++) {
            int index = i;
            while (index < s1l + i) {
                int ch = s2.charAt(index) - 'a';
                if (arr2[ch] != 0 && arr1[ch] != 0) {
                    if (index == s1l + i - 1) {
                        return true;
                    }
                    index++;
                } else {
                    break;
                }
            }
        }

        return false;
    }

//    public static boolean checkInclusion(String s1, String s2) {
//        if (s1.length() > s2.length()) {
//            return false;
//        }
//        int[] s1arr = new int[26];
//        int[] s2arr = new int[26];
//        for (int i = 0; i < s1.length(); i++) {
//            s1arr[s1.charAt(i) - 'a']++;
//            s2arr[s2.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < s2.length() - s1.length(); i++) {
//            if (matches(s1arr, s2arr)) {
//                return true;
//            }
//            s2arr[s2.charAt(i + s1.length()) - 'a']++;
//            s2arr[s2.charAt(i) - 'a']--;
//        }
//
//        return matches(s1arr, s2arr);
//    }

    public static boolean matches(int[] s1arr, int[] s2arr) {
        for (int i = 0; i < 26; i++) {
            if (s1arr[i] != s2arr[i]) {
                return false;
            }
        }
        return true;
    }
}

// salam // sa
