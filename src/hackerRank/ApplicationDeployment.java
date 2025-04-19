package hackerRank;

import java.util.List;

/**
 * explanationWithImages/ApplicationDeployment.png
 */
public class ApplicationDeployment {
    // TODO
    public static int getMinVulnerability(List<Integer> vulnerability, int k) {
        int low = 1;
        int high = (int) 1e9;
        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSelect(vulnerability, k, mid)) {
                answer = mid;  // Try to lower the maximum
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    // Can we choose k non-adjacent elements ≤ maxAllowed?
    private static boolean canSelect(List<Integer> v, int k, int maxAllowed) {
        int count = 0;
        int i = 0;

        while (i < v.size()) {
            if (v.get(i) <= maxAllowed) {
                count++;
                i += 2; // skip adjacent element
            } else {
                i += 1;
            }
        }

        return count >= k;
    }

}
