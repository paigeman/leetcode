/**
给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 

 

 示例 1： 

 
输入：nums = [3,2,3]
输出：[3] 

 示例 2： 

 
输入：nums = [1]
输出：[1]
 

 示例 3： 

 
输入：nums = [1,2]
输出：[1,2] 

 

 提示： 

 
 1 <= nums.length <= 5 * 10⁴ 
 -10⁹ <= nums[i] <= 10⁹ 
 

 

 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 

 Related Topics 数组 哈希表 计数 排序 👍 666 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementIiMain {
      
    public static void main(String[] args) {
        Solution solution = new MajorityElementIiMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> majorityElement(int[] nums) {
            List<Integer> ans = new ArrayList<>(8);
            int length = nums.length;
            Map<Integer, Integer> map = new HashMap<>(8);
            for (int num: nums) {
                Integer integer = map.get(num);
                if (integer == null) {
                    integer = 1;
                    map.put(num, integer);
                } else {
                    map.put(num, ++integer);
                }
                if (integer == length / 3 + 1) {
                    ans.add(num);
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
