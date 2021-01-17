package com.homework.week03;

/**
 * Java：   [236]二叉树的最近公共祖先
 **/


public class LowestCommonAncestorOfABinaryTree {
    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 898 👎 0

    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        // TO TEST
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        //方法：递归
        //实际就是在遍历每一个子节点temNode树的过程中,找两个目标节点
        //在找到目标节点之前，遍历遇到的全部节点都要判断，时间复杂度：O(n)
        //没有用到受数据规模影响的额外空间，空间复杂度：O(1)
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //terminator // 所有节点的值都是唯一的; p、q 为不同节点且均存在于给定的二叉树中。
            if (null == root) {//叶子节点
                return null;
            }
            if (root == p) {//找到一个
                return p;
            }
            if (root == q) {//找到另一个
                return q;
            }
            //process
            TreeNode left = root.left;//
            TreeNode retL = this.lowestCommonAncestor(left, p, q);//next level
            TreeNode right = root.right;
            TreeNode retR = this.lowestCommonAncestor(right, p, q);//next level
            if (null !=retL && null != retR) {//左右子树各找到一个
                return root;
            } else if (null == retL) {//左边一个也没找到，应该就在右边，先遇到的就是
                return retR;
            }  else {//一定存在，所以就肯定在右子树
                return retL;
            }
            //tail

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}