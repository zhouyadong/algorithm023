package com.homework.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：   [589]N叉树的前序遍历
 **/


public class NAryTreePreorderTraversal {
    //给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 128 👎 0

    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
        // TO TEST
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(List<Node> children) {
            this.children = children;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {

        /**
         * 前序遍历：根左...右
         * @param root
         * @return
         */
        public List<Integer> preorder(Node root) {

            List<Integer> retList = new ArrayList<Integer>();
            if (null != root) {//节点有效
                retList.add(root.val);//优先根节点
                List<Node> children = root.children;//取出子节点
                if (null == children) {// 没有子节点
                    return retList;//返回结果
                }
                for (Node node : children) {
                    retList.addAll(this.preorder(node));//递归处理
                }
            }

            return retList;//返回处理结果
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}