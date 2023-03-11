/**
给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。 

 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。 

 子数组 定义为原数组中连续的一组元素。 

 

 示例 1： 

 输入：nums = [3,1,4,2], p = 6
输出：1
解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 

 示例 2： 

 输入：nums = [6,3,5,2], p = 9
输出：2
解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 

 示例 3： 

 输入：nums = [1,2,3], p = 3
输出：0
解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 

 示例 4： 

 输入：nums = [1,2,3], p = 7
输出：-1
解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 

 示例 5： 

 输入：nums = [1000000000,1000000000,1000000000], p = 3
输出：0
 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 1 <= nums[i] <= 10⁹ 
 1 <= p <= 10⁹ 
 

 Related Topics 数组 哈希表 前缀和 👍 130 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class MakeSumDivisibleByPMain {
      
    public static void main(String[] args) {
        Solution solution = new MakeSumDivisibleByPMain().new Solution();
        solution.minSubarray(Utils.parseToArrayFromString("[4,4,2]"), 7);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minSubarray(int[] nums, int p) {
            int length = nums.length;
            long[] sum = new long[length];
            for (int i = 0; i < length; ++i) {
                if (i > 0) {
                    sum[i] = sum[i - 1] + nums[i];
                } else {
                    sum[i] = nums[i];
                }
            }
            if (sum[length - 1] < p) {
                return -1;
            }
            if (sum[length - 1] % p == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < length; ++i) {
                for (int j = i; j < length; ++j) {
                    if (i == 0) {
                        long tmp = sum[length - 1] - sum[j];
                        if (tmp < p) {
                            break;
                        }
                        if (tmp % p == 0 && j + 1 < ans && j != length - 1) {
                            ans = j + 1;
                        }
                    } else {
                        long tmp = sum[length - 1] - (sum[j] - sum[i - 1]);
                        if (tmp < p) {
                            break;
                        }
                        if (tmp % p == 0 && j - i + 1 < ans) {
                            ans = j - i + 1;
                        }
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}