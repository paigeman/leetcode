/**
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 

 整数除法仅保留整数部分。 

 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 

 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 

 

 示例 1： 

 
输入：s = "3+2*2"
输出：7
 

 示例 2： 

 
输入：s = " 3/2 "
输出：1
 

 示例 3： 

 
输入：s = " 3+5 / 2 "
输出：5
 

 

 提示： 

 
 1 <= s.length <= 3 * 10⁵ 
 s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
 s 表示一个 有效表达式 
 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
 题目数据保证答案是一个 32-bit 整数 
 

 Related Topics 栈 数学 字符串 👍 676 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BasicCalculatorIiMain {
      
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIiMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Map<Character, Integer> order = new HashMap<>() {{
           put('+', 1);
           put('-', 1);
           put('*', 2);
           put('/', 2);
        }};

        public int calculate(String s) {
            // 预处理
            s = s.replace(" ", "");
            Deque<Integer> numbers = new LinkedList<>();
            Deque<Character> signs = new LinkedList<>();
            // 预防第一个字符是符号
            numbers.add(0);
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '(') {
                    signs.push(c);
                } else if (c == ')') {
                    while (!signs.isEmpty() && signs.peek() != '(') {
                        Character sign = signs.pop();
                        calc(numbers, sign);
                    }
                    signs.pop();
                } else if (Character.isDigit(c)) {
                    int num = 0;
                    int j = i;
                    for (; j < s.length() && Character.isDigit(s.charAt(j)); ++j) {
                        num = num * 10 + Character.getNumericValue(s.charAt(j));
                    }
                    numbers.push(num);
                    i = j - 1;
                } else {
                    if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) {
                        numbers.push(0);
                    }
                    while (!signs.isEmpty()) {
                        Character peek = signs.peek();
                        if (order.get(peek) >= order.get(c)) {
                            calc(numbers, signs.pop());
                        } else {
                            break;
                        }
                    }
                    signs.push(c);
                }
            }
            while (!signs.isEmpty()) {
                calc(numbers, signs.pop());
            }
            return numbers.pop();
        }

        private void calc(Deque<Integer> numbers, char op) {
            if (numbers.isEmpty() || numbers.size() < 2) {
                return;
            }
            Integer right = numbers.pop();
            Integer left = numbers.pop();
            int result;
            switch (op) {
                case '+':
                   result = left + right;
                   break;
                case '-':
                    result = left - right;
                    break;
                case '*':
                    result = left * right;
                    break;
                case '/':
                    result = left / right;
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
            numbers.push(result);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
