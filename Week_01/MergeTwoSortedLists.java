//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1458 👎 0

package com.homework.week01;
//Java：合并两个有序链表
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();

        ListNode l1 = new ListNode(1,new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3, new ListNode(4)));
        ListNode ret = solution.mergeTwoLists(l1,l2);
        System.out.println(ret);
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for singly-linked list.
 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    // 1、递归比较依次节点
    // 2、新建一个ListNode：每次取l1和l2中较小者依次类推
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode prehead = new ListNode(-1);//容器

            ListNode tem = prehead;//定义操作对象
            while (l1 != null && l2 != null) {//可以继续对比
                if (l1.val <= l2.val) {//找出较小者
                    tem.next = l1;//将较小者赋值tem.next
                    l1 = l1.next;//继续遍历较小者下一位
                } else {
                    tem.next = l2;//获取较小者
                    l2 = l2.next;//继续
                }
                tem = tem.next;
            }

            tem.next = l1 == null ? l2 : l1;

            return prehead.next;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}