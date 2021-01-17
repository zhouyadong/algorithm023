package com.homework.week03;

import java.util.Arrays;

/**
 * Java：   [105]从前序与中序遍历序列构造二叉树
 **/


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 828 👎 0

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        //前序：根-左-右
        //中序：左-根-右
        //将两个数组分为左子树部分和右子树部分，递归处理完preorder或inorder时，完成tree
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            TreeNode treeNode = null;
            //terminator
            int len = preorder.length;//两个数组的长度必然一致：因为遍历的顺序不会影响总数
            if (0 == len) {
                return treeNode;
            }
            treeNode = new TreeNode(preorder[0]);//跟节点
            for (int i = 0; i < len; i++) {
                if (inorder[i] == preorder[0]) {//找到中序中根节点的位置
                    int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);//中序：左子树
                    int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, len);//中序：右子树
                    int[] preorderLeft = Arrays.copyOfRange(preorder, 1, i + 1);//前序：左子树
                    int[] preorderRight = Arrays.copyOfRange(preorder, i + 1, len);//前序：右子树
                    treeNode.left = this.buildTree(preorderLeft, inorderLeft);
                    treeNode.right = this.buildTree(preorderRight, inorderRight);
                    break;//每一层跟节点只会有一个
                }
            }

            return treeNode;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}