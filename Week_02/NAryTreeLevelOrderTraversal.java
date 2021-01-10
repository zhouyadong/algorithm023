package com.homework.week02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
* Java：   [429]N 叉树的层序遍历
**/


public class NAryTreeLevelOrderTraversal {
    //给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 
// 👍 126 👎 0

    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
        // TO TEST
    }
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
    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//};

class Solution {

    //广度优先
    //每个节点都要处理：时间复杂度O(n)
    //每个节点都要记录：空间复杂度O(n)
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if (null != root) {
            Deque<Node> deque = new LinkedList<Node>();//记录当前层的node
            deque.offer(root);

            while (!deque.isEmpty()) {//最后一层处理完后结束
                int size = deque.size();//deque中的size个为当前层，因为在后续处理过程中，会有下一层的子节点入队
                List<Integer> temList = new ArrayList<Integer>();
                while (size > 0) {//当前层
                    Node node = deque.poll();//弹出队首
                    if (null != node) {
                        temList.add(node.val);//记录
                        List<Node> children = node.children;//将下一层的子节点入队
                        if (null != children) {
                            for (Node child : children) {
                                if (null != child) {
                                    deque.offer(child);
                                }
                            }
                        }
                    }
                    size --;
                }
                retList.add(temList);//当前层size个处理完
            }
        }
        return retList;
    }




}
//leetcode submit region end(Prohibit modification and deletion)

    
}