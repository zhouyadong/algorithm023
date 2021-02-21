package com.homework.week07;

import java.util.*;

/**
 * Java：   [212]单词搜索 II
 **/


public class WordSearchIi {
    //给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 328 👎 0

    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        // TO TEST
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(board, words));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 时间复杂度分析
         * 1、遍历words初始化trie O(N)
         * 2、遍历board时间复杂度 O(N) + O(m*n)
         * 3、遍历board的过程中，dfs查找trie中元素：因为做了4个方向的递归，考虑单词长度k，所以4^k,
         * 又因为visited的作用使上一个节点避免被再次递归，所以3^k,考虑到第一次调用时visited无法剪枝，所以4*3^(k-1),因此：O(N) + O(m*n*4*3^(k-1))
         * 4、忽略低阶、系数、常量，最终时间复杂度：O(m*n*3^(k))，其中m、n表示二维字符网格的大小，k为单词的长度
         * <p>
         * 空间复杂度：
         * 1、trie中出现的字母总数 O(N)
         * 2、visited: O(m*n)的大小是额外使用的空间
         * 总空间复杂度：O(N) + O(m*n)
         *
         * @param board
         * @param words
         * @return
         */
        public List<String> findWords(char[][] board, String[] words) {

            int m = board.length, n = board[0].length, size = words.length;
            //初始化字典树
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            boolean[][] visited = new boolean[m][n];
            Set<String> rets = new HashSet<>();
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    this.dealFind1(board, m, n, i, j, trie, visited, rets, direction);
                }
            }
            return new ArrayList<>(rets);
        }

        private void dealFind1(char[][] board, int m, int n, int i, int j, Trie trie, boolean[][] visited, Set<String> rets, int[][] direction) {

            //terminator
            if (i < 0 || j < 0 || i == m || j == n//出界
                    || visited[i][j]) {//已访问
                return;
            }
            //process logic
            trie = trie.children[board[i][j] - 'a'];
            if (null == trie) {//没找到
                return;
            } else if (trie.endFlag) {//找到了
                rets.add(trie.value);
            }
            //分治
            visited[i][j] = Boolean.TRUE;//防止状态树中的子节点，再次访问相同字母
            for (int[] target : direction) {
                this.dealFind1(board, m, n, i + target[0], j + target[1], trie, visited, rets, direction);
            }
            visited[i][j] = Boolean.FALSE;//当前节点的全部子状态树遍历完毕，恢复访问标记，供其他节点的状态树使用

        }


        class Trie {

            private String value;

            private Trie[] children;

            private boolean endFlag;

            public Trie() {
                this.children = new Trie[26];
            }

            public void insert(String word) {
                if (null != word) {
                    int len = word.length();
                    Trie trie = this;
                    for (int i = 0; i < len; i++) {
                        int index = word.charAt(i) - 'a';
                        if (null == trie.children[index]) {
                            trie.children[index] = new Trie();
                        }
                        trie = trie.children[index];
                    }
                    trie.endFlag = Boolean.TRUE;
                    trie.value = word;
                }
            }

            public Trie findPrefix(String prefix) {

                if (null != prefix) {
                    int len = prefix.length();
                    Trie trie = this;
                    for (int i = 0; i < len; i++) {
                        int index = prefix.charAt(i) - 'a';
                        trie = trie.children[index];
                        if (null == trie) {
                            return null;
                        }
                    }
                    return trie;
                }
                return null;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Trie[] getChildren() {
                return children;
            }

            public void setChildren(Trie[] children) {
                this.children = children;
            }

            public boolean isEndFlag() {
                return endFlag;
            }

            public void setEndFlag(boolean endFlag) {
                this.endFlag = endFlag;
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {

        /**
         * 时间复杂度分析
         * 1、遍历words初始化trie O(N)
         * 2、遍历board时间复杂度 O(N) + O(m*n)
         * 3、遍历board的过程中，dfs查找trie中元素：因为做了4个方向的递归，考虑单词长度k，所以4^k,
         * 又因为visited的作用使上一个节点避免被再次递归，所以3^k,考虑到第一次调用时visited无法剪枝，所以4*3^(k-1),因此：O(N) + O(m*n*4*3^(k-1))
         * 4、忽略低阶、系数、常量，最终时间复杂度：O(m*n*3^(k))，其中m、n表示二维字符网格的大小，k为单词的长度
         * <p>
         * 空间复杂度：
         * 1、trie中出现的字母总数 O(N)
         * 2、visited: O(m*n)的大小是额外使用的空间
         * 总空间复杂度：O(N) + O(m*n)
         *
         * @param board
         * @param words
         * @return
         */
        public List<String> findWords(char[][] board, String[] words) {

            //构建trie
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            Set<String> rets = new HashSet<>();
            int m = board.length, n = board[0].length;
            boolean[][] visited = new boolean[m][n];//记录已使用过的元素：已使用过的元素不用再出现在四个方向寻找的过程中
            //遍历board：DFS
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {//从board[i][j]向上、下、左、右四个方向寻找 TODO
                    this.checkWord(board, trie, i, j, m, n, rets, visited);
                }
            }
            List<String> retList = new LinkedList<>(rets);

            return retList;
        }


        /**
         * 从board[i][j]向上、下、左、右四个方向寻找
         *
         * @param board   网格元素
         * @param trie    words构建的字典树
         * @param i
         * @param j
         * @param m
         * @param n
         * @param rets    结果集
         * @param visited 已访问过的元素
         */
        private void checkWord(char[][] board, Trie trie, int i, int j, int m, int n, Set<String> rets, boolean[][] visited) {

            //terminator
            if (i < 0 || i == m || j < 0 || j == n || //出界
                    visited[i][j]) {//已访问
                return;
            }
            // process logic
            Trie current = trie.children[board[i][j] - 'a'];
            if (null == current) {//没找到，
                return;//停止寻找
            } else if (current.endFlag) {//找到了
                rets.add(current.value);//记录
            }
            //继续找
            visited[i][j] = Boolean.TRUE;//标记已访问,防止下一层递归再次访问
            int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//四个方向：上、右，下，左
            for (int k = 0; k < 4; k++) {
                this.checkWord(board, current, i + direction[k][0], j + direction[k][1], m, n, rets, visited);
            }
            //找完后，需要重置标记，因为不同的单词可以有相同的子串
            visited[i][j] = Boolean.FALSE;

        }

        class Trie {

            private boolean endFlag;

            private String value;//构建字典树的字符串

            private Trie[] children;

            public Trie() {
                this.children = new Trie[26];
            }

            public void insert(String word) {
                if (null != word && word.length() > 0) {
                    Trie current = this;
                    int len = word.length();
                    for (int i = 0; i < len; i++) {
                        int index = word.charAt(i) - 'a';
                        if (null == current.children[index]) {
                            current.children[index] = new Trie();
                        }
                        current = current.children[index];
                    }
                    current.endFlag = Boolean.TRUE;
                    current.value = word;
                }
            }

            private Trie checkPrefix(String prefix) {

                if (null != prefix && prefix.length() > 0) {
                    Trie trie = this;
                    int len = prefix.length();
                    for (int i = 0; i < len; i++) {
                        int index = prefix.charAt(i) - 'a';
                        trie = trie.children[index];
                        if (null == trie) {
                            return null;
                        }
                    }
                    return trie;
                }
                return null;
            }
        }
    }

    class Solution1 {
        public List<String> findWords(char[][] board, String[] words) {

            int m = board.length, n = board[0].length;
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            boolean[][] visited = new boolean[m][n];//防止重复访问
            Set<String> rets = new HashSet<>();//结果集
            for (int i = 0; i < m; i++) {//遍历board
                for (int j = 0; j < n; j++) {
                    this.dfs(trie, board, i, j, m, n, rets, visited);
                }
            }

            return new ArrayList<>(rets);
        }

        private void dfs(Trie trie, char[][] board, int i, int j, int m, int n, Set<String> rets, boolean[][] visited) {

            //terminator
            if (i < 0 || i == m || j < 0 || j == n
                    || visited[i][j]) {
                return;
            }
            //process logic
            trie = trie.children[board[i][j] - 'a'];//获取节点
            if (null == trie) {//没有
                return;
            }
            if (trie.endFlag) {//找到了
                visited[i][j] = Boolean.TRUE;//标记已经处理过
                rets.add(trie.value);//记录答案
            }
            //分治下一层
            visited[i][j] = Boolean.TRUE;//防止重复访问
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int k = 0; k < 4; k++) {
                this.dfs(trie, board, i + direction[k][1], j + direction[k][0], m, n, rets, visited);
            }
            visited[i][j] = Boolean.FALSE;//当前i，j对应元素处理完成，恢复状态
        }

        class Trie {

            private String value;

            private boolean endFlag;

            private Trie[] children;

            public Trie() {
                this.children = new Trie[26];
            }

            public void insert(String word) {
                if (null != word && word.length() > 0) {
                    int len = word.length();
                    Trie current = this;
                    for (int i = 0; i < len; i++) {
                        int index = word.charAt(i) - 'a';
                        if (null == current.children[index]) {
                            current.children[index] = new Trie();
                        }
                        current = current.children[index];
                    }
                    current.endFlag = Boolean.TRUE;
                    current.value = word;
                }
            }

            public Trie checkPrefix(String prefix) {

                if (null != prefix && prefix.length() > 0) {
                    int len = prefix.length();
                    Trie current = this;
                    for (int i = 0; i < len; i++) {
                        int index = prefix.charAt(i) - 'a';
                        current = current.children[index];
                        if (null == current) {
                            break;
                        }
                    }
                    return current;
                }

                return null;
            }

        }
    }

}