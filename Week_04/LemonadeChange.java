package com.homework.week04;

/**
 * Java：   [860]柠檬水找零
 **/


public class LemonadeChange {
    //在柠檬水摊上，每一杯柠檬水的售价为 5 美元。 
//
// 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。 
//
// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。 
//
// 注意，一开始你手头没有任何零钱。 
//
// 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。 
//
// 示例 1： 
//
// 输入：[5,5,5,10,20]
//输出：true
//解释：
//前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
//第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
//第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
//由于所有客户都得到了正确的找零，所以我们输出 true。
// 
//
// 示例 2： 
//
// 输入：[5,5,10]
//输出：true
// 
//
// 示例 3： 
//
// 输入：[10,10]
//输出：false
// 
//
// 示例 4： 
//
// 输入：[5,5,10,10,20]
//输出：false
//解释：
//前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
//对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
//对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
//由于不是每位顾客都得到了正确的找零，所以答案是 false。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= bills.length <= 10000 
// bills[i] 不是 5 就是 10 或是 20 
// 
// Related Topics 贪心算法 
// 👍 204 👎 0

    public static void main(String[] args) {
        Solution solution = new LemonadeChange().new Solution();
        // TO TEST
        int[] bills = new int[]{5, 5,10, 10, 20};
        System.out.println(solution.lemonadeChange(bills));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 贪心算法：整个过程可以拆分为每次卖出和找零，面额是5、10、20之一（倍数关系），
         * 找零只可能用到5和10的组合，优先按10找零，然后5，不够就停止，从而递推出问题最优解（最优子结构）
         *
         * @param bills
         * @return
         */
        public boolean lemonadeChange(int[] bills) {

            int count5 = 0;
            int count10 = 0;
            int len = bills.length;
            for (int i = 0; i < len; i ++) {
                if (bills[i] == 5) {//不用找
                    count5 ++;//积累
                } else if (bills[i] == 10) {//找5块
                    count10 ++;//积累
                    count5 --;//找零
                } else if (bills[i] == 20) {
                    if (count10 - 1 < 0) {//10块不够，减两个5块
                        count5 --;
                        count5 --;
                    } else {//优先减10
                        count10--;
                    }
                    count5 --;//再建一个5块
                }
                if (count5 < 0) {//用完了
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }




        public boolean lemonadeChange1(int[] bills) {

            int len = bills.length;
            if (len == 0) {
                return Boolean.TRUE;
            }
            int c5 = 0;
            int c10 = 0;
            int c20 = 0;
            for (int i = 0; i < len; i++) {
                if (5 == bills[i]) {//不用找
                    c5++;
                } else if (10 == bills[i]) {//十块的需要找五块
                    c5--;
                    if (c5 < 0) {
                        return Boolean.FALSE;
                    }
                    c10++;//收入十元
                } else if (20 == bills[i]) {//二十需要找15

                    if (c10 > 0) {//优先用十块，十块只能用一张
                        c10--;
                        c5--;
                    } else {//十块不够只能用五块
                        c5 -= 3;
                    }
                    if (c10 < 0 || c5 < 0) {
                        return Boolean.FALSE;
                    }
                    c20++;
                }
            }
            return Boolean.TRUE;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}