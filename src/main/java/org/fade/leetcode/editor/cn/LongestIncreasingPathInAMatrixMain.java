/**
给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 

 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 

 

 示例 1： 
 
 
输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
输出：4 
解释：最长递增路径为 [1, 2, 6, 9]。 

 示例 2： 
 
 
输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
输出：4 
解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 

 示例 3： 

 
输入：matrix = [[1]]
输出：1
 

 

 提示： 

 
 m == matrix.length 
 n == matrix[i].length 
 1 <= m, n <= 200 
 0 <= matrix[i][j] <= 2³¹ - 1 
 

 Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 750 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

public class LongestIncreasingPathInAMatrixMain {
      
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrixMain().new Solution();
        solution.longestIncreasingPath(Utils.parseToIntArrayArrayFromString("[[9,9,4],[6,6,8],[2,1,1]]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int ans = Integer.MIN_VALUE;
            boolean[][] visited = new boolean[m][n];
            int[][] status = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int dfs = dfs(matrix, i, j, visited, status);
                    if (dfs > ans) {
                        ans = dfs;
                    }
                }
            }
            return ans;
        }

        private int dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] status) {
            if (status[i][j] > 0) {
                return status[i][j];
            }
            int ans = 0;
            visited[i][j] = true;
            if (i > 0 && !visited[i - 1][j] && matrix[i][j] < matrix[i - 1][j]) {
                ans = Math.max(ans, dfs(matrix, i - 1, j, visited, status));
            }
            if (i < matrix.length - 1 && !visited[i + 1][j] && matrix[i][j] < matrix[i + 1][j]) {
                ans = Math.max(ans, dfs(matrix, i + 1, j, visited, status));
            }
            if (j > 0 && !visited[i][j - 1] && matrix[i][j] < matrix[i][j - 1]) {
                ans = Math.max(ans, dfs(matrix, i, j - 1, visited, status));
            }
            if (j < matrix[0].length - 1 && !visited[i][j + 1] && matrix[i][j] < matrix[i][j + 1]) {
                ans = Math.max(ans, dfs(matrix, i, j + 1, visited, status));
            }
            visited[i][j] = false;
            status[i][j] = ans + 1;
            return status[i][j];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
