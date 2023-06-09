/**
给你一个字符串 s，找到 s 中最长的回文子串。 

 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 

 

 示例 1： 

 
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
 

 示例 2： 

 
输入：s = "cbbd"
输出："bb"
 

 

 提示： 

 
 1 <= s.length <= 1000 
 s 仅由数字和英文字母组成 
 

 Related Topics 字符串 动态规划 👍 6560 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class LongestPalindromicSubstringMain {
      
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstringMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {
            int length = s.length();
            int maxLength = 1;
            int maxStart = 0;
            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length; ++i) {
                dp[i][i] = true;
            }
            // 枚举长度
            for (int i = 2; i <= length; ++i) {
                // 枚举左区间
                // j = length - i
                //     length - i + i - 1 = length - 1
                for (int j = 0; j <= length - i; ++j) {
                    int right = j + i - 1;
                    if (s.charAt(j) != s.charAt(right)) {
                        dp[j][right] = false;
                    } else {
                        if (i == 2) {
                            dp[j][right] = true;
                        } else {
                            dp[j][right] = dp[j + 1][right -1];
                        }
                    }
                    if (dp[j][right] && i > maxLength) {
                        maxLength = i;
                        maxStart = j;
                    }
                }
            }
            return s.substring(maxStart, maxStart + maxLength);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
