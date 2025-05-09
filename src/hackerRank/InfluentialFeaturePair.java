package hackerRank;

import java.util.List;

public class InfluentialFeaturePair {
    public static long getMaximumScore(List<Integer> score) {
        // Write your code here
        int right = score.size() - 1;
        int left = 0;
        long maxArea = 0;

        while (left <= right) {
            int width = right - left;
            int minHeight = Math.min(score.get(right), score.get(left));
            long area = (long) width * minHeight;
            maxArea = Math.max(area, maxArea);
            if (score.get(right) > score.get(left)) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}
