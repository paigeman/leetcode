/**
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 

 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 

 

 示例 1: 

 
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
 

 示例 2: 

 
输入: nums = [0]
输出: [0] 

 

 提示: 
 

 
 1 <= nums.length <= 10⁴ 
 -2³¹ <= nums[i] <= 2³¹ - 1 
 

 

 进阶：你能尽量减少完成的操作次数吗？ 

 Related Topics 数组 双指针 👍 1939 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class MoveZeroesMain {
      
    public static void main(String[] args) {
        Solution solution = new MoveZeroesMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void moveZeroes(int[] nums) {
            int i = 0, j = 0;
            int length = nums.length;
            while (i < length && j < length) {
                // 找0
                while (i < length && nums[i] != 0) {
                    ++i;
                }
                // 找非0
                while (j < length && nums[j] == 0) {
                    ++j;
                }
                if (i < length && j < length) {
                    if (i < j) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        ++i;
                    }
                    ++j;
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
