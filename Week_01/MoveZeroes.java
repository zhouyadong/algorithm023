package com.homework.week01;

import com.alibaba.fastjson.JSONObject;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // TO TEST
//        int[] nums = {0,0,1};
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(JSONObject.toJSONString(nums));
    }
//Java：移动零
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void moveZeroes(int[] nums) {

        int flag = 0;//准备一个记录非0的位置
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {//遇到非0
                int tem = nums[flag];//临时变量
                nums[flag] = nums[i];//将发现的非0与当前标记位交换
                nums[i] = tem;
                flag ++;//准备下一个标记位
            }
            //nums[i]==0时，flag不改变，意味着当前标记位仍然有效
        }
    }

    public void moveZeroes3(int[] nums) {

        int flag = 0;//记录遇到的0个数[1,0,0,3,12]
        int len = nums.length;
        for (int i = 0; i < len; i++) {//遍历数据
            if (nums[i] == 0) {//遍历过程中遇到0元素时
                flag ++;//找到一个0
            } else {
                //遇到非0时，将i与第一个0交换位置：第一个0相对于i的位置是 i-flag
                int tem = nums [i-flag];
                nums [i-flag] = nums[i];
                nums[i] = tem;
            }

        }
    }

    public void moveZeroes2(int[] nums) {

        int flag = 0;//增加指针记录非0元素
        int len = nums.length;
        for (int i = 0; i < len; i++) {//遍历数据
            if (nums[i] != 0) {//遍历过程中遇到非0元素时
                nums[flag] = nums[i];//告诉flag,找到非0元素，记录在你的位置
                flag ++;//flag记录后，再开辟一个标记值准备记录下一个
            }
            //遇到0时，flag并不关心，i继续寻找非0元素
        }
        //当整个数组遍历完成后，flag记录了 flag-1个非0元素，也就是说flag及其后面的元素都应该是其忽略的0
        while (flag < len) {
            nums[flag] = 0;
            flag ++;
        }
    }

    public void moveZeroes1(int[] nums) {
        //判断是0就互换位置
        int len = nums.length - 1;
        for (int i = 0; i < len; i ++) {
            if (nums[i] == 0 && nums[i+1] !=0) {//开始处理
                int tem = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tem;
            }
            //每次j与j-1交换过以后下次就判断j-1和j-2
            for (int j = len ; j > i; j-- ) {
                if (nums[j] != 0 && nums[j-1] ==0) {//开始处理
                    int tem = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tem;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 900 👎 0

}