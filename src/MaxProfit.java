/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 3, 5, 1, 6, 4};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        for (int price : prices) {
            if (price < buy) {
                buy = price;
            } else if (price - buy > profit) {
                profit = price - buy;
            }
        }

        return profit;
    }
}
