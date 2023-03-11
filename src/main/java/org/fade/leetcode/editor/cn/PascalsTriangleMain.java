/**
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 

 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 

 

 

 示例 1: 

 
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 

 示例 2: 

 
输入: numRows = 1
输出: [[1]]
 

 

 提示: 

 
 1 <= numRows <= 30 
 

 Related Topics 数组 动态规划 👍 931 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleMain {
      
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleMain().new Solution();
        solution.generate(5);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>(numRows);
            ans.add(List.of(1));
            if (numRows == 1) {
                return ans;
            }
            ans.add(List.of(1, 1));
            if (numRows == 2) {
                return ans;
            }
            for (int i = 3; i <= numRows; ++i) {
                List<Integer> integers = ans.get(ans.size() - 1);
                int size = integers.size();
                List<Integer> line = new ArrayList<>(size + 1);
                line.add(1);
                for (int j = 1; j < size; ++j) {
                    line.add(integers.get(j - 1) + integers.get(j));
                }
                line.add(1);
                ans.add(line);
            }
            return ans;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

    
}