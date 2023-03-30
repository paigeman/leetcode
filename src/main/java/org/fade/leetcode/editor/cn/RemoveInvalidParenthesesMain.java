/**
给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 

 返回所有可能的结果。答案可以按 任意顺序 返回。 

 

 示例 1： 

 
输入：s = "()())()"
输出：["(())()","()()()"]
 

 示例 2： 

 
输入：s = "(a)())()"
输出：["(a())()","(a)()()"]
 

 示例 3： 

 
输入：s = ")("
输出：[""]
 

 

 提示： 

 
 1 <= s.length <= 25 
 s 由小写英文字母以及括号 '(' 和 ')' 组成 
 s 中至多含 20 个括号 
 

 Related Topics 广度优先搜索 字符串 回溯 👍 830 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.*;

public class RemoveInvalidParenthesesMain {
      
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParenthesesMain().new Solution();
        solution.removeInvalidParentheses("n");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> removeInvalidParentheses(String s) {
            // fixme timeout
            Set<String> ans = new HashSet<>(8);
            Queue<String> queue = new LinkedList<>();
            queue.offer(s);
            while (!queue.isEmpty() && ans.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    String poll = queue.poll();
                    if (poll != null) {
                        if (isValid(poll)) {
                            ans.add(poll);
                            continue;
                        }
                        for (int j = 0; j < poll.length(); ++j) {
                            StringBuilder builder = new StringBuilder();
                            builder.append(poll, 0, j)
                                    .append(poll, j + 1, poll.length());
                            if (isValid(builder.toString())) {
                                ans.add(builder.toString());
                            } else {
                                queue.offer(builder.toString());
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(ans);
        }

        private boolean isValid(String s) {
            int val = 0;
            for (int i = 0; i < s.length() && val >= 0; ++i) {
                char c = s.charAt(i);
                if (c == '(') {
                    ++val;
                } else if (c == ')') {
                    --val;
                }
            }
            return val == 0;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
