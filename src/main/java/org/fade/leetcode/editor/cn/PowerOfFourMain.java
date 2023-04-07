/**
给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。 

 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4ˣ 

 

 示例 1： 

 
输入：n = 16
输出：true
 

 示例 2： 

 
输入：n = 5
输出：false
 

 示例 3： 

 
输入：n = 1
输出：true
 

 

 提示： 

 
 -2³¹ <= n <= 2³¹ - 1 
 

 

 进阶：你能不使用循环或者递归来完成本题吗？ 

 Related Topics 位运算 递归 数学 👍 339 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class PowerOfFourMain {
      
    public static void main(String[] args) {
        Solution solution = new PowerOfFourMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPowerOfFour(int n) {
//            return n == 1 || (n > 0 && n % 4 == 0 && isPowerOfFour(n / 4));
            // 0000,0000,0000,0000,0000,0000,0000,0001
            // 0000,0000,0000,0000,0000,0000,0000,0100
            // 0000,0000,0000,0000,0000,0000,0001,0000
            // 0000,0000,0000,0000,0000,0000,0100,0000
            return n == 0x1 || n == 0x4 || n == 0x10 || n == 0x40 ||
                    n == 0x100 || n == 0x400 || n == 0x1000 || n == 0x4000 ||
                    n == 0x10000 || n == 0x40000 || n == 0x100000 || n == 0x400000 ||
                    n == 0x1000000 || n == 0x4000000 || n == 0x10000000 || n == 0x40000000;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
