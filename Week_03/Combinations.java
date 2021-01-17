package com.homework.week03;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：   [77]组合
 **/


public class Combinations {
    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 467 👎 0

    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        // TO TEST
        System.out.println(JSONObject.toJSONString(solution.combine(4, 4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {


            List<List<Integer>> retList = new ArrayList<List<Integer>>();
            if (k < 0 || n < k) {
                return retList;
            }
            List<Integer> temList = new ArrayList<Integer>();
            this.check(n, k, 1, new ArrayList<Integer>(), retList);

            return retList;
        }

        /**
         * 递归：dfs
         *
         * @param n       范围
         * @param k       大小
         * @param begin   起点
         * @param temList 保存一种结果集
         * @param retList 结果集
         */
        private void check(int n, int k, int begin, List<Integer> temList, List<List<Integer>> retList) {

            //terminator
            int size = temList.size();
            if (size == k) {
                retList.add(new ArrayList<>(temList));
                return;
            }
            //process 当前层加入第一个元素后，继续下一个
            for (int i = begin; i <= n; i++) {
                temList.add(i);
                //next
                this.check(n, k, i + 1, temList, retList);
                //reset 当前遍历temList的状态保持一致，需要恢复
                temList.remove(size);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}