/**
请你在设计一个迭代器，在集成现有迭代器拥有的 hasNext 和 next 操作的基础上，还额外支持 peek 操作。 

 实现 PeekingIterator 类： 

 
 PeekingIterator(Iterator<int> nums) 使用指定整数迭代器 nums 初始化迭代器。 
 int next() 返回数组中的下一个元素，并将指针移动到下个元素处。 
 bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。 
 int peek() 返回数组中的下一个元素，但 不 移动指针。 
 

 注意：每种语言可能有不同的构造函数和迭代器 Iterator，但均支持 int next() 和 boolean hasNext() 函数。 

 

 示例 1： 

 
输入：
["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
[[[1, 2, 3]], [], [], [], [], []]
输出：
[null, 1, 2, 2, 3, false]

解释：
PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
peekingIterator.next();    // 返回 1 ，指针移动到下一个元素 [1,2,3]
peekingIterator.peek();    // 返回 2 ，指针未发生移动 [1,2,3]
peekingIterator.next();    // 返回 2 ，指针移动到下一个元素 [1,2,3]
peekingIterator.next();    // 返回 3 ，指针移动到下一个元素 [1,2,3]
peekingIterator.hasNext(); // 返回 False
 

 

 提示： 

 
 1 <= nums.length <= 1000 
 1 <= nums[i] <= 1000 
 对 next 和 peek 的调用均有效 
 next、hasNext 和 peek 最多调用 1000 次 
 

 

 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？ 

 Related Topics 设计 数组 迭代器 👍 183 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PeekingIteratorMain {
      
    public static void main(String[] args) {
        PeekingIterator peekingIterator = new PeekingIteratorMain().new PeekingIterator(Arrays.stream(Utils.parseToArrayFromString("[1, 2, 3]")).iterator());
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
    
    class PeekingIterator implements Iterator<Integer> {

		private final Iterator<Integer> iterator;

		private final Queue<Integer> peekingQueue;

		public PeekingIterator(Iterator<Integer> iterator) {
    	    // initialize any member here.
    	    this.iterator = iterator;
			this.peekingQueue = new LinkedList<>();
    	}
    	
        // Returns the next element in the iteration without advancing the iterator.
    	public Integer peek() {
			if (this.peekingQueue.isEmpty()) {
				if (this.iterator.hasNext()) {
					this.peekingQueue.offer(this.iterator.next());
				} else {
					throw new UnsupportedOperationException();
				}
			}
			return this.peekingQueue.peek();
    	}
    	
    	// hasNext() and next() should behave the same as in the Iterator interface.
    	// Override them if needed.
    	@Override
    	public Integer next() {
    	    if (this.peekingQueue.isEmpty()) {
				return this.iterator.next();
			}
			return this.peekingQueue.poll();
    	}
    	
    	@Override
    	public boolean hasNext() {
    	    return !this.peekingQueue.isEmpty() || this.iterator.hasNext();
    	}

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
