/**
路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
经过根节点。 

 路径和 是路径中各节点值的总和。 

 给你一个二叉树的根节点 root ，返回其 最大路径和 。 

 

 示例 1： 
 
 
输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 

 示例 2： 
 
 
输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 

 

 提示： 

 
 树中节点数目范围是 [1, 3 * 10⁴] 
 -1000 <= Node.val <= 1000 
 

 Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1868 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class BinaryTreeMaximumPathSum{
      
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        public int maxPathSum(TreeNode root) {
            return 0;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}