/**
给你一个整数数组 nums ，返回其中 按位与三元组 的数目。 

 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件： 

 
 0 <= i < nums.length 
 0 <= j < nums.length 
 0 <= k < nums.length 
 nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。 
 

 示例 1： 

 
输入：nums = [2,1,3]
输出：12
解释：可以选出如下 i, j, k 三元组：
(i=0, j=0, k=1) : 2 & 2 & 1
(i=0, j=1, k=0) : 2 & 1 & 2
(i=0, j=1, k=1) : 2 & 1 & 1
(i=0, j=1, k=2) : 2 & 1 & 3
(i=0, j=2, k=1) : 2 & 3 & 1
(i=1, j=0, k=0) : 1 & 2 & 2
(i=1, j=0, k=1) : 1 & 2 & 1
(i=1, j=0, k=2) : 1 & 2 & 3
(i=1, j=1, k=0) : 1 & 1 & 2
(i=1, j=2, k=0) : 1 & 3 & 2
(i=2, j=0, k=1) : 3 & 2 & 1
(i=2, j=1, k=0) : 3 & 1 & 2
 

 示例 2： 

 
输入：nums = [0,0,0]
输出：27
 

 

 提示： 

 
 1 <= nums.length <= 1000 
 0 <= nums[i] < 2¹⁶ 
 

 Related Topics 位运算 数组 哈希表 👍 91 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class TriplesWithBitwiseAndEqualToZeroMain {
      
    public static void main(String[] args) {
        Solution solution = new TriplesWithBitwiseAndEqualToZeroMain().new Solution();
        solution.countTriplets(Utils.parseToArrayFromString("[2,1,3]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTriplets(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(8);
            for (int num: nums) {
                // ~num
                // fixme
//                map.put(, num);
            }
            int length = nums.length;
            int ans = 0;
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    int key = nums[i] & nums[j];
                    if (map.containsKey(key)) {
                        ++ans;
                    }
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}