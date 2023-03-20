/**
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 

 

 示例 1： 
 
 
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"ABCCED"
输出：true
 

 示例 2： 
 
 
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"SEE"
输出：true
 

 示例 3： 
 
 
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"ABCB"
输出：false
 

 

 提示： 

 
 m == board.length 
 n = board[i].length 
 1 <= m, n <= 6 
 1 <= word.length <= 15 
 board 和 word 仅由大小写英文字母组成 
 

 

 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 

 Related Topics 数组 回溯 矩阵 👍 1552 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

public class WordSearchMain {
      
    public static void main(String[] args) {
        Solution solution = new WordSearchMain().new Solution();
//        solution.exist(Utils.parseToCharArrayArrayFromString("[[\"a\"]]"), "a");
        solution.exist(Utils.parseToCharArrayArrayFromString("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCB");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (traceback(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean traceback(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
            if (visited[i][j] || board[i][j] != word.charAt(k)) {
                return false;
            }
            if (k == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            if (j < board[0].length - 1 && traceback(board, word, visited, i, j + 1, k + 1)) {
                return true;
            }
            if (j > 0 && traceback(board, word, visited, i, j - 1, k + 1)) {
                return true;
            }
            if (i < board.length - 1 && traceback(board, word, visited, i + 1, j, k + 1)) {
                return true;
            }
            if (i > 0 && traceback(board, word, visited, i - 1, j, k + 1)) {
                return true;
            }
            visited[i][j] = false;
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
