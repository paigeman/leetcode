/**
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 

 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如
果要学习课程 ai 则 必须 先学习课程 bi 。 

 
 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
 

 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 

 

 示例 1： 

 
输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 

 示例 2： 

 
输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 

 

 提示： 

 
 1 <= numCourses <= 10⁵ 
 0 <= prerequisites.length <= 5000 
 prerequisites[i].length == 2 
 0 <= ai, bi < numCourses 
 prerequisites[i] 中的所有课程对 互不相同 
 

 Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1534 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.*;

public class CourseScheduleMain {
      
    public static void main(String[] args) {
        Solution solution = new CourseScheduleMain().new Solution();
//        solution.canFinish(2, Utils.parseToIntArrayArrayFromString("[[1,0]]"));
        solution.canFinish(5, Utils.parseToIntArrayArrayFromString("[[1,4],[2,4],[3,1],[3,2]]"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            if (prerequisites.length == 0) {
//                return true;
//            }
            Map<Integer, Set<Integer>> map = new HashMap<>(8);
            int[] inDegree = new int[numCourses];
            for (int[] prerequisite: prerequisites) {
                if (map.containsKey(prerequisite[0])) {
                    Set<Integer> integers = map.get(prerequisite[0]);
                    integers.add(prerequisite[1]);
                } else {
                    Set<Integer> set = new HashSet<>(8);
                    set.add(prerequisite[1]);
                    map.put(prerequisite[0], set);
                }
                ++inDegree[prerequisite[1]];
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegree.length; ++i) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int counter = 0;
            while (!queue.isEmpty()) {
                ++counter;
                Integer poll = queue.poll();
                Set<Integer> integers = map.get(poll);
                if (integers != null) {
                    for (int num: integers) {
                        Integer integer = inDegree[num];
                        --integer;
                        if (integer == 0) {
                            queue.offer(num);
                        }
                        inDegree[num] = integer;
                    }
                }
            }
            return inDegree.length == counter;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
