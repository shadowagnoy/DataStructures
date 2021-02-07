package cn.jsledd.leetcode.array;

/**
 * @version 1.0
 * @ClassName : BestTimeToBuyAndSellStock_ii
 * @Description : 122. 买卖股票的最佳时机 II
 * @Author : JSLEDD
 * @Date: 2021-02-05 09:02
 */
public class BestTimeToBuyAndSellStock_ii {
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4,9};
        int i = new BestTimeToBuyAndSellStock_ii().maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int buyprice = -1;
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            //判断是不是要买入,如果第二天的价格要更高，并且手中没有股票
            if (prices[i] < prices[i + 1]) {
                if (buyprice == -1) buyprice = prices[i];
            } else {
                if (buyprice != -1) {
                    sum = sum + prices[i] - buyprice;
                    buyprice = -1;
                }
            }
            //判断是不是要卖
        }
        if (buyprice != -1) {
            sum = sum + prices[prices.length - 1] - buyprice;
        }
        return sum;
    }
}
