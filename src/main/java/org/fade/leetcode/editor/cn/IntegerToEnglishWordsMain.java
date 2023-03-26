/**
将非负整数 num 转换为其对应的英文表示。 

 

 示例 1： 

 
输入：num = 123
输出："One Hundred Twenty Three"
 

 示例 2： 

 
输入：num = 12345
输出："Twelve Thousand Three Hundred Forty Five"
 

 示例 3： 

 
输入：num = 1234567
输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 

 

 提示： 

 
 0 <= num <= 2³¹ - 1 
 

 Related Topics 递归 数学 字符串 👍 308 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWordsMain {
      
    public static void main(String[] args) {
        Solution solution = new IntegerToEnglishWordsMain().new Solution();
        solution.numberToWords(1234567);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Map<Integer, String> map = new HashMap<>() {{
           put(0, "Zero");
           put(1, "One");
           put(2, "Two");
           put(3, "Three");
           put(4, "Four");
           put(5, "Five");
           put(6, "Six");
           put(7, "Seven");
           put(8, "Eight");
           put(9, "Nine");
           put(10, "Ten");
           put(11, "Eleven");
           put(12, "Twelve");
           put(13, "Thirteen");
           put(14, "Fourteen");
           put(15, "Fifteen");
           put(16, "Sixteen");
           put(17, "Seventeen");
           put(18, "Eighteen");
           put(19, "Nineteen");
           put(20, "Twenty");
           put(30, "Thirty");
           put(40, "Forty");
           put(50, "Fifty");
           put(60, "Sixty");
           put(70, "Seventy");
           put(80, "Eighty");
           put(90, "Ninety");
           put(100, "Hundred");
           put(1000, "Thousand");
           put(1000000, "Million");
           put(1000000000, "Billion");
        }};

        public String numberToWords(int num) {
            StringBuilder ans = new StringBuilder();
            if (num >= 1000000000) {
                int i = num / 1000000000;
                ans.append(map.get(i)).append(" ").append(map.get(1000000000));
                if (num % 1000000000 == 0) {
                    return ans.toString();
                }
                return ans.append(" ").append(numberToWords(num % 1000000000)).toString();
            } else if (num >= 1000000) {
                int i = num / 1000000;
                ans.append(numberToWords(i)).append(" ").append(map.get(1000000));
                if (num % 1000000 == 0) {
                    return ans.toString();
                }
                return ans.append(" ").append(numberToWords(num % 1000000)).toString();
            } else if (num >= 1000) {
                int i = num / 1000;
                ans.append(numberToWords(i)).append(" ").append(map.get(1000));
                if (num % 1000 == 0) {
                    return ans.toString();
                }
                return ans.append(" ").append(numberToWords(num % 1000)).toString();
            } else if (num >= 100) {
                int i = num / 100;
                ans.append(map.get(i)).append(" ").append(map.get(100));
                if (num % 100 == 0) {
                    return ans.toString();
                }
                return ans.append(" ").append(numberToWords(num % 100)).toString();
            } else if (num >= 20) {
                int i = num % 10;
                ans.append(map.get(num - i));
                if (i == 0) {
                    return ans.toString();
                }
                return ans.append(" ").append(map.get(i)).toString();
            } else {
                return map.get(num);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
