package prefixSumPattern;

/**
 * https://leetcode.com/problems/find-the-highest-altitude
 */
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int prev = 0;
        for (int i = 0; i < gain.length; i++) {
            prev = gain[i] + prev;
            if (max < prev) {
                max = prev;
            }
        }

        return max;
    }

    // slover
    public int largestAltitudeSlower(int[] gain) {
        int[] altitudes = new int[gain.length + 1];
        altitudes[0] = 0;

        for (int i = 0; i < gain.length; i++) {
            altitudes[i + 1] = gain[i] + altitudes[i];
        }

        return max(altitudes);
    }

    public int max(int[] gain) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < gain.length; i++) {
            System.out.println(gain[i]);
            if (gain[i] > max) {
                max = gain[i];
            }
        }
        return max;
    }

}