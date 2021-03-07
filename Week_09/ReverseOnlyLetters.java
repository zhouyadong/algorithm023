package com.exercise.week09;

/**
 * Java：   [917]仅仅反转字母
 **/


public class ReverseOnlyLetters {
    //给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串 
// 👍 75 👎 0

    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String S) {
            char[] vals = S.toCharArray();
            int start = 0, end = vals.length - 1;
            while (start < end) {
                if (!check(vals[start]) ) {
                    start++;
                } else if (!check(vals[end])) {
                    end--;
                } else {
                    char tem = vals[start];
                    vals[start] = vals[end];
                    vals[end] = tem;
                    start++;
                    end--;
                }

            }
            return String.valueOf(vals);
        }
        private boolean check(char c) {

            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}