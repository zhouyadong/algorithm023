package com.homework.week07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Java：   [36]有效的数独
 **/


public class ValidSudoku {
    //判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5','3','.','.','7','.','.','.','."],
//  ["6','.','.','1','9','5','.','.','."],
//  [".','9','8','.','.','.','.','6','."],
//  ["8','.','.','.','6','.','.','.','3"],
//  ["4','.','.','8','.','3','.','.','1"],
//  ["7','.','.','.','2','.','.','.','6"],
//  [".','6','.','.','.','.','2','8','."],
//  [".','.','.','4','1','9','.','.','5"],
//  [".','.','.','.','8','.','.','7','9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8','3','.','.','7','.','.','.','."],
//  ["6','.','.','1','9','5','.','.','."],
//  [".','9','8','.','.','.','.','6','."],
//  ["8','.','.','.','6','.','.','.','3"],
//  ["4','.','.','8','.','3','.','.','1"],
//  ["7','.','.','.','2','.','.','.','6"],
//  [".','6','.','.','.','.','2','8','."],
//  [".','.','.','4','1','9','.','.','5"],
//  [".','.','.','.','8','.','.','7','9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 471 👎 0

    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        // TO TEST
        char[][] board = new char[][]{{'.', '.', '5', '.', '.', '.', '.', '.', '.'}, {'1', '.', '.', '2', '.', '.', '.', '.', '.'}, {'.', '.', '6', '.', '.', '3', '.', '.', '.'}, {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, {'3', '.', '1', '5', '2', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '4', '.'}, {'.', '.', '6', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '9', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        System.out.println(solution.isValidSudoku(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        //在isValidSudoku1基础上使用数组替换map
        public boolean isValidSudoku(char[][] board) {

            int[][] row = new int[9][9];
            int[][] col = new int[9][9];
            int[][] area = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {//需要检验
                        int areaIndex = (i / 3) * 3 + j / 3;
                        int currentIndex = board[i][j] - '1';
                        if ((row[i][currentIndex] += 1) > 1
                            || (col[j][currentIndex] += 1) > 1
                            || (area[areaIndex][currentIndex] += 1) > 1) {//已存在
                            return Boolean.FALSE;
                        }
                    }
                }
            }
            return Boolean.TRUE;
        }


        //遍历棋盘：分别对行、列、格子做校验
        public boolean isValidSudoku1(char[][] board) {

            Map<Integer, Set<Character>> row = new HashMap<>();
            Map<Integer, Set<Character>> col = new HashMap<>();
            Map<Integer, Set<Character>> area = new HashMap<>();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char current = board[i][j];//获取当前元素
                    if (current == '.') {
                        continue;
                    }
                    int areaIndex = (i / 3) * 3 + j / 3;
                    //检查所在的行、列、格子是否该数字只有一次；
                    if (this.check1(col, j, current)
                            || this.check1(area, areaIndex, current)
                            || this.check1(row, i, current)) {
                        return Boolean.FALSE;
                    }
                }
            }

            return Boolean.TRUE;
        }

        /**
         * 检查、记录
         *
         * @param target
         * @param index
         * @param c
         * @return
         */
        private boolean check1(Map<Integer, Set<Character>> target, int index, char c) {

            Set<Character> currents = target.get(index);
            if (null == currents) {
                currents = new HashSet<>();
                currents.add(c);
                target.put(index, currents);
                return Boolean.FALSE;
            }
            if (currents.contains(c)) {
                return Boolean.TRUE;
            }
            currents.add(c);
            return Boolean.FALSE;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}