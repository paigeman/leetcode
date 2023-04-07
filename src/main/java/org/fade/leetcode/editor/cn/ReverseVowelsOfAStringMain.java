/**
给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 

 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 

 

 示例 1： 

 
输入：s = "hello"
输出："holle"
 

 示例 2： 

 
输入：s = "leetcode"
输出："leotcede" 

 

 提示： 

 
 1 <= s.length <= 3 * 10⁵ 
 s 由 可打印的 ASCII 字符组成 
 

 Related Topics 双指针 字符串 👍 287 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAStringMain {
      
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAStringMain().new Solution();
        solution.reverseVowels("a.");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseVowels(String s) {
            Set<Character> set = new HashSet<>() {{
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
                add('A');
                add('E');
                add('I');
                add('O');
                add('U');
            }};
            int left = 0, right = s.length() - 1;
            StringBuilder lb = new StringBuilder();
            StringBuilder rb = new StringBuilder();
            while (left <= right) {
                while (left <= right && !set.contains(s.charAt(left))) {
                    lb.append(s.charAt(left));
                    ++left;
                }
                while (left <= right && !set.contains(s.charAt(right))) {
                    rb.insert(0, s.charAt(right));
                    --right;
                }
                if (left < right) {
                    lb.append(s.charAt(right));
                    rb.insert(0, s.charAt(left));
                    ++left;
                    --right;
                } else if (left == right) {
                    lb.append(s.charAt(left));
                    ++left;
                }
            }
            return lb.append(rb).toString();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
