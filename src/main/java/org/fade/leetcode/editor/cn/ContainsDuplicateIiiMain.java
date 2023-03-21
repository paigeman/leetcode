/**
给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t 
，同时又满足 abs(i - j) <= k 。 

 如果存在则返回 true，不存在返回 false。 

 

 示例 1： 

 
输入：nums = [1,2,3,1], k = 3, t = 0
输出：true 

 示例 2： 

 
输入：nums = [1,0,1,1], k = 1, t = 2
输出：true 

 示例 3： 

 
输入：nums = [1,5,9,1,5,9], k = 2, t = 3
输出：false 

 

 提示： 

 
 0 <= nums.length <= 2 * 10⁴ 
 -2³¹ <= nums[i] <= 2³¹ - 1 
 0 <= k <= 10⁴ 
 0 <= t <= 2³¹ - 1 
 

 Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 681 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.PriorityQueue;
import java.util.Queue;

public class ContainsDuplicateIiiMain {
      
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIiiMain().new Solution();
//        solution.containsNearbyAlmostDuplicate(Utils.parseToArrayFromString("[1,5,9,1,5,9]"), 2, 3);
        solution.containsNearbyAlmostDuplicate(Utils.parseToArrayFromString("[1,2,2,3,1]"), 3, 0);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            Queue<Integer> pile = new PriorityQueue<>();
            for (int i = 0; i < nums.length; ++i) {
                if (i > indexDiff && pile.size() > 0) {
                    pile.remove(nums[i - indexDiff - 1]);
                }
                pile.offer(nums[i]);
                if (pile.size() > 1) {
                    Integer min = pile.poll();
                    Integer nextMin = pile.poll();
                    if (min != null && nextMin != null && nextMin - min <= valueDiff) {
                        return true;
                    }
                    pile.offer(min);
                    pile.offer(nextMin);
                }
            }
            while (!pile.isEmpty()) {
                Integer min = pile.poll();
                Integer nextMin = pile.peek();
                if (min != null && nextMin != null && nextMin - min <= valueDiff) {
                    return true;
                }
            }
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
