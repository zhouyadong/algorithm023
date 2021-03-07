package com.exercise.week09;

import java.util.HashMap;
import java.util.Map;

/**
 * Java：   [680]验证回文字符串 Ⅱ
 **/


public class ValidPalindromeIi {
    //给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 324 👎 0

    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        // TO TEST
        String s = "abca";
        System.out.println(solution.validPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean validPalindrome(String s) {

            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return this.check2(s, left + 1, right)
                            || this.check2(s, left, right - 1);
                }
                left++; right--;
            }
            return Boolean.TRUE;
        }

        //验证指定范围是否为回文
        private Boolean check2(String str, int left, int right) {

            while (left <= right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return Boolean.FALSE;
                }
                left++; right--;
            }
            return Boolean.TRUE;
        }






        public boolean validPalindrome1(String s) {

            Map<Integer, Integer> cache = new HashMap<>();
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return check1(s, left + 1, right) || check1(s, left, right - 1);
                }
            }

            return Boolean.TRUE;
        }

        /**
         * 判断字符串s，[left, right]范围内是不是回文字符串
         *
         * @param s     字符串
         * @param left  左起点
         * @param right 右起点
         * @return 结果：true 是回文字符串
         */
        public boolean check1(String s, int left, int right) {

            while (left <= right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}