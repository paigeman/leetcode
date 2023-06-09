/**
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 

 

 示例 1: 

 
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 

 示例 2: 

 
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 

 示例 3: 

 
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

 

 提示： 

 
 0 <= s.length <= 5 * 10⁴ 
 s 由英文字母、数字、符号和空格组成 
 

 Related Topics 哈希表 字符串 滑动窗口 👍 9212 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersMain {
      
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharactersMain().new Solution();
//        solution.lengthOfLongestSubstring("abcabcb");
        solution.lengthOfLongestSubstring("abba");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>(8);
            int left = 0, right = 0;
            int length = s.length();
            int ans = 0;
            while (left < length && right < length) {
                while (right < length && !map.containsKey(s.charAt(right))) {
                    map.put(s.charAt(right), right);
                    ++right;
                }
                if (right - left > ans) {
                    ans = right - left;
                }
                if (right < length && map.containsKey(s.charAt(right))) {
                    Integer pre = map.get(s.charAt(right));
                    for (int i = left; i <= pre; ++i) {
                        map.remove(s.charAt(i));
                    }
                    left = pre + 1;
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
