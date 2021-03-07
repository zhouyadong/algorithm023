package com.leetcode.editor.cn;

/**
 * Java：   [309]最佳买卖股票时机含冷冻期
 **/


public class BestTimeToBuyAndSellStockWithCooldown {
    //给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 694 👎 0

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //持有状态就分为：未持有、持有、卖出未持有
        public int maxProfit1(int[] prices) {

            int len = prices.length;
            int cache[][] = new int[len][3];//第n天的状况：0始终未持有，1持有，2卖出后不持有
            cache[0][0] = 0;
            cache[0][1] = -prices[0];
            cache[0][2] = 0;
            for (int i = 1; i < len; i++) {
                cache[i][0] = Math.max(cache[i - 1][0], cache[i-1][2]);//今天没有且不能交易
                cache[i][1] = Math.max(cache[i - 1][1], cache[i-1][0] - prices[i]);//今天有可以交易
                cache[i][2] = cache[i-1][1] + prices[i];//不能连续两天卖，所以只能是今天卖出
            }
            return Math.max(cache[len - 1][0], cache[len - 1][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}