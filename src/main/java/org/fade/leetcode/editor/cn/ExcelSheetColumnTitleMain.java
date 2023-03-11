/**
给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 

 例如： 

 
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

 

 示例 1： 

 
输入：columnNumber = 1
输出："A"
 

 示例 2： 

 
输入：columnNumber = 28
输出："AB"
 

 示例 3： 

 
输入：columnNumber = 701
输出："ZY"
 

 示例 4： 

 
输入：columnNumber = 2147483647
输出："FXSHRXW"
 

 

 提示： 

 
 1 <= columnNumber <= 2³¹ - 1 
 

 Related Topics 数学 字符串 👍 604 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class ExcelSheetColumnTitleMain {
      
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitleMain().new Solution();
        solution.convertToTitle(52);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String convertToTitle(int columnNumber) {
            StringBuilder builder = new StringBuilder();
            // 10 / 2 = 5 ... 0
            // 5 / 2 = 2 ... 1
            // 2 / 2 = 1 ... 0
            // 1 / 2 = 0 ... 1
            while ((columnNumber - 1) / 26 >= 1) {
                char c = (char) ('A' + ((columnNumber - 1) % 26));
                builder.append(c);
                columnNumber = (columnNumber - 1) / 26;
            }
            builder.append((char) ('A' + ((columnNumber - 1) % 26)));
            return builder.reverse().toString();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}