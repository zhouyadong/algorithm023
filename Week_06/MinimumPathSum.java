package com.homework.week06;

/**
 * Java：   [64]最小路径和
 **/


public class MinimumPathSum {
    //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 774 👎 0

    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        // TO TEST
        System.out.println(solution.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int minPathSum(int[][] grid) {

            int rowSize = grid.length;
            int colSize = grid[0].length;
            int[][] cache = new int[rowSize][colSize];
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (i > 0 && j > 0) {
                        cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - 1]) + grid[i][j];
                    } else if (i > 0) {//第一行
                        cache[i][j] = grid[i][j] + cache[i - 1][j];
                    } else if (j > 0) {//第一列
                        cache[i][j] = grid[i][j] + cache[i][j - 1];
                    } else {//原点与目标重叠
                        cache[i][j] = grid[i][j];
                    }
                }
            }
            return cache[rowSize - 1][colSize - 1];
        }


        public int minPathSum6(int[][] grid) {
            //终点的值：来自上方或者左方 f[m][n] = Min(f[m-1][n], f[m][n-1]) + gird[m][n]
            int m = grid.length, n = grid[0].length;
            int[][] cache = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0 && j > 0) {//来自上方或左方的最小值
                        cache[i][j] = Math.min(cache[i][j - 1], cache[i - 1][j]) + grid[i][j];
                    } else if (i > 0) {//第一列：来自上方
                        cache[i][0] = grid[i][0] + cache[i - 1][0];
                    } else if (j > 0) {//第一行：来自左方
                        cache[0][j] = grid[0][j] + cache[0][j - 1];
                    } else {//到达自己
                        cache[0][0] = grid[0][0];
                    }

                }
            }
            return cache[m - 1][n - 1];
        }


        public int minPathSum5(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0 && j > 0) {
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    } else if (i > 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else if (j > 0) {
                        grid[i][j] += grid[i][j - 1];
                    }
                }
            }
            return grid[m - 1][n - 1];
        }


        public int minPathSum3(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0 && j > 0) {
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    } else if (i > 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else if (j > 0) {
                        grid[i][j] += grid[i][j - 1];
                    }
                }
            }

            return grid[m - 1][n - 1];
        }


        /**
         * 从出发点抵达任一点都有个最小值；到达任意点的方式，最多有两种，从上方一格，或者左方一格，所以二者最小的加上本格就是本格最小
         * 可以在遍历二维数组时，在原数组上修改，如果不允许修改，则新建一个原大小的二维数组作为记录，最终m-1,n-1位置就是目标值
         * 时间复杂度：O(M x N)
         * 空间复杂度：O(1)
         *
         * @param grid
         * @return
         */
        public int minPathSum2(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0 && i > 0) {//比较上方和左方
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    } else if (i > 0) {//在第一行
                        grid[i][j] += grid[i - 1][j];
                    } else if (j > 0) {//在第一列
                        grid[i][j] += grid[i][j - 1];
                    }//否则原点无需处理
                }
            }
            return grid[m - 1][n - 1];
        }


        //每一个点作为终点，都有存在一个最小值
        //到达一个位置只有从上下来和从左过来两种方式，哪种小就更优
        public int minPathSum1(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] ret = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0 && i > 0) {
                        ret[i][j] = grid[i][j] + Math.min(ret[i][j - 1], ret[i - 1][j]);
                    } else if (j > 0) {//第一行
                        ret[i][j] = grid[i][j] + ret[i][j - 1];
                    } else if (i > 0) {//第一列
                        ret[i][j] = grid[i][j] + ret[i - 1][j];
                    } else {//到达自己
                        ret[i][j] = grid[i][j];
                    }
                }
            }
            return ret[m - 1][n - 1];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}