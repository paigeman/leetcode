/**
给你一条个人信息字符串 s ，可能表示一个 邮箱地址 ，也可能表示一串 电话号码 。返回按如下规则 隐藏 个人信息后的结果： 

 电子邮件地址： 

 一个电子邮件地址由以下部分组成： 

 
 一个 名字 ，由大小写英文字母组成，后面跟着 
 一个 '@' 字符，后面跟着 
 一个 域名 ，由大小写英文字母和一个位于中间的 '.' 字符组成。'.' 不会是域名的第一个或者最后一个字符。 
 

 要想隐藏电子邮件地址中的个人信息： 

 
 名字 和 域名 部分的大写英文字母应当转换成小写英文字母。 
 名字 中间的字母（即，除第一个和最后一个字母外）必须用 5 个 "*****" 替换。 
 

 电话号码： 

 一个电话号码应当按下述格式组成： 

 
 电话号码可以由 10-13 位数字组成 
 后 10 位构成 本地号码 
 前面剩下的 0-3 位，构成 国家代码 
 利用 {'+', '-', '(', ')', ' '} 这些 分隔字符 按某种形式对上述数字进行分隔 
 

 要想隐藏电话号码中的个人信息： 

 
 移除所有 分隔字符 
 隐藏个人信息后的电话号码应该遵从这种格式： 
 
 "***-***-XXXX" 如果国家代码为 0 位数字 
 "+*-***-***-XXXX" 如果国家代码为 1 位数字 
 "+**-***-***-XXXX" 如果国家代码为 2 位数字 
 "+***-***-***-XXXX" 如果国家代码为 3 位数字 
 
 "XXXX" 是最后 4 位 本地号码 
 

 
 
 
 示例 1： 
 
 
 

 
输入：s = "LeetCode@LeetCode.com"
输出："l*****e@leetcode.com"
解释：s 是一个电子邮件地址。
名字和域名都转换为小写，名字的中间用 5 个 * 替换。
 

 示例 2： 

 
输入：s = "AB@qq.com"
输出："a*****b@qq.com"
解释：s 是一个电子邮件地址。
名字和域名都转换为小写，名字的中间用 5 个 * 替换。
注意，尽管 "ab" 只有两个字符，但中间仍然必须有 5 个 * 。
 

 示例 3： 

 
输入：s = "1(234)567-890"
输出："***-***-7890"
解释：s 是一个电话号码。
共计 10 位数字，所以本地号码为 10 位数字，国家代码为 0 位数字。
因此，隐藏后的电话号码应该是 "***-***-7890" 。
 

 示例 4： 

 
输入：s = "86-(10)12345678"
输出："+**-***-***-5678"
解释：s 是一个电话号码。
共计 12 位数字，所以本地号码为 10 位数字，国家代码为 2 位数字。
因此，隐藏后的电话号码应该是 "+**-***-***-7890" 。
 

 

 提示： 

 
 s 是一个 有效 的电子邮件或者电话号码 
 如果 s 是一个电子邮件： 
 
 8 <= s.length <= 40 
 s 是由大小写英文字母，恰好一个 '@' 字符，以及 '.' 字符组成 
 
 如果 s 是一个电话号码： 
 
 10 <= s.length <= 20 
 s 是由数字、空格、字符 '('、')'、'-' 和 '+' 组成 
 
 

 Related Topics 字符串 👍 65 👎 0

*/
  
package org.fade.leetcode.editor.cn;

public class MaskingPersonalInformationMain {
      
    public static void main(String[] args) {
        Solution solution = new MaskingPersonalInformationMain().new Solution();
        solution.maskPII("1(234)567-890");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String maskPII(String s) {
            StringBuilder builder = new StringBuilder();
            String at = "@";
            if (s.contains(at)) {
                String[] split = s.split(at);
                builder.append(Character.toLowerCase(split[0].charAt(0)))
                        .append("*****")
                        .append(Character.toLowerCase(split[0].charAt(split[0].length() - 1)))
                        .append(at)
                        .append(split[1].toLowerCase());
            } else {
                s = s.replaceAll("-", "");
                s = s.replaceAll("\\+", "");
                s = s.replaceAll("\\(", "");
                s = s.replaceAll("\\)", "");
                s = s.replaceAll(" ", "");
                int countries = s.length() - 10;
                if (countries == 0) {
                    builder.append("***-***-");
                } else if (countries == 1) {
                    builder.append("+*-***-***-");
                } else if (countries == 2) {
                    builder.append("+**-***-***-");
                } else if (countries == 3) {
                    builder.append("+***-***-***-");
                }
                builder.append(s.substring(s.length() - 4));
            }
            return builder.toString();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
        
}
