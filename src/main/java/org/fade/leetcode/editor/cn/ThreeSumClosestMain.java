/**
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 

 返回这三个数的和。 

 假定每组输入只存在恰好一个解。 

 

 示例 1： 

 
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 

 示例 2： 

 
输入：nums = [0,0,0], target = 1
输出：0
 

 

 提示： 

 
 3 <= nums.length <= 1000 
 -1000 <= nums[i] <= 1000 
 -10⁴ <= target <= 10⁴ 
 

 Related Topics 数组 双指针 排序 👍 1455 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosestMain {
      
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosestMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int length = nums.length;
            int ans = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < length; ++i) {
                int left = i + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(ans - target) > Math.abs(sum - target)) {
                        ans = sum;
                    }
                    if (sum > target) {
                        --right;
                    } else if (sum < target) {
                        ++left;
                    } else {
                        return ans;
                    }
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
