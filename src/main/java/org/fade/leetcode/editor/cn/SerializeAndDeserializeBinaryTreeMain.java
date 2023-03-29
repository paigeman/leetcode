/**
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重
构得到原数据。 

 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序
列化为原始的树结构。 

 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法
解决这个问题。 

 

 示例 1： 
 
 
输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]
 

 示例 2： 

 
输入：root = []
输出：[]
 

 示例 3： 

 
输入：root = [1]
输出：[1]
 

 示例 4： 

 
输入：root = [1,2]
输出：[1,2]
 

 

 提示： 

 
 树中结点数在范围 [0, 10⁴] 内 
 -1000 <= Node.val <= 1000 
 

 Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 1079 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTreeMain {
      
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBinaryTreeMain().new Codec();
//        solution.serialize(Utils.parseToTreeNodeFromString("[1,2,3,null,null,4,5]"));
//        solution.serialize(Utils.parseToTreeNodeFromString("[]"));
        solution.serialize(Utils.parseToTreeNodeFromString("[1,2,3,null,null,4,5,6,7]"));
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
    public class Codec {

        private static final String NULL_STR = "null";

        private static final String EMPTY_STR = "";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            if (root != null) {
                int count = count(root);
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                while (!queue.isEmpty() && count > 0) {
                    int size = queue.size();
                    for (int i = 0; i < size; ++i) {
                        TreeNode poll = queue.poll();
                        if (poll != null) {
                            --count;
                            builder.append(poll.val);
                            queue.offer(poll.left);
                            queue.offer(poll.right);
                            if (count > 0) {
                                builder.append(",");
                            } else {
                                break;
                            }
                        } else {
                            builder.append(NULL_STR);
//                            queue.offer(null);
//                            queue.offer(null);
                            builder.append(",");
                        }
                    }
                }
            }
            builder.append("]");
            return builder.toString();
        }

        private int count(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + count(root.left) + count(root.right);
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String substring = data.substring(1, data.length() - 1);
            String[] split = substring.split(",");
            TreeNode root = null;
            if (split.length >= 1 && !split[0].equals(NULL_STR) && !split[0].trim().equals(EMPTY_STR)) {
                root = new TreeNode(Integer.parseInt(split[0]));
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                int index = 1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; ++i) {
                        TreeNode poll = queue.poll();
                        if (poll != null && index < split.length && !split[index].equals(NULL_STR)) {
                            TreeNode left = new TreeNode(Integer.parseInt(split[index++]));
                            poll.left = left;
                            queue.offer(left);
                        } else {
                            ++index;
                        }
                        if (poll != null && index < split.length && !split[index].equals(NULL_STR)) {
                            TreeNode right = new TreeNode(Integer.parseInt(split[index++]));
                            poll.right = right;
                            queue.offer(right);
                        } else {
                            ++index;
                        }
                    }
                }
            }
            return root;
        }

    }
    
    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    //leetcode submit region end(Prohibit modification and deletion)
        
}
