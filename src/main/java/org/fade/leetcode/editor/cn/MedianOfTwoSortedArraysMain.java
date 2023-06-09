/**
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 

 算法的时间复杂度应该为 O(log (m+n)) 。 

 

 示例 1： 

 
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
 

 示例 2： 

 
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 

 

 

 提示： 

 
 nums1.length == m 
 nums2.length == n 
 0 <= m <= 1000 
 0 <= n <= 1000 
 1 <= m + n <= 2000 
 -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
 

 Related Topics 数组 二分查找 分治 👍 6559 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class MedianOfTwoSortedArraysMain {
      
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArraysMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int length = m + n;
            if (length % 2 == 1) {
                int k = length / 2;
                return doFindMedianSortedArrays(nums1, nums2, k + 1);
            } else {
                int k1 = length / 2 - 1;
                int k2 = length / 2;
                return (doFindMedianSortedArrays(nums1, nums2, k1 + 1) +
                        doFindMedianSortedArrays(nums1, nums2, k2 + 1)) / 2.0;
            }
        }

        private int doFindMedianSortedArrays(int[] nums1, int[] nums2, int k) {
            int m = nums1.length;
            int n = nums2.length;
            int i = 0, j = 0;
            while (true) {
                if (i == m) {
                    return nums2[j + k - 1];
                }
                if (j == n) {
                    return nums1[i + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[i], nums2[j]);
                }
                int half = k / 2;
                int ni = Math.min(i + half, m) - 1;
                int nj = Math.min(j + half, n) - 1;
                int vni = nums1[ni], vnj = nums2[nj];
                if (vni <= vnj) {
                    k -= ni - i + 1;
                    // ni也排除掉了
                    i = ni + 1;
                } else {
                    k -= nj - j + 1;
                    j = nj + 1;
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
