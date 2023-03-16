/**
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 

 
 

 

 示例 1： 
 
 
输入：head = [4,2,1,3]
输出：[1,2,3,4]
 

 示例 2： 
 
 
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
 

 示例 3： 

 
输入：head = []
输出：[]
 

 

 提示： 

 
 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
 -10⁵ <= Node.val <= 10⁵ 
 

 

 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 

 Related Topics 链表 双指针 分治 排序 归并排序 👍 1936 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.list.ListNode;
import org.fade.leetcode.editor.cn.util.Utils;

public class SortListMain {
      
    public static void main(String[] args) {
        Solution solution = new SortListMain().new Solution();
        solution.sortList(Utils.parseToListNodeFromString("[4,2,1,3]"));
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

        public ListNode sortList(ListNode head) {
            return partition(head, null);
        }

        private ListNode partition(ListNode start, ListNode end) {
            if (start == null) {
                return null;
            }
            if (start.next == null) {
                return start;
            }
            ListNode p = start, q = start;
            while (p != null && p.next != null && p.next.next != end) {
                q = q.next;
                p = p.next.next;
            }
            ListNode r = q.next;
            q.next = null;
            ListNode dummy = new ListNode(-1), s = dummy;
            ListNode left = partition(start, null);
            ListNode right = partition(r, end);
            while (left != null && right != null) {
                if (left.val < right.val) {
                    s.next = left;
                    left = left.next;
                } else {
                    s.next = right;
                    right = right.next;
                }
                s = s.next;
            }
            if (left != null) {
                s.next = left;
            }
            if (right != null) {
                s.next = right;
            }
            return dummy.next;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}