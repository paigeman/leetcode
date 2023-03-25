/**
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个
节点也可以是它自己的祖先）。” 

 

 示例 1： 
 
 
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 

 示例 2： 
 
 
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 

 示例 3： 

 
输入：root = [1,2], p = 1, q = 2
输出：1
 

 

 提示： 

 
 树中节点数目在范围 [2, 10⁵] 内。 
 -10⁹ <= Node.val <= 10⁹ 
 所有 Node.val 互不相同 。 
 p != q 
 p 和 q 均存在于给定的二叉树中。 
 

 Related Topics 树 深度优先搜索 二叉树 👍 2204 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTreeMain {
      
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTreeMain().new Solution();
        TreeNode treeNode = Utils.parseToTreeNodeFromString("[3,5,1,6,2,0,8,null,null,7,4]");

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> p_path = new ArrayList<>(8);
            List<TreeNode> q_path = new ArrayList<>(8);
            getPath(p_path, root, p);
            getPath(q_path, root, q);
            TreeNode ans = null;
            int i = 0;
            while (i < p_path.size() && i < q_path.size()) {
                if (p_path.get(i).equals(q_path.get(i))) {
                    ans = p_path.get(i);
                } else {
                    break;
                }
                ++i;
            }
            return ans;
        }

        private void getPath(List<TreeNode> path, TreeNode root, TreeNode treeNode) {
            if (root != null) {
                path.add(root);
                if (root.equals(treeNode)) {
                    return;
                }
                getPath(path, root.left, treeNode);
                if (path.get(path.size() - 1).equals(treeNode)) {
                    return;
                }
                getPath(path, root.right, treeNode);
                if (path.get(path.size() - 1).equals(treeNode)) {
                    return;
                }
                path.remove(path.size() - 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
