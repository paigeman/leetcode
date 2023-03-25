/**
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 

 
 每行的元素从左到右升序排列。 
 每列的元素从上到下升序排列。 
 

 

 示例 1： 
 
 
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,2
3,26,30]], target = 5
输出：true
 

 示例 2： 
 
 
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,2
3,26,30]], target = 20
输出：false
 

 

 提示： 

 
 m == matrix.length 
 n == matrix[i].length 
 1 <= n, m <= 300 
 -10⁹ <= matrix[i][j] <= 10⁹ 
 每行的所有元素从左到右升序排列 
 每列的所有元素从上到下升序排列 
 -10⁹ <= target <= 10⁹ 
 

 Related Topics 数组 二分查找 分治 矩阵 👍 1249 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

public class SearchA2dMatrixIiMain {
      
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIiMain().new Solution();
//        solution.searchMatrix(Utils.parseToIntArrayArrayFromString("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"), 5);
        solution.searchMatrix(Utils.parseToIntArrayArrayFromString("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"), 20);
//        solution.searchMatrix(Utils.parseToIntArrayArrayFromString("[[-5]]"), -5);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[0][mid] == target) {
                    return true;
                }
                if (matrix[0][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left < n) {
                n = left;
            }
            left = 0;
            right = m - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[mid][0] == target) {
                    return true;
                }
                if (matrix[mid][0] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left < m) {
                m = left;
            }
            for (int i = 0; i < m; ++i) {
                if (partition(matrix[i], 0, n - 1, target)) {
                    return true;
                }
            }
            return false;
        }

        private boolean partition(int[] nums, int i, int j, int target) {
            while (i <= j) {
                int mid = (i + j) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
