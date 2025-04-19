package hackerRank;

import java.util.Collections;
import java.util.List;

/**
 * explanationWithImages/CrossTheThreshold.png
 */
public class CrossTheThreshold {
    public static int getMaxBarrier(List<Integer> initialEnergy, long th) {
        // Write your code here
        int left = 0;
        int right = Collections.max(initialEnergy);
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long total = 0;
            for (int energy : initialEnergy) {
                total += Math.max(0, energy - mid);
                if (total >= th) break;
            }

            if (total >= th) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

}
