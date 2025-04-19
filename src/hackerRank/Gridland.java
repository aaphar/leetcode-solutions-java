package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * explanationWithImages/Gridland.png
 */

public class Gridland {
    // TODO
    public static List<String> getSafePaths(List<String> journeys) {
        // Write your code here
        List<String> result = new ArrayList<>();

        for (String journey : journeys) {
            String[] parts = journey.split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int k = Integer.parseInt(parts[2]);

            result.add(findKthPath(x, y, k));
        }

        return result;
    }

    private static String findKthPath(int hCount, int vCount, int k) {
        StringBuilder path = new StringBuilder();

        while (hCount > 0 || vCount > 0) {
            if (hCount == 0) {
                path.append('V');
                vCount--;
            } else if (vCount == 0) {
                path.append('H');
                hCount--;
            } else {
                long withHFirst = comb(hCount + vCount - 1, hCount - 1);
                if (k < withHFirst) {
                    path.append('H');
                    hCount--;
                } else {
                    path.append('V');
                    vCount--;
                    k -= withHFirst;
                }
            }
        }

        return path.toString();
    }

    static long[] fact = new long[21];

    static {
        fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }

    private static long comb(int n, int k) {
        if (k > n) return 0;
        return fact[n] / (fact[k] * fact[n - k]);
    }
}
