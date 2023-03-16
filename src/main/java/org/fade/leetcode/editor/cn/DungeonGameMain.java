/**


 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地
下城并通过对抗恶魔来拯救公主。 

 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。 

 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含
增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。 

 为了尽快到达公主，骑士决定每次只向右或向下移动一步。 

 

 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。 

 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。 

 
 
 -2 (K) 
 -3 
 3 
 
 
 -5 
 -10 
 1 
 
 
 10 
 30 
 -5 (P) 
 
 


 

 说明: 

 
 骑士的健康点数没有上限。 
 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。 
 

 Related Topics 数组 动态规划 矩阵 👍 712 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

public class DungeonGameMain {
      
    public static void main(String[] args) {
        Solution solution = new DungeonGameMain().new Solution();
//        solution.calculateMinimumHP(Utils.parseToArrayArrayFromString("[[-2,-3,3],[-5,-10,1],[10,30,-5]]"));
//        solution.calculateMinimumHP(Utils.parseToArrayArrayFromString("[[-3,5]]"));
//        solution.calculateMinimumHP(Utils.parseToArrayArrayFromString("[[2,1],[1,-1]]"));
        solution.calculateMinimumHP(Utils.parseToArrayArrayFromString("[[1,-3,3],[0,-2,0],[-3,-3,-3]]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            int[] status = new int[n];
            int[] initial = new int[n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == 0 && j == 0) {
                        status[j] = dungeon[i][j];
                        initial[j] = status[j] >= 0 ? 1 : status[j];
                    } else if (j == 0) {
                        status[j] = status[j] + dungeon[i][j];
                        initial[j] = status[j] >= 0 ? initial[j] : status[j];
                    } else if (i == 0) {
                        status[j] = status[j - 1] + dungeon[i][j];
                        initial[j] = status[j] >= 0 ? initial[j - 1] : status[j];
                    } else {
                        int up = status[j] + dungeon[i][j];
                        int left = status[j - 1] + dungeon[i][j];
                        if (up < 0 && left < 0) {
                            initial[j] = status[j] = Math.max(up, left);
                        } else if (up < 0) {
                            // fixme
                        } else if (left < 0) {
                            // fixme
                        } else {
                            // fixme
                        }
                    }
                }
            }
            return initial[n - 1] >= 0 ? initial[n - 1] : -initial[n - 1] + 1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}