/**
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 

 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 

 

 示例 1: 

 
输入: s = "anagram", t = "nagaram"
输出: true
 

 示例 2: 

 
输入: s = "rat", t = "car"
输出: false 

 

 提示: 

 
 1 <= s.length, t.length <= 5 * 10⁴ 
 s 和 t 仅包含小写字母 
 

 

 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 

 Related Topics 哈希表 字符串 排序 👍 749 👎 0

*/
  
package org.fade.leetcode.editor.cn;

import java.util.Arrays;

public class ValidAnagramMain {
      
    public static void main(String[] args) {
        Solution solution = new ValidAnagramMain().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isAnagram(String s, String t) {
            // 法一
//            Map<Character, Integer> map = new HashMap<>(8);
//            for (Character c: s.toCharArray()) {
//                map.put(c, map.getOrDefault(c, 0) + 1);
//            }
//            for (Character c: t.toCharArray()) {
//                if (!map.containsKey(c)) {
//                    return false;
//                }
//                int value = map.get(c) - 1;
//                if (value < 0) {
//                    return false;
//                }
//                map.put(c, value);
//            }
//            return map.entrySet().stream()
//                    .noneMatch(x -> x.getValue() > 0);
            // 法二
            char[] sa = s.toCharArray();
            char[] ta = t.toCharArray();
            Arrays.sort(sa);
            Arrays.sort(ta);
            int i = 0;
            for (; i < sa.length && i < ta.length; ++i) {
                if (sa[i] != ta[i]) {
                    return false;
                }
            }
            return i == sa.length && i == ta.length;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
