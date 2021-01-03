package com.homework.week01;

import com.alibaba.fastjson.JSONObject;

/**
 * Java：旋转数组
 **/
public class RotateArray {
    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 764 👎 0

    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        // TO TEST
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums = {-1,-100,3,99};
        solution.rotate(nums, 2);
        System.out.println(JSONObject.toJSONString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 翻转所有元素，找出需要再次翻转的头部范围和尾部范围，再次翻转
         * @param nums
         * @param k
         */
        public void rotate(int[] nums, int k) {

            int count = k % nums.length;//尾元素要后移个数
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, count - 1);
            reverse(nums, count, nums.length - 1);
        }

        /**
         * 将数组中的元素按指定范围翻转
         * @param nums
         * @param start
         * @param end
         */
        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}