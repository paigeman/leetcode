/**
给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。 


 

 示例 1： 

 
输入：left = 5, right = 7
输出：4
 

 示例 2： 

 
输入：left = 0, right = 0
输出：0
 

 示例 3： 

 
输入：left = 1, right = 2147483647
输出：0
 

 

 提示： 

 
 0 <= left <= right <= 2³¹ - 1 
 

 Related Topics 位运算 👍 441 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class BitwiseAndOfNumbersRangeMain {
      
    public static void main(String[] args) {
        Solution solution = new BitwiseAndOfNumbersRangeMain().new Solution();
        solution.rangeBitwiseAnd(5, 7);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int rangeBitwiseAnd(int left, int right) {
            int ans = 0;
            for (int i = 30; i >= 0; --i) {
                int mask = 1 << i;
                if ((left & mask) == (right & mask)) {
                    if ((left & mask) == mask) {
                        ans |= mask;
                    }
                } else {
                    break;
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
