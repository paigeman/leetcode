/**
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 

 回文串 是正着读和反着读都一样的字符串。 

 

 示例 1： 

 
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
 

 示例 2： 

 
输入：s = "a"
输出：[["a"]]
 

 

 提示： 

 
 1 <= s.length <= 16 
 s 仅由小写英文字母组成 
 

 Related Topics 字符串 动态规划 回溯 👍 1405 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning{
      
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>(8);
            List<String> tmp = new ArrayList<>(8);
            traceback(ans, tmp, 0, 0, s);
            return ans;
        }

        private void traceback(List<List<String>> ans, List<String> tmp, int i, int j, String s) {
            if (i < j && j == s.length()) {
                return;
            }
            if (i == j && j == s.length()) {
                ans.add(new ArrayList<>(tmp));
                return;
            }
            String substring = s.substring(i, j + 1);
            if (isPalindrome(substring)) {
                tmp.add(substring);
                traceback(ans, tmp, j + 1, j + 1, s);
                tmp.remove(tmp.size() - 1);
            }
            traceback(ans, tmp, i, j + 1, s);
        }

        private boolean isPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i <= j) {
                if (s.charAt(i) == s.charAt(j)) {
                    ++i;
                    --j;
                } else {
                    return false;
                }
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}