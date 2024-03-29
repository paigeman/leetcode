/**
给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如
果不存在这样的两个单词，返回 0 。 

 

 示例 1： 

 
输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
输出：16 
解释：这两个单词为 "abcw", "xtfn"。 

 示例 2： 

 
输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
输出：4 
解释：这两个单词为 "ab", "cd"。 

 示例 3： 

 
输入：words = ["a","aa","aaa","aaaa"]
输出：0 
解释：不存在这样的两个单词。
 

 

 提示： 

 
 2 <= words.length <= 1000 
 1 <= words[i].length <= 1000 
 words[i] 仅包含小写字母 
 

 Related Topics 位运算 数组 字符串 👍 403 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class MaximumProductOfWordLengthsMain {
      
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfWordLengthsMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct(String[] words) {
            int ans = Integer.MIN_VALUE;
            int length = words.length;
            int[] nums = new int[length];
            for (int i = 0; i < length; ++i) {
                int num = 0;
                for (int j = 0; j < words[i].length(); ++j) {
                    num = num | (1 << (words[i].charAt(j) - 'a' + 1));
                }
                nums[i] = num;
            }
            for (int i = 0; i < length; ++i) {
                for (int j = i + 1; j < length; ++j) {
                    if ((nums[i] & nums[j]) == 0) {
                        int tmp = words[i].length() * words[j].length();
                        if (tmp > ans) {
                            ans = tmp;
                        }
                    }
                }
            }
            return ans == Integer.MIN_VALUE ? 0 : ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
