/**
「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。 

 游戏地图用大小为 m x n 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。 

 现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ： 

 
 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。 
 地板用字符 '.' 表示，意味着可以自由行走。 
 墙用字符 '#' 表示，意味着障碍物，不能通行。 
 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。 
 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。 
 玩家无法越过箱子。 
 

 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。 

 

 示例 1： 

 

 
输入：grid = [["#","#","#","#","#","#"],
             ["#","T","#","#","#","#"],
             ["#",".",".","B",".","#"],
             ["#",".","#","#",".","#"],
             ["#",".",".",".","S","#"],
             ["#","#","#","#","#","#"]]
输出：3
解释：我们只需要返回推箱子的次数。 

 示例 2： 

 
输入：grid = [["#","#","#","#","#","#"],
             ["#","T","#","#","#","#"],
             ["#",".",".","B",".","#"],
             ["#","#","#","#",".","#"],
             ["#",".",".",".","S","#"],
             ["#","#","#","#","#","#"]]
输出：-1
 

 示例 3： 

 
输入：grid = [["#","#","#","#","#","#"],
             ["#","T",".",".","#","#"],
             ["#",".","#","B",".","#"],
             ["#",".",".",".",".","#"],
             ["#",".",".",".","S","#"],
             ["#","#","#","#","#","#"]]
输出：5
解释：向下、向左、向左、向上再向上。
 

 

 提示： 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m, n <= 20 
 grid 仅包含字符 '.', '#', 'S' , 'T', 以及 'B'。 
 grid 中 'S', 'B' 和 'T' 各只能出现一个。 
 

 Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 157 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovesToMoveABoxToTheirTargetLocationMain {
      
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToMoveABoxToTheirTargetLocationMain().new Solution();
        solution.minPushBox(Utils.parseToCharArrayArrayFromString("[[\"#\",\"#\",\"#\",\"#\",\"#\",\"#\"],[\"#\",\"T\",\"#\",\"#\",\"#\",\"#\"],[\"#\",\".\",\".\",\"B\",\".\",\"#\"],[\"#\",\".\",\"#\",\"#\",\".\",\"#\"],[\"#\",\".\",\".\",\".\",\"S\",\"#\"],[\"#\",\"#\",\"#\",\"#\",\"#\",\"#\"]]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minPushBox(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] reachable = new boolean[m][n];
            int pi = 0, pj = 0;
            for (int i = 0; i < m; ++i) {
                boolean flag = false;
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 'S') {
                        pi = i;
                        pj = j;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {pi, pj});
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    int[] poll = queue.poll();
                    if (poll != null) {
                        reachable[poll[0]][poll[1]] = true;
                        if (poll[0] > 1 && grid[poll[0] - 1][poll[1]] != '#') {
                            queue.offer(new int[] {poll[0] - 1, poll[1]});
                        }
                        if (poll[0] < m - 2 && grid[poll[0] + 1][poll[1]] != '#') {
                            queue.offer(new int[] {poll[0] + 1, poll[1]});
                        }
                        if (poll[1] > 1 && grid[poll[0]][poll[1] - 1] != '#') {
                            queue.offer(new int[] {poll[0], poll[1] - 1});
                        }
                        if (poll[1] < n - 2 && grid[poll[0]][poll[1] + 1] != '#') {
                            queue.offer(new int[] {poll[0], poll[1] + 1});
                        }
                    }
                }
            }
            int bi = 0, bj = 0;
            for (int i = 0; i < m; ++i) {
                boolean flag = false;
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 'B') {
                        bi = i;
                        bj = j;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            queue.add(new int[] {bi, bj});
            return 0;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
