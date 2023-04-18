/**
设计一个数据结构，有效地找到给定子数组的 多数元素 。 

 子数组的 多数元素 是在子数组中出现 threshold 次数或次数以上的元素。 

 实现 MajorityChecker 类: 

 
 MajorityChecker(int[] arr) 会用给定的数组 arr 对 MajorityChecker 初始化。 
 int query(int left, int right, int threshold) 返回子数组中的元素 arr[left...right] 至少出现 
threshold 次数，如果不存在这样的元素则返回 -1。 
 

 

 示例 1： 

 
输入:
["MajorityChecker", "query", "query", "query"]
[[[1, 1, 2, 2, 1, 1]], [0, 5, 4], [0, 3, 3], [2, 3, 2]]
输出：
[null, 1, -1, 2]

解释：
MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
majorityChecker.query(0,5,4); // 返回 1
majorityChecker.query(0,3,3); // 返回 -1
majorityChecker.query(2,3,2); // 返回 2
 

 

 提示： 

 
 1 <= arr.length <= 2 * 10⁴ 
 1 <= arr[i] <= 2 * 10⁴ 
 0 <= left <= right < arr.length 
 threshold <= right - left + 1 
 2 * threshold > right - left + 1 
 调用 query 的次数最多为 10⁴ 
 

 Related Topics 设计 树状数组 线段树 数组 二分查找 👍 124 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class OnlineMajorityElementInSubarrayMain {
      
    public static void main(String[] args) {
//        MajorityChecker majorityChecker = new OnlineMajorityElementInSubarrayMain().new MajorityChecker();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class MajorityChecker {
    
        public MajorityChecker(int[] arr) {
    
        }
        
        public int query(int left, int right, int threshold) {
            return 0;
        }

    }
    
    /**
     * Your MajorityChecker object will be instantiated and called as such:
     * MajorityChecker obj = new MajorityChecker(arr);
     * int param_1 = obj.query(left,right,threshold);
     */
    //leetcode submit region end(Prohibit modification and deletion)
        
}
