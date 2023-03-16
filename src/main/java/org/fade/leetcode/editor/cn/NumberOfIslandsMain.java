/**
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 

 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 

 此外，你可以假设该网格的四条边均被水包围。 

 

 示例 1： 

 
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
 

 示例 2： 

 
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
 

 

 提示： 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m, n <= 300 
 grid[i][j] 的值为 '0' 或 '1' 
 

 Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2109 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsMain {
      
    public static void main(String[] args) {
        Solution solution = new NumberOfIslandsMain().new Solution();
//        solution.numIslands()
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numIslands(char[][] grid) {
            int ans = 0;
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        ++ans;
                        Queue<Integer> queue = new LinkedList<>();
                        queue.offer(i * n + j);
                        visited[i][j] = true;
                        while (!queue.isEmpty()) {
                            int size = queue.size();
                            for (int k = 0; k < size; ++k) {
                                Integer poll = queue.poll();
                                if (poll != null) {
                                    int row = poll / n;
                                    int col = poll % n;
                                    if (col <= n - 2 && grid[row][col + 1] == '1' && !visited[row][col + 1]) {
                                        queue.offer(row * n + col + 1);
                                        visited[row][col + 1] = true;
                                    }
                                    if (col >= 1 && grid[row][col - 1] == '1' && !visited[row][col - 1]) {
                                        queue.offer(row * n + col - 1);
                                        visited[row][col - 1] = true;
                                    }
                                    if (row <= m - 2 && grid[row + 1][col] == '1' && !visited[row + 1][col]) {
                                        queue.offer((row + 1) * n + col);
                                        visited[row + 1][col] = true;
                                    }
                                    if (row >= 1 && grid[row - 1][col] == '1' && !visited[row - 1][col]) {
                                        queue.offer((row - 1) * n + col);
                                        visited[row - 1][col] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
