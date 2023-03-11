/**
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 

 实现 MinStackMain 类:

 
 MinStackMain() 初始化堆栈对象。
 void push(int val) 将元素val推入堆栈。 
 void pop() 删除堆栈顶部的元素。 
 int top() 获取堆栈顶部的元素。 
 int getMin() 获取堆栈中的最小元素。 
 

 

 示例 1: 

 
输入：
["MinStackMain","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStackMain minStack = new MinStackMain();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 

 

 提示： 

 
 -2³¹ <= val <= 2³¹ - 1 
 pop、top 和 getMin 操作总是在 非空栈 上调用 
 push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
 

 Related Topics 栈 设计 👍 1516 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MinStackMain {
      
    public static void main(String[] args) {
        MinStack solution = new MinStackMain().new MinStack();
        // 保存差值做法可以使空间为O(1)
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        private final Deque<Integer> stack;

        private final Deque<Integer> min;

        public MinStack() {
            this.stack = new LinkedList<>();
            this.min = new LinkedList<>();
        }
        
        public void push(int val) {
            this.stack.push(val);
            Integer peek = this.min.peek();
            if (peek != null && peek < val) {
                Deque<Integer> tmp = new LinkedList<>();
                while (!this.min.isEmpty() && this.min.peek() < val) {
                    tmp.push(this.min.pop());
                }
                this.min.push(val);
                while (!tmp.isEmpty()) {
                    this.min.push(tmp.pop());
                }
            } else {
                this.min.push(val);
            }
        }
        
        public void pop() {
            if (!this.stack.isEmpty()) {
                Integer pop = stack.pop();
                Deque<Integer> tmp = new LinkedList<>();
                while (!this.min.isEmpty() && !this.min.peek().equals(pop)) {
                    tmp.push(this.min.pop());
                }
                if (!this.min.isEmpty()) {
                    this.min.pop();
                }
                while (!tmp.isEmpty()) {
                    this.min.push(tmp.pop());
                }
            }
        }
        
        public int top() {
            if (this.stack.isEmpty()) {
                throw new UnsupportedOperationException();
            }
            return this.stack.peek();
        }
        
        public int getMin() {
            if (this.min.isEmpty()) {
                throw new UnsupportedOperationException();
            }
            return this.min.peek();
        }

    }
    
    /**
     * Your MinStackMain object will be instantiated and called as such:
     * MinStackMain obj = new MinStackMain();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    //leetcode submit region end(Prohibit modification and deletion)
        
}