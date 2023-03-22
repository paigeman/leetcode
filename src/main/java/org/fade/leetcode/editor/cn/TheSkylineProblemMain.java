/**
城市的 天际线 是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。 

 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示： 

 
 lefti 是第 i 座建筑物左边缘的 x 坐标。 
 righti 是第 i 座建筑物右边缘的 x 坐标。 
 heighti 是第 i 座建筑物的高度。 
 

 你可以假设所有的建筑都是完美的长方形，在高度为 0 的绝对平坦的表面上。 

 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表
中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。 

 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...] 

 

 示例 1： 
 
 
输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
解释：
图 A 显示输入的所有建筑物的位置和高度，
图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。 

 示例 2： 

 
输入：buildings = [[0,2,3],[2,5,3]]
输出：[[0,3],[5,0]]
 

 

 提示： 

 
 1 <= buildings.length <= 10⁴ 
 0 <= lefti < righti <= 2³¹ - 1 
 1 <= heighti <= 2³¹ - 1 
 buildings 按 lefti 非递减排序 
 

 Related Topics 树状数组 线段树 数组 分治 有序集合 扫描线 堆（优先队列） 👍 762 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.*;

public class TheSkylineProblemMain {
      
    public static void main(String[] args) {
        Solution solution = new TheSkylineProblemMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> ans = new ArrayList<>(8);
            Queue<int[]> pile = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
            pile.addAll(Arrays.asList(buildings));
            while (!pile.isEmpty()) {
                int[] poll = pile.poll();
                if (poll != null) {

                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}