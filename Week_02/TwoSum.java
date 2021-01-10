package com.homework.week02;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Java：两数之和
 **/
public class TwoSum {
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 9954 👎 0

    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // TO TEST
        int[] nums = new int[]{3,2,4};
        int target = 6;
        System.out.println(JSONObject.toJSONString(solution.twoSum(nums, target)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //可以假设每种输入只会对应一个答案，所以遍历时，当前元素要么能找到答案，要么就是其他元素的答案
        // 在twoSum1的基础上优化
        public int[] twoSum(int[] nums, int target) {

            int len = nums.length;
            Map<Integer, Integer> temMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < len; i ++) {
                //获取当前值
                int current = nums[i];
                int ret = target - current;
                //判断是否已的目标值是否已存在
                Integer value = temMap.get(ret);
                if (null != value) {
                    return new int[]{i, value};
                }
                //将自己作为目标值放入缓存
                temMap.put(current, i);
            }

            return null;
        }


        //判断 tem = target - nums[i] 是否存在于nums中(除nums[i]自身)，
        public int[] twoSum1(int[] nums, int target) {

            int len = nums.length;
            Map<Integer, Integer> temMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < len; i ++) {//第一次遍历准备数据
                //获取当前值
                int current = nums[i];
                ///计算目标值
                int ret = target - current;
                temMap.put(ret, i);//记录当前位置和目标值：只有一个结果，所以不会重复
            }

            for (int i = 0; i < len; i ++) {//第二次遍历判断
                    int value = nums[i];
                    Integer ret = temMap.get(value);
                    if (null != ret && i != ret) {//找到
                        return new int[]{i, ret};
                    }
            }


            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}