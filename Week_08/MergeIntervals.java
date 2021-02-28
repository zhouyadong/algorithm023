package com.exercise.week08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Java：   [56]合并区间
 **/


public class MergeIntervals {
    //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 821 👎 0

    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        // TO TEST
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        solution.merge(intervals);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 借助基数排序的思路，对intervals按首元素排序，然后在遍历过程中寻找右边界
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int left = intervals[0][0],right = intervals[0][1], flag = 0;
            int[][] ret = new int[intervals.length][2];
            for (int[] interval : intervals) {
                int start = interval[0],end = interval[1];
                if (start > right) {//超出
                    int[] tem = new int[]{left, right};
                    ret[flag++] = tem;
                    left = start;
                    right = end;
                } else if (right < end) {//更新右边界
                    right = end;
                }
            }
            ret[flag] = new int[]{left, right};
            return Arrays.copyOfRange(ret,0,flag + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}