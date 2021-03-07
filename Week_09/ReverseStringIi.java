package com.exercise.week09;

/**
 * Java：   [541]反转字符串 II
 **/


public class ReverseStringIi {
    //给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 117 👎 0

    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        // TO TEST
        String str = "abcdefg";
        int k = 2;
        System.out.println(solution.reverseStr(str, k));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public String reverseStr(String s, int k) {

            char[] values = s.toCharArray();
            int len = values.length;
            for (int i = 0; i < len; i += 2*k) {
                int start = i, end = ((i + k) > len) ? len -1 : i + k -1;
                this.deal2(values, start, end);
            }
            return String.valueOf(values);
        }

        //反转指定起始位置的字符串
        private void deal2 (char[] values, int start, int end) {

            while (start < end) {
                char tem = values[start];
                values[start] = values[end];
                values[end] = tem;
                start++;
                end--;
            }
        }


        /**
         *
         * @param s
         * @param k
         * @return
         */
        public String reverseStr1(String s, int k) {

            int len = s.length();
            char[] vals = s.toCharArray();
            for (int i = 0; i < len; i += 2*k) {
                int right = Math.min(i+k-1,len-1);
                doReverse(vals, i, right);
            }
            return String.valueOf(vals);
        }
        //按起始位置翻转字符串
        public void doReverse(char[] vals, int left, int right) {

            while (left < right) {
                char tem = vals[left];
                vals[left++] = vals[right];
                vals[right--] = tem;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}