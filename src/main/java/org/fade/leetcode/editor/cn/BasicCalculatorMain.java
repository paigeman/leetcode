/**
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 

 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 

 

 示例 1： 

 
输入：s = "1 + 1"
输出：2
 

 示例 2： 

 
输入：s = " 2-1 + 2 "
输出：3
 

 示例 3： 

 
输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
 

 

 提示： 

 
 1 <= s.length <= 3 * 10⁵ 
 s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
 s 表示一个有效的表达式 
 '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
 '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
 输入中不存在两个连续的操作符 
 每个数字和运行的计算将适合于一个有符号的 32位 整数 
 

 Related Topics 栈 递归 数学 字符串 👍 881 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorMain {
      
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorMain().new Solution();
//        solution.calculate("1-(     -2)");
//        solution.calculate("(1+(4+5+2)-3)+(6+8)");
        solution.calculate("-2+ 1");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int calculate(String s) {
            Deque<Integer> numberStack = new LinkedList<>();
            Deque<Character> charStack = new LinkedList<>();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    if (i > 0 && Character.isDigit(s.charAt(i - 1))) {
                        Integer pop = numberStack.pop();
                        numberStack.push(pop * 10 + Character.getNumericValue(c));
                    } else {
                        numberStack.push(Character.getNumericValue(c));
                    }
                } else if (c == '(') {
                    charStack.push(c);
                } else if (c == '+' || c == '-') {
                    Character peek = charStack.peek();
                    if (peek != null && peek != '(') {
                        Character pop = charStack.pop();
                        if (pop == '+') {
                            Integer left = numberStack.pop();
                            Integer right = numberStack.pop();
                            numberStack.push(left + right);
                        } else {
                            Integer op1 = numberStack.pop();
                            if (!numberStack.isEmpty() && pop != '#') {
                                Integer op2 = numberStack.pop();
                                numberStack.push(op2 - op1);
                            } else {
                                numberStack.push(-op1);
                            }
                        }
                    }
                    if (c == '-') {
                        int j = i;
                        while (j >= 0) {
                            if (j != i && s.charAt(j) != ' ') {
                                break;
                            }
                            --j;
                        }
                        if (j == -1 || (!Character.isDigit(s.charAt(j)) && s.charAt(j) != ')')) {
                            charStack.push('#');
                        } else {
                            charStack.push(c);
                        }
                    } else {
                        charStack.push(c);
                    }
                } else if (c == ')'){
                    while (!charStack.isEmpty() && charStack.peek() != '(') {
                        Character op = charStack.pop();
                        if (op == '+') {
                            Integer left = numberStack.pop();
                            Integer right = numberStack.pop();
                            numberStack.push(left + right);
                        } else {
                            Integer op1 = numberStack.pop();
                            if (!numberStack.isEmpty() && op != '#') {
                                Integer op2 = numberStack.pop();
                                numberStack.push(op2 - op1);
                            } else {
                                numberStack.push(-op1);
                            }
                        }
                    }
                    // 把"("排出
                    charStack.pop();
                }
            }
            while (!charStack.isEmpty()) {
                Character op = charStack.pop();
                if (op == '+') {
                    Integer left = numberStack.pop();
                    Integer right = numberStack.pop();
                    numberStack.push(left + right);
                } else {
                    Integer op1 = numberStack.pop();
                    if (!numberStack.isEmpty() && op != '#') {
                        Integer op2 = numberStack.pop();
                        numberStack.push(op2 - op1);
                    } else {
                        numberStack.push(-op1);
                    }
                }
            }
            return numberStack.pop();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
