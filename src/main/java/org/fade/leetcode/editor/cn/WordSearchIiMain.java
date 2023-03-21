/**
给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 

 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 

 

 示例 1： 
 
 
输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l",
"v"]], words = ["oath","pea","eat","rain"]
输出：["eat","oath"]
 

 示例 2： 
 
 
输入：board = [["a","b"],["c","d"]], words = ["abcb"]
输出：[]
 

 

 提示： 

 
 m == board.length 
 n == board[i].length 
 1 <= m, n <= 12 
 board[i][j] 是一个小写英文字母 
 1 <= words.length <= 3 * 10⁴ 
 1 <= words[i].length <= 10 
 words[i] 由小写英文字母组成 
 words 中的所有字符串互不相同 
 

 Related Topics 字典树 数组 字符串 回溯 矩阵 👍 753 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIiMain {
      
    public static void main(String[] args) {
        Solution solution = new WordSearchIiMain().new Solution();
//        solution.findWords(Utils.parseToCharArrayArrayFromString("[[\"o\",\"a\",\"b\",\"n\"],[\"o\",\"t\",\"a\",\"e\"],[\"a\",\"h\",\"k\",\"r\"],[\"a\",\"f\",\"l\",\"v\"]]"), Utils.parseToStringArrayFromString("[\"oa\",\"oaa\"]"));
        solution.findWords(Utils.parseToCharArrayArrayFromString("[[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]]"), Utils.parseToStringArrayFromString("[\"oath\",\"pea\",\"eat\",\"rain\",\"oathi\",\"oathk\",\"oathf\",\"oate\",\"oathii\",\"oathfi\",\"oathfii\"]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> findWords(char[][] board, String[] words) {
            int m = board.length;
            int n = board[0].length;
            List<String> ans = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];
            StringBuilder builder = new StringBuilder();
            Trie trie = new Trie();
            for (String word: words) {
                trie.insert(word);
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int index = board[i][j] - 'a';
                    if (trie.children[index] != null) {
                        traceback(ans, builder, visited, trie, board, i, j);
                    }
                }
            }
            return ans;
        }

        private void traceback(List<String> ans, StringBuilder builder, boolean[][] visited, Trie trie, char[][] board, int i, int j) {
            int index = board[i][j] - 'a';
            Trie child = trie.children[index];
            if (child == null) {
                return;
            }
            builder.append(board[i][j]);
            if (child.isEnd && !child.isAdded) {
                child.isAdded = true;
                ans.add(builder.toString());
                if (!child.hasChildren) {
                    builder.deleteCharAt(builder.length() - 1);
                    return;
                }
            }
            visited[i][j] = true;
            if (j < board[0].length - 1 && !visited[i][j + 1]) {
                traceback(ans, builder, visited, child, board, i, j + 1);
            }
            if (j > 0 && !visited[i][j - 1]) {
                traceback(ans, builder, visited, child, board, i, j - 1);
            }
            if (i < board.length - 1 && !visited[i + 1][j]) {
                traceback(ans, builder, visited, child, board, i + 1, j);
            }
            if (i > 0 && !visited[i - 1][j]) {
                traceback(ans, builder, visited, child, board, i - 1, j);
            }
            visited[i][j] = false;
            builder.deleteCharAt(builder.length() - 1);
        }

//        private boolean traceback(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
//            if (visited[i][j] || board[i][j] != word.charAt(k)) {
//                return false;
//            }
//            if (k == word.length() - 1) {
//                return true;
//            }
//            visited[i][j] = true;
//            if (j < board[0].length - 1 && traceback(board, word, visited, i, j + 1, k + 1)) {
//                return true;
//            }
//            if (j > 0 && traceback(board, word, visited, i, j - 1, k + 1)) {
//                return true;
//            }
//            if (i < board.length - 1 && traceback(board, word, visited, i + 1, j, k + 1)) {
//                return true;
//            }
//            if (i > 0 && traceback(board, word, visited, i - 1, j, k + 1)) {
//                return true;
//            }
//            visited[i][j] = false;
//            return false;
//        }

        private class Trie {

            private final Trie[] children = new Trie[26];

            private boolean isEnd = false;

            private boolean isAdded = false;

            private boolean hasChildren = false;

            private void insert(String param) {
                Trie cur = this;
                for (int i = 0; i < param.length(); ++i) {
                    int index = param.charAt(i) - 'a';
                    if (cur.children[index] != null) {
                        cur = cur.children[index];
                    } else {
                        Trie next = new Trie();
                        cur.children[index] = next;
                        cur.hasChildren = true;
                        cur = next;
                    }
                }
                cur.isEnd = true;
            }

        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
