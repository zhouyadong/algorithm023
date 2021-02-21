package com.homework.week07;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java：   [22]括号生成
 **/


public class GenerateParentheses {
    //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1566 👎 0

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(JSONObject.toJSONString(solution.generateParenthesis(3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 动态规划：最终结果的左边一定是"(",根据规则，有且只有一个")"与之对应，剩下的括号组合，要么在这对"("和")"之间，要么在右侧
         *  因此可以得出递推：f(n) = 1 + f(in) + f(right) 其中 n = 1 + in + right
         * @param n
         * @return
         */
        public List<String> generateParenthesis(int n) {

            Map<Integer, List<String>> retMap = this.prepare();
            for (int i = 2; i <= n; i++) {
                int inSize = 0;
                List<String> temList = new ArrayList<>();
                while (inSize < i) {
                    int rightSize = (i - inSize) - 1;
                    List<String> inList = retMap.get(inSize);
                    List<String> rihtList = retMap.get(rightSize);
                    //获取inList中的元素，分别在外面加上一层"()"
                    for (String in : inList) {
                        for (String right : rihtList) {
                            StringBuilder builder = new StringBuilder("(");
                            builder.append(in).append(")").append(right);
                            temList.add(builder.toString());
                        }
                    }
                    inSize ++;
                }
                    retMap.put(i,temList);
            }
            return retMap.get(n);
        }

        private Map<Integer, List<String>> prepare() {

            Map<Integer, List<String>> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            list.add("");
            map.put(0, list);
            list = new ArrayList<>();
            list.add("()");
            map.put(1, list);

            return map;
        }

        /**
         * 时间复杂度：递归中产生两个分支 O(n²),因为剪枝的逻辑存在，所以实际时间复杂度应低于O(n²)
         * 空间复杂度O(1)
         * @param n 分别左右括号的个数
         * @return 符合条件的组合结果
         */
        public List<String> generateParenthesis1(int n) {

            List<String> retList = new ArrayList<>();
            this.recursion1(retList,n,0,0,"");
            return retList;
        }

        private void recursion1(List<String> retList, int n, int left, int right, String value) {

            //terminator
            if (left == n && right == n) {
                retList.add(value);
                return;
            }
            //process logic
            if (left < n) {//再放一个左括号
                this.recursion1(retList,n,left+1,right,value + "(");//drill down
            }
            if (right < n && right < left) {//右括号符合要求
                this.recursion1(retList, n, left, right + 1, value + ")");
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}