/**
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 

 返回符合要求的 最少分割次数 。 

 
 
 
 
 

 示例 1： 

 
输入：s = "aab"
输出：1
解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 

 示例 2： 

 
输入：s = "a"
输出：0
 

 示例 3： 

 
输入：s = "ab"
输出：1
 

 

 提示： 

 
 1 <= s.length <= 2000 
 s 仅由小写英文字母组成 
 

 Related Topics 字符串 动态规划 👍 650 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.Arrays;

public class PalindromePartitioningIiMain {
      
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIiMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minCut(String s) {
            int length = s.length();
            boolean[][] isPalindrome = new boolean[length][length];
            preHandle(s, isPalindrome);
            return 0;
        }

        private void preHandle(String s, boolean[][] isPalindrome) {
            int length = isPalindrome.length;
            for (int i = 0; i < length; ++i) {
                Arrays.fill(isPalindrome[i], true);
            }
            for (int i = length - 1; i >= 0; --i) {
                for (int j = i + 1; j < length; ++j) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}