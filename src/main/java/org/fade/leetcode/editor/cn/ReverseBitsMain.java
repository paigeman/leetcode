/**
颠倒给定的 32 位无符号整数的二进制位。 

 提示： 

 
 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是
无符号的，其内部的二进制表示形式都是相同的。 
 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。 
 

 

 示例 1： 

 
输入：n = 00000010100101000001111010011100
输出：964176192 (00111001011110000010100101000000)
解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。 

 示例 2： 

 
输入：n = 11111111111111111111111111111101
输出：3221225471 (10111111111111111111111111111111)
解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。 

 

 提示： 

 
 输入是一个长度为 32 的二进制字符串 
 

 

 进阶: 如果多次调用这个函数，你将如何优化你的算法？ 

 Related Topics 位运算 分治 👍 610 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class ReverseBitsMain {
      
    public static void main(String[] args) {
        Solution solution = new ReverseBitsMain().new Solution();
//        solution.reverseBits(Integer.parseInt("00000010100101000001111010011100", 2));
//        solution.reverseBits(-3);
        solution.reverseBits(-Integer.parseInt("01010101010101010101010101010110", 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            // 4 / 2 = 2 ... 0
            // 2 / 2 = 1 ... 0
            // 1 / 2 = 0 ... 1
//            new StringBuilder(Integer.toBinaryString(n)).reverse().
            if (n == Integer.MIN_VALUE) {
                return 1;
            }
            boolean neg = false;
            if (n < 0) {
                neg = true;
                n = -n;
            }
            int ans = 0;
            int count = 0;
            int carry = 1;
            while ((n + 1) / 2 != 0) {
                if (neg) {
                    ans = (ans << 1) + ((1 ^ (n % 2)) ^ carry);
                    carry = (1 ^ (n % 2)) & carry;
                } else {
                    ans = (ans << 1) + (n % 2);
                }
                n /= 2;
                ++count;
            }
            while (count <= 31) {
                if (neg) {
                    ans = (ans << 1) + (1 ^ carry);
                    carry = 1 & carry;
                } else {
                    ans = ans << 1;
                }
                ++count;
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}