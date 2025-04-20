import java.util.Objects;

/**
 * https://leetcode.com/problems/calculate-score-after-performing-instructions/description/
 */
public class CalculateScoreAfterPerformingInstructions {
    public static void main(String[] args) {
        String[] instructions = {"jump", "jump", "add", "jump", "add", "add", "add", "jump", "add", "jump", "add", "add", "add", "jump", "jump", "add", "add", "jump", "add", "add", "add", "jump", "add", "add", "add", "add", "add", "jump", "add", "jump", "jump", "jump", "add", "jump", "jump", "jump", "add", "jump", "add", "jump", "jump", "jump", "jump", "jump", "jump", "add", "add", "add", "add", "add", "add", "jump", "jump", "jump", "add", "add"};
        int[] values = {12, 18, -33551, 4, 70707, 20722, -22225, 23, -56668, -8, -7875, 21146, 26804, 17, 1, -13898, 80265, 22, -10903, 38444, -69303, 17, 85973, -94700, -93741, 56346, 25785, -22, 21628, 12, -31893, 70229, -78933, -14, 20952, 28335, -78481, 7, 33449, -17, -27011, -23, -29791, 71663, -18, 38373, 48282, 611, -65558, 76770, 49926, 94315, -27, -3, 14623, -67134};
        System.out.println(calculateScore(instructions, values));

    }

    public static long calculateScore(String[] instructions, int[] values) {
        int n = instructions.length;
        boolean[] visited = new boolean[n];
        int i = 0;
        long score = 0;
        while (i < n && i >= 0) {
            if (visited[i]) {
                break;
            }
            visited[i] = true;

            if (Objects.equals(instructions[i], "add")) {
                score += values[i];
                i++;
            } else if (Objects.equals(instructions[i], "jump")) {
                i = i + values[i];
            }
        }
        return score;
    }
}
