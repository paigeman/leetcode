/**
给定一个三角形 triangle ，找出自顶向下的最小路径和。 

 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位
于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 

 

 示例 1： 

 
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 

 示例 2： 

 
输入：triangle = [[-10]]
输出：-10
 

 

 提示： 

 
 1 <= triangle.length <= 200 
 triangle[0].length == 1 
 triangle[i].length == triangle[i - 1].length + 1 
 -10⁴ <= triangle[i][j] <= 10⁴ 
 

 

 进阶： 

 
 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
 

 Related Topics 数组 动态规划 👍 1176 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.List;

public class TriangleMain {
      
    public static void main(String[] args) {
        Solution solution = new TriangleMain().new Solution();
        solution.minimumTotal(Utils.parseToListListFromString("[[2],[3,4],[6,5,7],[4,1,8,3]]", Integer::parseInt, Utils.INT_PATTERN));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int size = triangle.size();
//            int[][] state = new int[size][];
//            state[0] = new int[] {triangle.get(0).get(0)};
//            for (int i = 1; i < size; ++i) {
//                List<Integer> level = triangle.get(i);
//                int lSize = level.size();
//                state[i] = new int[lSize];
//                for (int j = 0; j < lSize; ++j) {
//                    Integer ele = level.get(j);
//                    if (j == 0) {
//                        state[i][j] = state[i - 1][j] + ele;
//                    } else if (j == lSize - 1) {
//                        state[i][j] = state[i - 1][j - 1] + ele;
//                    } else {
//                        state[i][j] = Math.min(state[i - 1][j - 1] + ele, state[i - 1][j] + ele);
//                    }
//                }
//            }
//            int ans = Integer.MAX_VALUE;
//            for (int ele: state[size - 1]) {
//                if (ans > ele) {
//                    ans = ele;
//                }
//            }
//            return ans;
            int[] state = new int[size];
            state[0] = triangle.get(0).get(0);
            for (int i = 1; i < size; ++i) {
                List<Integer> level = triangle.get(i);
                for (int j = i; j >= 0; --j) {
                    Integer ele = level.get(j);
                    if (j == i) {
                        state[j] = state[j - 1] + ele;
                    } else if (j == 0) {
                        state[j] += ele;
                    } else {
                        state[j] = Math.min(state[j], state[j - 1]) + ele;
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int ele: state) {
                if (ans > ele) {
                    ans = ele;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}