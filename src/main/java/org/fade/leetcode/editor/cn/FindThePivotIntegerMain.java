/**
给你一个正整数 n ，找出满足下述条件的 中枢整数 x ： 

 
 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。 
 

 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。 

 

 示例 1： 

 
输入：n = 8
输出：6
解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 

 示例 2： 

 
输入：n = 1
输出：1
解释：1 是中枢整数，因为 1 = 1 。
 

 示例 3： 

 
输入：n = 4
输出：-1
解释：可以证明不存在满足题目要求的整数。 

 

 提示： 

 
 1 <= n <= 1000 
 

 Related Topics 数学 前缀和 👍 46 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class FindThePivotIntegerMain {
      
    public static void main(String[] args) {
        Solution solution = new FindThePivotIntegerMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int pivotInteger(int n) {
            // (1+x)x/2 = (x+n)(n - x + 1)/2
            // (1+x)x = (x+n)(n - x + 1)
            // x + x^2 = nx - x^2 + x + n^2 - nx + n
            // x^2 = - x^2 + n^2 + n
            // 2 * x^2 = n^2 + n
            // x^2 = (n^2 + n)/2
            // 数学
//            for (int i = 1; i <= n; ++i) {
//                if (i * i == (n * n + n) / 2) {
//                    return i;
//                }
//            }
//            return -1;
            // 前缀和
            int[] sums = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i == 0) {
                    sums[i] = i + 1;
                } else {
                    sums[i] = sums[i - 1] + i + 1;
                }
            }
            for (int i = 0; i < n; ++i) {
                if (i == 0) {
                    if (sums[n - 1] == sums[0]) {
                        return 1;
                    }
                } else {
                    if (sums[n - 1] - sums[i - 1] == sums[i]) {
                        return i + 1;
                    }
                }
            }
            return -1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
