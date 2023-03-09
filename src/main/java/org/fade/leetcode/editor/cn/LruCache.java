/**

 请你设计并实现一个满足 
 LRU (最近最少使用) 缓存 约束的数据结构。
 

 
 实现 
 LRUCache 类：
 

 
 
 
 LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
 int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
 void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-
value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
 
 
 

 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 

 

 示例： 

 
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
 

 

 提示： 

 
 1 <= capacity <= 3000 
 0 <= key <= 10000 
 0 <= value <= 10⁵ 
 最多调用 2 * 10⁵ 次 get 和 put 
 

 Related Topics 设计 哈希表 链表 双向链表 👍 2581 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache{
      
    public static void main(String[] args) {
        LRUCache solution = new LruCache().new LRUCache(2);
        solution.put(1, 1);
        solution.put(2, 2);
        solution.get(1);
        solution.put(3, 3);
        solution.get(2);
        solution.put(4, 4);
        solution.get(1);
        solution.get(3);
        solution.get(4);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private final int capacity;

        private final Map<Integer, DoubleListNode> cache;

        private final DoubleListNode dl;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>(capacity);
            this.dl = new DoubleListNode(-1, -1);
            this.dl.next = this.dl;
            this.dl.prev = this.dl;
        }
        
        public int get(int key) {
            if (cache.containsKey(key)) {
                DoubleListNode node = cache.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = this.dl;
                node.prev = this.dl.prev;
                this.dl.prev.next = node;
                this.dl.prev = node;
                return node.val;
            }
            return -1;
        }
        
        public void put(int key, int value) {
            DoubleListNode node;
            if (this.cache.containsKey(key)) {
                node = this.cache.get(key);
                node.val = value;
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else {
                node = new DoubleListNode(key, value);
                if (cache.size() >= this.capacity) {
                    this.cache.remove(this.dl.next.key);
                    this.dl.next = this.dl.next.next;
                    this.dl.next.prev = this.dl;
                }
                this.cache.put(key, node);
            }
            node.next = this.dl;
            node.prev = this.dl.prev;
            this.dl.prev.next = node;
            this.dl.prev = node;
        }

        private class DoubleListNode {

            public int key;

            public int val;

            public DoubleListNode next;

            public DoubleListNode prev;

            public DoubleListNode(int x, int y) {
                this.key = x;
                this.val = y;
            }

            public DoubleListNode(int x, int y, DoubleListNode next, DoubleListNode prev) {
                this.key = x;
                this.val = y;
                this.next = next;
                this.prev = prev;
            }

        }

    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)
        
}