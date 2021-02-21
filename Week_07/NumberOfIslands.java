package com.homework.week07;

import java.util.LinkedList;
import java.util.Queue;

/**
* Java：✔[200]岛屿数量
**/


public class NumberOfIslands {
    //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 972 👎 0

    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        //bfs
        public int numIslands(char[][] grid) {

            int ret = 0;
            int row = grid.length;
            int col = grid[0].length;
            int [][] directions = new int[][]{{0, 1},{1, 0},{0, -1},{-1, 0}};
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {//发现岛屿
                        bfs(grid,i,j,directions,row,col);
                        ret ++;
                    }
                }
            }
            return ret;
        }

        /**
         * 探索岛屿全貌
         * @param grid 参数集合
         * @param i
         * @param j
         * @param directions
         * @param rowSize
         * @param colSize
         */
        private void bfs(char[][] grid, int i, int j, int[][] directions, int rowSize, int colSize) {

            Queue<int[]> cacheQueue = new LinkedList<>();
            cacheQueue.offer(new int[]{i, j});

            while (!cacheQueue.isEmpty()) {
                int[] current = cacheQueue.poll();
                i = current[0];
                j = current[1];
                if (0 <= i && i < rowSize
                        && 0 <= j && j < colSize && grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int[] direction : directions) {
                        cacheQueue.offer(new int[]{i + direction[0], j + direction[1]});
                    }
                }
            }

        }








        public int islandPerimeter1(int[][] grid) {
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (grid[r][c] == 1) {
                        // 题目限制只有一个岛屿，计算一个即可
                        return dfs(grid, r, c);
                    }
                }
            }
            return 0;
        }

        int dfs(int[][] grid, int r, int c) {
            //因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
            if (!inArea(grid, r, c)) {
                return 1;
            }
            //因为「当前格子是海洋格子」返回，对应一条蓝色的边
            if (grid[r][c] == 0) {
                return 1;
            }
            //因为「当前格子是已遍历的陆地格子」返回，和周长没关系
            if (grid[r][c] != 1) {
                return 0;
            }
            grid[r][c] = 2;
            return dfs(grid, r - 1, c)
                    + dfs(grid, r + 1, c)
                    + dfs(grid, r, c - 1)
                    + dfs(grid, r, c + 1);
        }

        //判断坐标 (r, c) 是否在网格中
        boolean inArea(int[][] grid, int r, int c) {
            return 0 <= r && r < grid.length
                    && 0 <= c && c < grid[0].length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}