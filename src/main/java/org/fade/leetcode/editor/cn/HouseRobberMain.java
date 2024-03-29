/**
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小
偷闯入，系统会自动报警。 

 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 

 

 示例 1： 

 
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。 

 示例 2： 

 
输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 

 

 提示： 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 400 
 

 Related Topics 数组 动态规划 👍 2478 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class HouseRobberMain {
      
    public static void main(String[] args) {
        Solution solution = new HouseRobberMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int rob(int[] nums) {
            // 如果数组只有一个元素，nums[0]
            // 如果数组有两个元素，max(nums[0],nums[1])
            // 如果数组有三个元素，max(nums[0] + nums[2], nums[1])
            // 如果数组有四个元素，max(nums[0] + nums[2], nums[0] + nums[3], nums[1] + nums[3])
            // 如果数组有五个元素，max(nums[0] + nums[2] + nums[4], nums[0] + nums[3],
            // nums[0] + nums[4], nums[1] + nums[3], nums[1] + nums[4]...)
            return 0;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
