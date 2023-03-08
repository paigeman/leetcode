/**
给定一个单链表 L 的头节点 head ，单链表 L 表示为： 

 
L0 → L1 → … → Ln - 1 → Ln
 

 请将其重新排列后变为： 

 
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 

 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 

 

 示例 1： 

 

 
输入：head = [1,2,3,4]
输出：[1,4,2,3] 

 示例 2： 

 

 
输入：head = [1,2,3,4,5]
输出：[1,5,2,4,3] 

 

 提示： 

 
 链表的长度范围为 [1, 5 * 10⁴] 
 1 <= node.val <= 1000 
 

 Related Topics 栈 递归 链表 双指针 👍 1149 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.list.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList{
      
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
//        solution.reorderList(Utils.parseToListNodeFromString("[1,2,3,4]"));
        solution.reorderList(Utils.parseToListNodeFromString("[1,2,3,4,5]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public void reorderList(ListNode head) {
//            ListNode p = head;
//            while (p != null) {
//                ListNode q = p, pre = null;
//                while (q.next != null) {
//                    pre = q;
//                    q = q.next;
//                }
//                if (q != p && pre != p) {
//                    q.next = p.next;
//                    p.next = q;
//                    pre.next = null;
//                    p = p.next;
//                }
//                p = p.next;
//            }
            if (head == null || head.next == null) {
                return;
            }
            ListNode p = head;
            Deque<ListNode> stack = new LinkedList<>();
            while (p != null) {
                stack.push(p);
                p = p.next;
            }
            ListNode q = head;
            while (!stack.isEmpty() && q != null && q.next != null) {
                ListNode pop = stack.pop();
                ListNode peek = stack.peek();
                if (peek != null) {
                    peek.next = pop.next;
                }
                pop.next = q.next;
                q.next = pop;
                q = q.next.next;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}