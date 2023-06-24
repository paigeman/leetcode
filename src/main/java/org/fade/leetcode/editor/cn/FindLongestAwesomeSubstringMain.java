/**
给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。 

 「超赞子字符串」需满足满足下述两个条件： 

 
 该字符串是 s 的一个非空子字符串 
 进行任意次数的字符交换后，该字符串可以变成一个回文字符串 
 

 

 示例 1： 

 输入：s = "3242415"
输出：5
解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
 

 示例 2： 

 输入：s = "12345678"
输出：1
 

 示例 3： 

 输入：s = "213123"
输出：6
解释："213123" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "231132"
 

 示例 4： 

 输入：s = "00"
输出：2
 

 

 提示： 

 
 1 <= s.length <= 10^5 
 s 仅由数字组成 
 

 Related Topics 位运算 哈希表 字符串 👍 77 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.Arrays;

public class FindLongestAwesomeSubstringMain {
      
    public static void main(String[] args) {
        Solution solution = new FindLongestAwesomeSubstringMain().new Solution();
        solution.longestAwesome("51224");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestAwesome(String s) {
            // 只允许出现最多一个奇数次数的数字，其余都是偶数
            int[] positions = new int[1 << 10];
            Arrays.fill(positions, - 1);
            int ans = 0;
            int status = 0;
            positions[0] = 0;
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                int digit = Character.digit(c, 10);
                status ^= 1 << digit;
                if (positions[status] >= 0) {
                    ans = Math.max(ans, i + 1 - positions[status]);
                } else {
                    positions[status] = i + 1;
                }
                for (int j = 0; j < 10; ++j) {
                    int tmp = status ^ (1 << j);
                    if (positions[tmp] >= 0) {
                        ans = Math.max(ans, i + 1 - positions[tmp]);
                    }
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
