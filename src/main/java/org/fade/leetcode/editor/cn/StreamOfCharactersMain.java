/**
设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。 

 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到 
"axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。 

 按下述要求实现 StreamChecker 类： 

 
 StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。 
 boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true 
；否则，返回 false。 
 

 

 示例： 

 
输入：
["StreamChecker", "query", "query", "query", "query", "query", "query", "query",
 "query", "query", "query", "query", "query"]
[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], [
"i"], ["j"], ["k"], ["l"]]
输出：
[null, false, false, false, true, false, true, false, false, false, false, 
false, true]

解释：
StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
streamChecker.query("a"); // 返回 False
streamChecker.query("b"); // 返回 False
streamChecker.query("c"); // 返回n False
streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
streamChecker.query("e"); // 返回 False
streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
streamChecker.query("g"); // 返回 False
streamChecker.query("h"); // 返回 False
streamChecker.query("i"); // 返回 False
streamChecker.query("j"); // 返回 False
streamChecker.query("k"); // 返回 False
streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
 

 

 提示： 

 
 1 <= words.length <= 2000 
 1 <= words[i].length <= 200 
 words[i] 由小写英文字母组成 
 letter 是一个小写英文字母 
 最多调用查询 4 * 10⁴ 次 
 

 Related Topics 设计 字典树 数组 字符串 数据流 👍 122 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.util.Utils;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class StreamOfCharactersMain {
      
    public static void main(String[] args) {
//        case1();
        case2();
    }

    private static void case1() {
        StreamChecker streamChecker = new StreamOfCharactersMain().new StreamChecker(Utils.parseToStringArrayFromString("[\"cd\", \"f\", \"kl\"]"));
        // 返回 False
        System.out.println(streamChecker.query('a'));
        // 返回 False
        System.out.println(streamChecker.query('b'));
        // 返回n False
        System.out.println(streamChecker.query('c'));
        // 返回 True ，因为 'cd' 在 words 中
        System.out.println(streamChecker.query('d'));
        // 返回 False
        System.out.println(streamChecker.query('e'));
        // 返回 True ，因为 'f' 在 words 中
        System.out.println(streamChecker.query('f'));
        // 返回 False
        System.out.println(streamChecker.query('g'));
        // 返回 False
        System.out.println(streamChecker.query('h'));
        // 返回 False
        System.out.println(streamChecker.query('i'));
        // 返回 False
        System.out.println(streamChecker.query('j'));
        // 返回 False
        System.out.println(streamChecker.query('k'));
        // 返回 True ，因为 'kl' 在 words 中
        System.out.println(streamChecker.query('l'));
    }

    private static void case2() {
        StreamChecker streamChecker = new StreamOfCharactersMain().new StreamChecker(Utils.parseToStringArrayFromString("[\"ab\",\"ba\",\"aaab\",\"abab\",\"baa\"]"));
        String[] methods = Utils.parseToStringArrayFromString("[\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\",\"query\"]");
        char[] params = Utils.parseToCharArrayFromString("[" + "[\"a\"],[\"a\"],[\"a\"],[\"a\"],[\"a\"],[\"b\"],[\"a\"],[\"b\"],[\"a\"],[\"b\"],[\"b\"],[\"b\"],[\"a\"],[\"b\"],[\"a\"],[\"b\"],[\"b\"],[\"b\"],[\"b\"],[\"a\"],[\"b\"],[\"a\"],[\"b\"],[\"a\"],[\"a\"],[\"a\"],[\"b\"],[\"a\"],[\"a\"],[\"a\"]".replaceAll("(\\[|])", "") + "]");
        int length = methods.length;
        for (int i = 0; i < length; ++i) {
            Utils.invokeMethodOnSpecificObj(streamChecker, methods[i], new Object[]{params[i]}, new Class<?>[] {char.class});
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class StreamChecker {

        private final Trie trie;

        private final Deque<Character> deque;
    
        public StreamChecker(String[] words) {
            this.trie = new Trie();
            this.deque = new LinkedList<>();
            for (String word: words) {
                this.trie.insert(word);
            }
        }
        
        public boolean query(char letter) {
            this.deque.offer(letter);
            Iterator<Character> characterIterator = this.deque.descendingIterator();
            Trie cur = this.trie;
            while (characterIterator.hasNext()) {
                int key = characterIterator.next() - 'a';
                if (cur.children[key] != null) {
                    cur = cur.children[key];
                    if (cur.isEnd) {
                        return true;
                    }
                } else {
                    break;
                }
            }
            return cur.isEnd;
        }

        private class Trie {

            private final Trie[] children;

            private boolean isEnd;

            private Trie() {
                this.children = new Trie[26];
            }

            private void insert(String word) {
                Trie cur = this;
                for (int i = word.length() - 1; i >= 0; --i) {
                    int key = word.charAt(i) - 'a';
                    if (cur.children[key] != null) {
                        cur = cur.children[key];
                    } else {
                        Trie trie = new Trie();
                        cur.children[key] = trie;
                        cur = trie;
                    }
                }
                cur.isEnd = true;
            }

        }

    }
    
    /**
     * Your StreamChecker object will be instantiated and called as such:
     * StreamChecker obj = new StreamChecker(words);
     * boolean param_1 = obj.query(letter);
     */
    //leetcode submit region end(Prohibit modification and deletion)
        
}
