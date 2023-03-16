/**
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 

 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 

 

 示例 1： 

 
输入：nums = [10,2]
输出："210" 

 示例 2： 

 
输入：nums = [3,30,34,5,9]
输出："9534330"
 

 

 提示： 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 10⁹ 
 

 Related Topics 贪心 数组 字符串 排序 👍 1098 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumberMain {
      
    public static void main(String[] args) {
        Solution solution = new LargestNumberMain().new Solution();
//        solution.largestNumber(Utils.parseToArrayFromString("[432,43243]"));
        solution.largestNumber(Utils.parseToArrayFromString("[8308,8308,830]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String largestNumber(int[] nums) {
            if (nums[0] == 0 && Arrays.stream(nums).distinct().count() == 1) {
                return "0";
            }
            return Arrays.stream(nums).mapToObj(Integer::toString)
                    .sorted(this::compare)
                    .collect(Collectors.joining());
        }

        private int compare(String x, String y) {
            while (true) {
                boolean flag = true;
                while (!x.equals(y) && x.startsWith(y)) {
                    flag = false;
                    x = x.substring(y.length());
                }
                while (!x.equals(y) && y.startsWith(x)) {
                    flag = false;
                    y = y.substring(x.length());
                }
                if (flag) {
                    break;
                }
            }
            return y.compareTo(x);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}