/**
给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 
arr 的最大排列。 

 如果无法这么操作，就请返回原数组。 

 

 示例 1： 

 
输入：arr = [3,2,1]
输出：[3,1,2]
解释：交换 2 和 1
 

 示例 2： 

 
输入：arr = [1,1,5]
输出：[1,1,5]
解释：已经是最小排列
 

 示例 3： 

 
输入：arr = [1,9,4,6,7]
输出：[1,7,4,6,9]
解释：交换 9 和 7
 

 

 提示： 

 
 1 <= arr.length <= 10⁴ 
 1 <= arr[i] <= 10⁴ 
 

 Related Topics 贪心 数组 👍 94 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

public class PreviousPermutationWithOneSwapMain {
      
    public static void main(String[] args) {
        Solution solution = new PreviousPermutationWithOneSwapMain().new Solution();
        solution.prevPermOpt1(Utils.parseToArrayFromString("[1, 1, 5]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] prevPermOpt1(int[] arr) {
            int length = arr.length;
            int left = -1;
            int right = length;
            for (int i = length - 1; i > left; --i) {
                if (i > 0 && arr[i] == arr[i - 1]) {
                    continue;
                }
                for (int j = i - 1; j > left; --j) {
                    if (arr[i] < arr[j]) {
                        left = j;
                        right = i;
                        break;
                    } else if (arr[i] == arr[j]) {
                        break;
                    }
                }
            }
            if (left != -1) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
            return arr;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
