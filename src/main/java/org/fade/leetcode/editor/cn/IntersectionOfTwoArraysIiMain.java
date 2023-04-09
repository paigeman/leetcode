/**
给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数
不一致，则考虑取较小值）。可以不考虑输出结果的顺序。 

 

 示例 1： 

 
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
 

 示例 2: 

 
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9] 

 

 提示： 

 
 1 <= nums1.length, nums2.length <= 1000 
 0 <= nums1[i], nums2[i] <= 1000 
 

 

 进阶： 

 
 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
 如果 nums1 的大小比 nums2 小，哪种方法更优？ 
 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
 

 Related Topics 数组 哈希表 双指针 二分查找 排序 👍 950 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysIiMain {
      
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIiMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] intersect(int[] nums1, int[] nums2) {
//            Map<Integer, Integer> map1 = new HashMap<>(8);
//            Map<Integer, Integer> map2 = new HashMap<>(8);
//            for (int num :
//                    nums1) {
//                map1.put(num, map1.getOrDefault(num, 0) + 1);
//            }
//            for (int num :
//                    nums2) {
//                map2.put(num, map2.getOrDefault(num, 0) + 1);
//            }
//            List<Integer> ans = new ArrayList<>(8);
//            for (Map.Entry<Integer, Integer> e :
//                    map1.entrySet()) {
//                if (map2.containsKey(e.getKey())) {
//                    int occurs = Math.min(e.getValue(), map2.get(e.getKey()));
//                    for (int i = 0; i < occurs; ++i) {
//                        ans.add(e.getKey());
//                    }
//                }
//            }
//            return ans.stream().mapToInt(x -> x).toArray();
            List<Integer> ans = new ArrayList<>(8);
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    ans.add(nums1[i]);
                    ++i;
                    ++j;
                } else if (nums1[i] < nums2[j]) {
                    ++i;
                } else {
                    ++j;
                }
            }
            return ans.stream().mapToInt(x -> x).toArray();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
