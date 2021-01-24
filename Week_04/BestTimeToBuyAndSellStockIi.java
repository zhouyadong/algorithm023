package com.homework.week04;

import java.util.Arrays;

/**
 * Java：   [122]买卖股票的最佳时机 II
 **/


public class BestTimeToBuyAndSellStockIi {
    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 1065 👎 0

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        // TO TEST
        int[] prices = new int[]{7,1,5,3,6,4,7,9};
        System.out.println(solution.maxProfit(prices));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Greedy：整个问题可以拆分为间隔两个数据的差，
         * 子问题最优解：如果是正数就相加，负数就不用（最优子结构），递推出最终问题的最优解
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {

            int ret = 0;
            int len = prices.length;
            if (len > 1) {
                for (int i = 1; i < len; i ++) {
                    int tem = prices[i] - prices[i-1];//子问题
                    if (tem > 0) {//最优解
                        ret += tem;//累计
                    }
                }
            }
            return ret;
        }

        //遍历找到可以入手和出手的最大值
        public int maxProfit3(int[] prices) {

            int ret = 0;
            int len = prices.length;
            for (int i = 0; i < len; i ++) {
                int flag = i + 1;//可以卖出的日期标记
                if (flag < len && prices[flag] > prices[i]) {
                    while (flag < len -1 && prices[flag] < prices[flag + 1]) {//找到第一个峰值日期
                        flag ++;
                    }
                    ret += prices[flag] - prices[i];//一次性计算差价
                    i = flag;
                }
            }
            return ret;
        }

        //第一天买入，最后一天卖出，中间每一天都卖掉前一天，再买入次日，累计每一天之间大于0的差值
        public int maxProfit2(int[] prices) {

            int ret = 0;
            int len = prices.length;
            for (int i = 1; i < len; i ++) {
                int temValue = prices[i] - prices[i-1];
                if (temValue > 0) {//局部最优：每次涨了就加
                    ret += temValue;
                }
            }
            return ret;
        }

        public int maxProfit1(int[] prices) {
            int ret = 0;
            int len = prices.length;
            if (len < 2) {//最低长度是2
                return ret;
            }
            int i = 1;
            if (prices[0] < prices[i]) {//当前可以入手
                while (i < (len - 1) && prices[i] < prices[i + 1]) {//找到升序最大
                    i++;
                }
                ret = prices[i] - prices[0];//计算利益
                i++;//从i下一个开始
                if (i == len) {//结束
                    return ret;
                }
            }
            ret += this.maxProfit(Arrays.copyOfRange(prices, i, len));
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}