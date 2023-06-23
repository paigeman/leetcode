/**
给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。 

 

 示例 1： 

 
输入：s = "eleetminicoworoep"
输出：13
解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 

 示例 2： 

 
输入：s = "leetcodeisgreat"
输出：5
解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 

 示例 3： 

 
输入：s = "bcbcbc"
输出：6
解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 

 

 提示： 

 
 1 <= s.length <= 5 x 10^5 
 s 只包含小写英文字母。 
 

 Related Topics 位运算 哈希表 字符串 前缀和 👍 451 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.Arrays;

public class FindTheLongestSubstringContainingVowelsInEvenCountsMain {
      
    public static void main(String[] args) {
        Solution solution = new FindTheLongestSubstringContainingVowelsInEvenCountsMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findTheLongestSubstring(String s) {
            int length = s.length();
            int ans = 0, status = 0;
            int[] pos = new int[32];
            Arrays.fill(pos, -1);
            pos[0] = 0;
            for (int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                switch (c) {
                    case 'a': status ^= 1;
                    break;
                    case 'e': status ^= 1 << 1;
                    break;
                    case 'i': status ^= 1 << 2;
                    break;
                    case 'o': status ^= 1 << 3;
                    break;
                    case 'u': status ^= 1 << 4;
                    break;
                    default:
                }
                if (pos[status] >= 0) {
                    ans = Math.max(ans, i + 1 - pos[status]);
                } else {
                    pos[status] = i + 1;
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
