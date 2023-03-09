/**
给定单个链表的头
 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。 

 插入排序 算法的步骤: 

 
 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
 重复直到所有输入数据插入完为止。 
 

 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 

 对链表进行插入排序。 

 

 

 示例 1： 

 

 
输入: head = [4,2,1,3]
输出: [1,2,3,4] 

 示例 2： 

 

 
输入: head = [-1,5,3,4,0]
输出: [-1,0,3,4,5] 

 

 提示： 

 
 

 
 列表中的节点数在 [1, 5000]范围内 
 -5000 <= Node.val <= 5000 
 

 Related Topics 链表 排序 👍 595 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortList{
      
    public static void main(String[] args) {
        Solution solution = new InsertionSortList().new Solution();
        solution.insertionSortList(Utils.parseToListNodeFromString("[4,2,1,3]"));
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

        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(-1, head);
            ListNode p = head, q = dummy;
            List<ListNode> list = new ArrayList<>(8);
            list.add(dummy);
            int index = 1;
            while (p != null) {
                // NOTE: 插入排序在此时并不意味着就要从后面往前找
                ListNode r = q;
                int i = index - 2;
                for (; i >= 0 && p.val < r.val; --i) {
                    r = list.get(i);
                }
                if (r != q) {
                    list.add(i + 2, p);
                    q.next = p.next;
                    p.next = r.next;
                    r.next = p;
                    p = q.next;
                } else {
                    list.add(p);
                    q = p;
                    p = p.next;
                }
                ++index;
            }
            return dummy.next;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}