/**
给你一个数组 nums ，请你完成两类查询。 

 
 其中一类查询要求 更新 数组 nums 下标对应的值 
 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
 

 实现 NumArray 类： 

 
 NumArray(int[] nums) 用整数数组 nums 初始化对象 
 void update(int index, int val) 将 nums[index] 的值 更新 为 val 
 int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的
 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
 

 

 示例 1： 

 
输入：
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
输出：
[null, 9, null, 8]

解释：
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1,2,5]
numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 

 

 提示： 

 
 1 <= nums.length <= 3 * 10⁴ 
 -100 <= nums[i] <= 100 
 0 <= index < nums.length 
 -100 <= val <= 100 
 0 <= left <= right < nums.length 
 调用 update 和 sumRange 方法次数不大于 3 * 10⁴ 
 

 Related Topics 设计 树状数组 线段树 数组 👍 596 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

public class RangeSumQueryMutableMain {
      
    public static void main(String[] args) {
        NumArray numArray = new RangeSumQueryMutableMain().new NumArray(Utils.parseToArrayFromString("[1, 3, 5]"));
        // 返回 1 + 3 + 5 = 9
        System.out.println(numArray.sumRange(0, 2));
        // nums = [1,2,5]
        numArray.update(1, 2);
        // 返回 1 + 2 + 5 = 8
        System.out.println(numArray.sumRange(0, 2));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private final int[] c;

        private final int[] nums;
    
        public NumArray(int[] nums) {
            int length = nums.length;
            this.c = new int[length + 1];
            this.nums = new int[length + 1];
            for (int i = 0; i < length; ++i) {
                this.update(i, nums[i]);
            }
        }
        
        public void update(int index, int val) {
            ++index;
            int k = val - this.nums[index];
            this.nums[index] = val;
            while (index < this.c.length) {
                this.c[index] += k;
                index += this.lowBit(index);
            }
        }
        
        public int sumRange(int left, int right) {
            return this.getSum(right + 1) - this.getSum(left);
        }

        private int getSum(int index) {
            int ans = 0;
            while (index >= 1) {
                ans += this.c[index];
                index -= lowBit(index);
            }
            return ans;
        }

        private int lowBit(int x) {
            return x & (-x);
        }

    }
    
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */
    //leetcode submit region end(Prohibit modification and deletion)
        
}
