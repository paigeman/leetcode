/**
给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 

 

 示例 1： 

 
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 

 示例 2: 

 
输入: nums = [1,2,3,4], k = 3
输出: false 

 

 提示： 

 
 1 <= k <= len(nums) <= 16 
 0 < nums[i] < 10000 
 每个元素的频率在 [1,4] 范围内 
 

 Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 938 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionToKEqualSumSubsetsMain {
      
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsetsMain().new Solution();
        solution.canPartitionKSubsets(Utils.parseToArrayFromString("[4,3,2,3,5,2,1]"), 4);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = Arrays.stream(nums).reduce(0, Integer::sum);
            if (sum % k != 0) {
                return false;
            }
            List<Integer> list = new ArrayList<>() {{
                for (int i = 0; i < k; ++i) {
                    add(sum / k);
                }
            }};
            return traceback(list, 0, k, nums, sum);
        }

        private boolean traceback(List<Integer> list, int i, int k, int[] nums, int sum) {
            if (i == nums.length) {
//                return list.stream().filter(x -> x == 0).count() == k;
                return true;
            }
            if (nums[i] > sum / k) {
                return false;
            }
            for (int j = 0; j < k; ++j) {
                if (j > 0 && list.get(j).equals(list.get(j - 1))) {
                    continue;
                }
                if (list.get(j) >= nums[i]) {
                    list.set(j, list.get(j) - nums[i]);
                    if (traceback(list, i + 1, k, nums, sum)) {
                        return true;
                    }
                    list.set(j, list.get(j) + nums[i]);
                }
            }
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
