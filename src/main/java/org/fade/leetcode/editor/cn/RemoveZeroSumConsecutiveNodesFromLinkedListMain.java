/**
给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。 

 删除完毕后，请你返回最终结果链表的头节点。 

 

 你可以返回任何满足题目要求的答案。 

 （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 

 示例 1： 

 输入：head = [1,2,-3,3,1]
输出：[3,1]
提示：答案 [1,2,1] 也是正确的。
 

 示例 2： 

 输入：head = [1,2,3,-3,4]
输出：[1,2,4]
 

 示例 3： 

 输入：head = [1,2,3,-3,-2]
输出：[1]
 

 

 提示： 

 
 给你的链表中可能有 1 到 1000 个节点。 
 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
 

 Related Topics 哈希表 链表 👍 287 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.list.ListNode;
import org.fade.leetcode.editor.cn.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedListMain {
      
    public static void main(String[] args) {
        Solution solution = new RemoveZeroSumConsecutiveNodesFromLinkedListMain().new Solution();
        solution.removeZeroSumSublists(Utils.parseToListNodeFromString("[1,2,3,-3,4]"));
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

        public ListNode removeZeroSumSublists(ListNode head) {
            Map<Integer, ListNode> map = new HashMap<>(8);
            ListNode dummy = new ListNode(0, head);
            ListNode p = dummy;
            int sum = 0;
            while (p != null) {
                sum += p.val;
                map.put(sum, p);
                p = p.next;
            }
            p = dummy;
            sum = 0;
            while (p != null) {
                sum += p.val;
                p.next = map.get(sum).next;
                p = p.next;
            }
            return dummy.next;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
