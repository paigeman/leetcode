/**
给定一个长度为 n 的链表 head 

 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 

 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设
置 answer[i] = 0 。 

 

 示例 1： 

 

 
输入：head = [2,1,5]
输出：[5,5,0]
 

 示例 2： 

 

 
输入：head = [2,7,4,3,5]
输出：[7,0,5,5,0]
 

 

 提示： 

 
 链表中节点数为 n 
 1 <= n <= 10⁴ 
 1 <= Node.val <= 10⁹ 
 

 Related Topics 栈 数组 链表 单调栈 👍 279 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.list.ListNode;
import org.fade.leetcode.editor.cn.util.Utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NextGreaterNodeInLinkedListMain {
      
    public static void main(String[] args) {
        Solution solution = new NextGreaterNodeInLinkedListMain().new Solution();
//        solution.nextLargerNodes(Utils.parseToListNodeFromString("[2,1,5]"));
//        solution.nextLargerNodes(Utils.parseToListNodeFromString("[2,7,4,3,5]"));
//        solution.nextLargerNodes(Utils.parseToListNodeFromString("[1,7,5,1,9,2,5,1]"));
        solution.nextLargerNodes(Utils.parseToListNodeFromString("[9,7,6,7,6,9]"));
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

        public int[] nextLargerNodes(ListNode head) {
            List<Integer> ans = new ArrayList<>(8);
            Deque<Integer> stack1 = new LinkedList<>();
            Deque<Integer> stack2 = new LinkedList<>();
            int index = 0;
            ListNode p = head;
            while (p != null) {
                // 每次进循环前往ans加个元素可以避免数组越界问题，也不用像下面这么写
                while (!stack1.isEmpty() && stack1.peek() < p.val) {
                    stack1.pop();
                    Integer pop = stack2.pop();
                    while (ans.size() <= pop) {
                        ans.add(p.val);
                    }
                    ans.set(pop, p.val);
                }
                stack1.push(p.val);
                stack2.push(index);
                p = p.next;
                ++index;
            }
            while (!stack1.isEmpty()) {
                stack1.pop();
                Integer pop = stack2.pop();
                while (ans.size() <= pop) {
                    ans.add(0);
                }
                ans.set(pop, 0);
            }
            return ans.stream().mapToInt(x -> x).toArray();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
