/**
树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。 

 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 
edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。 

 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 
。 

 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。 树的 
高度 是指根节点和叶子节点之间最长向下路径上边的数量。

 

 示例 1： 
 
 
输入：n = 4, edges = [[1,0],[1,2],[1,3]]
输出：[1]
解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。 

 示例 2： 
 
 
输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
输出：[3,4]
 

 

 
 

 提示： 

 
 1 <= n <= 2 * 10⁴ 
 edges.length == n - 1 
 0 <= ai, bi < n 
 ai != bi 
 所有 (ai, bi) 互不相同 
 给定的输入 保证 是一棵树，并且 不会有重复的边 
 

 Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 763 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTreesMain {
      
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTreesMain().new Solution();
        solution.findMinHeightTrees(4, Utils.parseToIntArrayArrayFromString("[[1,0],[1,2],[1,3]]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new ArrayList<>(8);
            // fixme timeout
            // 建立邻接表
            Map<Integer, List<int[]>> collect = new HashMap<>(8);
            if (edges != null) {
                for (int[] edge :
                        edges) {
                    if (collect.containsKey(edge[0])) {
                        List<int[]> ints = collect.get(edge[0]);
                        ints.add(new int[] {edge[0], edge[1]});
                    } else {
                        List<int[]> ints = new ArrayList<>(8);
                        ints.add(new int[] {edge[0], edge[1]});
                        collect.put(edge[0], ints);
                    }
                    if (collect.containsKey(edge[1])) {
                        List<int[]> ints = collect.get(edge[1]);
                        ints.add(new int[] {edge[1], edge[0]});
                    } else {
                        List<int[]> ints = new ArrayList<>(8);
                        ints.add(new int[] {edge[1], edge[0]});
                        collect.put(edge[1], ints);
                    }
                }
            }
            // 遍历每个节点
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                // 广度/深度 遍历求高度
                boolean[] visited = new boolean[n];
                int height = this.getHeight(i, collect, visited) - 1;
                if (height <= min) {
                    if (height < min) {
                        ans.clear();
                        min = height;
                    }
                    ans.add(i);
                }
            }
            return ans;
        }

        private int getHeight(int n, Map<Integer, List<int[]>> map, boolean[] visited) {
            int ans = 0;
            if (!visited[n]) {
                visited[n] = true;
                List<int[]> ints = map.get(n);
                if (ints != null) {
                    for (int[] edge: ints) {
                        if (!visited[edge[1]]) {
                            ans = Math.max(ans, this.getHeight(edge[1], map, visited));
                        }
                    }
                }
            }
            return ans + 1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
