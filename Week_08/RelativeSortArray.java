package com.exercise.week08;

/**
 * Java：   [1122]数组的相对排序
 **/


public class RelativeSortArray {
    //给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 159 👎 0

    public static void main(String[] args) {
        Solution solution = new RelativeSortArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 计数排序s
         * 时间复杂度：O(m+n+l)
         * 空间复杂度：O(l)
         * @param arr1
         * @param arr2
         * @return
         */
        public int[] relativeSortArray(int[] arr1, int[] arr2) {

            int[] caches = new int[1001];//利用数组记录值和个数
            for (int arr : arr1) {
                caches[arr] += 1;//将元素初始化到caches中，重复的累加个数
            }
            int flag = 0;//记录结果
            for (int arr : arr2) {//优先按arr2排序
                while (caches[arr]-- > 0) {
                    arr1[flag++] = arr;
                }
            }
            for (int i = 0; i < 1001; i++) {//剩下的按caches的下标读出即可
                while (caches[i]-- > 0) {
                    arr1[flag++] = i;
                }
            }
            return arr1;
        }

        public int[] relativeSortArray1(int[] arr1, int[] arr2) {

            int cache[] = new int[1001];
            int len1 = arr1.length;
            for (int i = 0; i < len1; i++) {
                cache[arr1[i]]++;
            }
            int flag = 0;
            for (int arr : arr2) {
                while (cache[arr]-- > 0) {
                    arr1[flag++] = arr;
                }
            }
            for (int i = 0; i < 1001; i++) {
                while (cache[i]-- > 0) {
                    arr1[flag++] = i;
                }
            }
            return arr1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}