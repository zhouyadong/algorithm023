package com.homework.week06;

/**
 * Java：   [647]回文子串
 **/


public class PalindromicSubstrings {
    //给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 480 👎 0

    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 时间复杂度 O(n²)
         * 空间复杂度 O(n)
         * @param s
         * @return
         */
        public int countSubstrings(String s) {

            int ret = 0, len = s.length();
            char[] chars = s.toCharArray();
            for (int i = 0; i < len; i++) {
                //回文子串的情况分两种：基数时，中心点为一个字符；
                //偶数时，中心点为两个字符
                for (int j = 0; j < 2; j ++) {
                    int left = i, right = i + j;
                    while (left >= 0 && right < len && chars[left] == chars[right]) {//回文判断
                        left --;//向左继续
                        right ++;//向右继续
                        ret ++;//计数
                    }
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}