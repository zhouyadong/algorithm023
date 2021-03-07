package com.exercise.week09;

/**
 * Java：   [557]反转字符串中的单词 III
 **/


public class ReverseWordsInAStringIii {
    //给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 277 👎 0

    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        // TO TEST
        String s = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseWords(String s) {

            char[] vals = s.toCharArray();
            int start = 0, end = 1, len = vals.length;
            while (start < len) {
                if (end == len || vals[end] == ' ' ) {//先判断长度
                    this.deal2(vals, start, end - 1);
                    start = end + 1;
                }
                    end++;
            }

            return String.valueOf(vals);
        }

        public void deal2(char[] vals, int start, int end) {

            while(start < end) {
                char tem = vals[start];
                vals[start] = vals[end];
                vals[end] = tem;
                start++; end--;
            }
        }

        public String reverseWords1(String s) {

            String[] values = s.split(" ");
            StringBuilder builder = new StringBuilder();
            for (String value : values) {
                builder.append(this.deal1(value)).append(" ");
            }
            return builder.deleteCharAt(s.length()).toString();
        }

        private String deal1(String str) {

            char[] c = str.toCharArray();
            int start = 0, end = c.length - 1;
            while (start < end) {
                char tem = c[start];
                c[start] = c[end];
                c[end] = tem;
                start++;
                end--;
            }
            return String.valueOf(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}