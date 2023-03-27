/**
给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回 所有
 能够得到 target 的表达式。 

 注意，返回表达式中的操作数 不应该 包含前导零。 

 

 示例 1: 

 
输入: num = "123", target = 6
输出: ["1+2+3", "1*2*3"] 
解释: “1*2*3” 和 “1+2+3” 的值都是6。
 

 示例 2: 

 
输入: num = "232", target = 8
输出: ["2*3+2", "2+3*2"]
解释: “2*3+2” 和 “2+3*2” 的值都是8。
 

 示例 3: 

 
输入: num = "3456237490", target = 9191
输出: []
解释: 表达式 “3456237490” 无法得到 9191 。
 

 

 提示： 

 
 1 <= num.length <= 10 
 num 仅含数字 
 -2³¹ <= target <= 2³¹ - 1 
 

 Related Topics 数学 字符串 回溯 👍 436 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperatorsMain {
      
    public static void main(String[] args) {
        Solution solution = new ExpressionAddOperatorsMain().new Solution();
        solution.addOperators("2147483648", -2147483648);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> addOperators(String num, int target) {
            List<String> ans = new ArrayList<>(8);
            traceback(ans, num, 0, new StringBuilder(), target);
            return ans;
        }

        private void traceback(List<String> ans, String num, int index, StringBuilder builder, int target) {
            char c = num.charAt(index);
            builder.append(c);
            if (index == num.length() - 1) {
                if (isExpressionEqualsTarget(builder.toString(), target)) {
                    ans.add(builder.toString());
                }
                builder.deleteCharAt(builder.length() - 1);
                return;
            }
            builder.append('+');
            traceback(ans, num, index + 1, builder, target);
            builder.setCharAt(builder.length() - 1, '-');
            traceback(ans, num, index + 1, builder, target);
            builder.setCharAt(builder.length() - 1, '*');
            traceback(ans, num, index + 1, builder, target);
            builder.deleteCharAt(builder.length() - 1);
            if (c != '0' || builder.length() >= 2 && Character.isDigit(builder.charAt(builder.length() - 2))) {
                traceback(ans, num, index + 1, builder, target);
            }
            builder.deleteCharAt(builder.length() - 1);
        }

        private boolean isExpressionEqualsTarget(String expression, int target) {
            Deque<Long> nums = new LinkedList<>();
            Deque<Character> ops = new LinkedList<>();
            for (int i = 0; i < expression.length(); ++i) {
                char c = expression.charAt(i);
                if (Character.isDigit(c)) {
                    long num = 0;
                    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                        num = num * 10 + Character.getNumericValue(expression.charAt(i));
                        ++i;
                    }
                    --i;
                    nums.push(num);
                } else {
                    if (c == '-' || c == '+') {
                        while (!ops.isEmpty()) {
                            Character pop = ops.pop();
                            long right = nums.pop();
                            long left = nums.pop();
                            nums.push(calc(left, right, pop));
                        }
                    }
                    ops.push(c);
                }
            }
            while (!ops.isEmpty()) {
                Character pop = ops.pop();
                long right = nums.pop();
                long left = nums.pop();
                nums.push(calc(left, right, pop));
            }
            return nums.pop() == ((long)target);
        }

        private long calc(long left, long right, char op) {
            switch (op) {
                case '+':
                    return left + right;
                case '-':
                    return left - right;
                case '*':
                    return left * right;
                default:
                    throw new UnsupportedOperationException();
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
