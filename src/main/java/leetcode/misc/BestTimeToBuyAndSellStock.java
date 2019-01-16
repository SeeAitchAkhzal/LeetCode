package leetcode.misc;

/**
 * Runtime: 1 ms, faster than 99.87% of Java online submissions for Best Time to Buy and Sell Stock.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int mProfit = 0;

        if (prices.length <= 1)
            return mProfit;

        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] - min > mProfit)
                mProfit = prices[i] - min;

            if (prices[i] < min) {
                min = prices[i];
            }
        }

        return mProfit;
    }

}
