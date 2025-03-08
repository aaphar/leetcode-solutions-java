/**
 * MaxProfitII
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxProfitII {
    public static void main(String[] args) {
        int[] prices = {7, 3, 5, 1, 6, 4};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }
}
