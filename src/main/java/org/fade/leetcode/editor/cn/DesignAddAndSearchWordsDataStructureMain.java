/**
请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 

 实现词典类 WordDictionary ： 

 
 WordDictionary() 初始化词典对象 
 void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
 bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '.
' ，每个 . 都可以表示任何一个字母。 
 

 

 示例： 

 
输入：
["WordDictionary","addWord","addWord","addWord","search","search","search",
"search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]

解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // 返回 False
wordDictionary.search("bad"); // 返回 True
wordDictionary.search(".ad"); // 返回 True
wordDictionary.search("b.."); // 返回 True
 

 

 提示： 

 
 1 <= word.length <= 25 
 addWord 中的 word 由小写英文字母组成 
 search 中的 word 由 '.' 或小写英文字母组成 
 最多调用 10⁴ 次 addWord 和 search 
 

 Related Topics 深度优先搜索 设计 字典树 字符串 👍 487 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class DesignAddAndSearchWordsDataStructureMain {
      
    public static void main(String[] args) {
        WordDictionary wordDictionary = new DesignAddAndSearchWordsDataStructureMain().new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        // 返回 False
//        System.out.println(wordDictionary.search("pad"));
//        // 返回 True
//        System.out.println(wordDictionary.search("bad"));
//        // 返回 True
//        System.out.println(wordDictionary.search(".ad"));
//        // 返回 True
//        System.out.println(wordDictionary.search("b.."));
        // case 2
//        wordDictionary.search("a");
        // case 3
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        // false
        System.out.println(wordDictionary.search("a"));
        // false
        System.out.println(wordDictionary.search(".at"));
        // true
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        private final WordDictionary[] children;

        private boolean isEnd = false;

        public WordDictionary() {
            this.children = new WordDictionary[26];
        }
        
        public void addWord(String word) {
            WordDictionary cur = this;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] != null) {
                    cur = cur.children[index];
                } else {
                    WordDictionary wordDictionary = new WordDictionary();
                    cur.children[index] = wordDictionary;
                    cur = wordDictionary;
                }
            }
            cur.isEnd = true;
        }
        
        public boolean search(String word) {
            return dfs(this, word, 0);
        }

        private boolean dfs(WordDictionary wordDictionary, String word, int index) {
            char c = word.charAt(index);
            if (c != '.') {
                int i = c - 'a';
                WordDictionary child = wordDictionary.children[i];
                if (index == word.length() - 1) {
                    return child != null && child.isEnd;
                }
                if (child == null || !dfs(child, word, index + 1)) {
                    return false;
                }
            } else {
                int failure = 0;
                for (WordDictionary i: wordDictionary.children) {
                    if (index == word.length() - 1 && i != null && i.isEnd) {
                        break;
                    }
                    if (index != word.length() - 1 && i != null && dfs(i, word, index + 1)) {
                        break;
                    }
                    ++failure;
                }
                if (failure == wordDictionary.children.length) {
                    return false;
                }
            }
            return true;
        }

    }
    
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    //leetcode submit region end(Prohibit modification and deletion)
        
}
