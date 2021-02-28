package com.exercise.week08;

/**
 * Java：   [190]颠倒二进制位
 **/


public class ReverseBits {
    //颠倒给定的 32 位无符号整数的二进制位。 
//
// 
//
// 示例 1： 
//
// 输入: 00000010100101000001111010011100
//输出: 00111001011110000010100101000000
//解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
//     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。 
//
// 示例 2： 
//
// 输入：11111111111111111111111111111101
//输出：10111111111111111111111111111111
//解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
//     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。 
//
// 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -10737418
//25。 
// 
//
// 
//
// 进阶: 
//如果多次调用这个函数，你将如何优化你的算法？ 
// Related Topics 位运算 
// 👍 267 👎 0

    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value

        public int reverseBits(int n) {

            int size = 32, ret = 0;
            while (size-- > 0) {
                int tem = n & 1;
                ret = (ret << 1) | tem;
                n >>= 1;
            }
            return ret;
        }

        public int reverseBits6(int n) {

            n = (n & 0x55555555) << 1 | (n >>> 1) & 0x55555555;
            n = (n & 0x33333333) << 2 | (n >>> 2) & 0x33333333;
            n = (n & 0x0f0f0f0f) << 4 | (n >>> 4) & 0x0f0f0f0f;
            n = (n << 24) | ((n & 0xff00) << 8) |
                    ((n >>> 8) & 0xff00) | (n >>> 24);

            return n;
        }


        public int reverseBits5(int n) {

            int ret = 0, size = 32;
            while (size-- > 0) {
                ret = (ret << 1) | n & 1;
                n >>= 1;
            }
            return ret;
        }



        public int reverseBits4(int n) {

            int ret = 0, size = 32;
            while (size-- > 0) {
                int i = n & 1;
                ret = (ret <<= 1) | i;
                n >>= 1;
            }
            return ret;
        }




        public int reverseBits3(int n) {

            int size = 32, ret = 0;
            while (size-- > 0) {
                ret = ret << 1 | (n & 1);
                n >>= 1;
            }
            return ret;
        }




        public int reverseBits2(int n) {

            int ret = 0, size = 32;
            while (size-- > 0) {
                int tail = n & 1;
                ret <<= 1;
                ret |= tail;
                n >>= 1;
            }

            return ret;
        }

        public int reverseBits1(int n) {

            int ret = 0;
            int size = 32;
            while (size-- > 0) {
                ret <<= 1;
                ret |= n & 1;
                n >>= 1;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}