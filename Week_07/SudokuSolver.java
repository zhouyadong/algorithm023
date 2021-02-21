package com.homework.week07;

/**
 * Java：   [37]解数独
 **/


public class SudokuSolver {
    //编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 758 👎 0

    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        // TO TEST
        char[][] board = new char[][]{{'.', '.', '5', '.', '.', '.', '.', '.', '.'}, {'1', '.', '.', '2', '.', '.', '.', '.', '.'}, {'.', '.', '6', '.', '.', '3', '.', '.', '.'}, {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, {'3', '.', '1', '5', '2', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '4', '.'}, {'.', '.', '6', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '9', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        solution.solveSudoku(board);
        System.out.println(1111);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 解题思路：遍历棋盘找到空位后，尝试写入数字，并判断写入后，棋盘是否合法，以此类推；如果不合法，回溯到开始位置尝试下一个数字；
         * 直至问题解决，或者无解
         *
         * @param board
         */
        public void solveSudoku(char[][] board) {

            if (null != board) {
                this.solve2(board);
            }

        }

        public boolean solve3(char[][] board) {


            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        for (char k = '1'; k <= '9'; k++) {
                            if (this.checkValid2(board, i, j, k)) {//校验棋盘是否合法
                                board[i][j] = k;//尝试答案
                                if (this.solve2(board)) {//递归下一个
                                    return Boolean.TRUE;
                                }
                                board[i][j] = '.';//恢复
                            }
                        }
                        return Boolean.FALSE;
                    }
                }
            }
            return Boolean.TRUE;
        }

        public boolean solve2(char[][] board) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        for (char k = '1'; k <= '9'; k++) {
                            if (this.checkValid2(board, i, j, k)) {//校验棋盘是否合法
                                board[i][j] = k;//尝试答案
                                if (this.solve2(board)) {//递归下一个
                                    return Boolean.TRUE;
                                }
                                board[i][j] = '.';//恢复
                            }
                        }
                        return Boolean.FALSE;
                    }
                }
            }
            return Boolean.TRUE;
        }





        /**
         * 校验棋盘是否合法
         * @param board
         * @param row
         * @param col
         * @param c
         * @return true 合法
         */
        private boolean checkValid2(char[][] board, int row, int col, char c) {


            for (int i = 0; i < 9; i++) {
                if (board[i][col] != '.' && board[i][col] == c) {//检查行
                    return Boolean.FALSE;
                }
                if (board[row][i] != '.' && board[row][i] == c) {//检查列
                    return Boolean.FALSE;
                }
                int areaRow = (row / 3) * 3 + i / 3;
                int areaCol = (col / 3) * 3 + i % 3;
                if (board[areaRow][areaCol] != '.' && board[areaRow][areaCol] == c) {//检查区域
                    return Boolean.FALSE;
                }

            }
            return Boolean.TRUE;
        }

        public boolean solve1(char[][] board) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        for (char k = '1'; k <= '9'; k++) {
                            board[i][j] = k;//尝试答案
                            if (this.checkValid1(board)) {//校验棋盘是否合法
                                if (this.solve1(board)) {//递归下一个
                                    return Boolean.TRUE;
                                }
                            }
                            board[i][j] = '.';//恢复
                        }
                        return Boolean.FALSE;
                    }
                }
            }
            return Boolean.TRUE;
        }

        /**
         * 校验棋盘是否合法
         *
         * @param board
         * @return true 合法
         */
        private boolean checkValid1(char[][] board) {

            int[][] row = new int[9][9];
            int[][] col = new int[9][9];
            int[][] area = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int areaIndex = (i / 3) * 3 + j / 3;
                        int valueIndex = board[i][j] - '1';
                        if ((row[i][valueIndex] += 1) > 1
                                || (col[j][valueIndex] += 1) > 1
                                || (area[areaIndex][valueIndex] += 1) > 1) {
                            return Boolean.FALSE;
                        }
                    }
                }
            }
            return Boolean.TRUE;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}