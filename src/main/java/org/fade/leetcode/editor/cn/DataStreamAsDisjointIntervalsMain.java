/**
给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。 

 实现 SummaryRanges 类： 

 
 
 
 SummaryRanges() 使用一个空数据流初始化对象。 
 void addNum(int val) 向数据流中加入整数 val 。 
 int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。 
 
 
 

 

 示例： 

 
输入：
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", 
"getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
输出：
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], 
null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

解释：
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // 返回 [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 

 

 提示： 

 
 0 <= val <= 10⁴ 
 最多调用 addNum 和 getIntervals 方法 3 * 10⁴ 次 
 

 

 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办? 

 Related Topics 设计 二分查找 有序集合 👍 185 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.Arrays;
import java.util.TreeSet;

public class DataStreamAsDisjointIntervalsMain {
      
    public static void main(String[] args) {
        SummaryRanges summaryRanges = new DataStreamAsDisjointIntervalsMain().new SummaryRanges();
        // arr = [1]
        summaryRanges.addNum(1);
        // 返回 [[1, 1]]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        // arr = [1, 3]
        summaryRanges.addNum(3);
        // 返回 [[1, 1], [3, 3]]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        // arr = [1, 3, 7]
        summaryRanges.addNum(7);
        // 返回 [[1, 1], [3, 3], [7, 7]]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        // arr = [1, 2, 3, 7]
        summaryRanges.addNum(2);
        // 返回 [[1, 3], [7, 7]]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        // arr = [1, 2, 3, 6, 7]
        summaryRanges.addNum(6);
        // 返回 [[1, 3], [6, 7]]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class SummaryRanges {

        private final TreeSet<Integer> treeSet;
    
        public SummaryRanges() {
            this.treeSet = new TreeSet<>();
        }
        
        public void addNum(int value) {
            this.treeSet.add(value);
        }
        
        public int[][] getIntervals() {
//            List<int[]> ans = new ArrayList<>(8);
//            int left = 0, right = 0;
//            for (int i = 0; i < this.treeSet.size(); ++i) {
//                if (this.treeSet.)
//            }
            return null;
        }

    }
    
    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(value);
     * int[][] param_2 = obj.getIntervals();
     */
    //leetcode submit region end(Prohibit modification and deletion)
        
}
