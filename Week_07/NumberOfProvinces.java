package com.homework.week07;

/**
 * Java：   [547]省份数量
 **/


public class NumberOfProvinces {
    //
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 493 👎 0

    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
        // TO TEST
        int[][] isConnected = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(solution.findCircleNum(isConnected));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class UnionFind {

            int size;
            int[] parents;

            public UnionFind(int size) {
                this.size = size;
                parents = new int[size];
                for (int i = 0; i < size; i ++) {
                    parents[i] = i;
                }
            }

            public int findRoot(int target) {

                while(target != parents[target]) {
                    parents[target] = parents[parents[target]];
                    target = parents[target];
                }
                return target;
            }

            public void union(int p, int q) {

                int rootP = this.findRoot(p);
                int rootQ = this.findRoot(q);
                if (rootP != rootQ) {
                    parents[rootP] = rootQ;
                    this.size --;
                }
            }

        }

        /**
         * nxn二维矩阵表示的是n个元素之间的关系，采用并查集，通过双指针寻找两个元素之间的关系
         * @param isConnected
         * @return
         */
        public int findCircleNum(int[][] isConnected) {

            int len = isConnected.length;
            UnionFind uf = new UnionFind(len);
            for (int i = 0; i < (len - 1); i++) {
                for (int j = (i + 1); j < len; j++) {
                    if (isConnected[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }
            return  uf.size;
        }

        public int findCircleNum1(int[][] isConnected) {

            int ret = 0;
            int size = isConnected.length;
            boolean[] visited = new boolean[size];
            for (int i = 0; i < size; i++) {
                if (!visited[i]) {//这个城市没有被省份包含过
                    this.dfs1(isConnected, visited, i, size);//dfs寻找符合条件的城市一起组成省份
                    ret++;//省份加1
                }
            }
            return ret;
        }

        private void dfs1(int[][] isConnected, boolean[] visited, int i, int size) {

            for (int j = 0; j < size; j++) {
                if (isConnected[i][j] != 1 || visited[j]) {
                    continue;
                } else {
                    visited[j] = Boolean.TRUE;
                    this.dfs1(isConnected, visited, j, size);
                }
            }
//        visited[i] = Boolean.TRUE;//把自己标记为已使用，
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}