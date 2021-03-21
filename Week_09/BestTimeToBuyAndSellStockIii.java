package com.leetcode.editor.cn;

/**
 * Java：   [123]买卖股票的最佳时机 III
 **/


public class BestTimeToBuyAndSellStockIii {
    //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 693 👎 0

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
        // TO TEST
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(prices));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            int len = prices.length;
            int count = 3;
            int[][][] cache = new int[len][count][2];//日期、交易次数、持有情况
            for (int i = 1; i < count; i++) {//准备第一天基础数据
                cache[0][i][1] = -prices[0];//只要买了就扣除
            }
            for (int i = 1; i < len; i++) {
                for (int j = 1; j < count; j++) {
                    cache[i][j][0] = Math.max(cache[i - 1][j][0], cache[i - 1][j][1] + prices[i]);
                    cache[i][j][1] = Math.max(cache[i - 1][j][1], cache[i - 1][j - 1][0] - prices[i]);
                }
            }
            return Math.max(cache[len - 1][count - 1][0], cache[len - 1][count - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}