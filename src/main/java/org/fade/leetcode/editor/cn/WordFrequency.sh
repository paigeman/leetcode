: '
写一个 bash 脚本以统计一个文本文件 words.txt 中每个单词出现的频率。 

 为了简单起见，你可以假设： 

 
 words.txt只包括小写字母和 ' ' 。 
 每个单词只由小写字母组成。 
 单词间由一个或多个空格字符分隔。 
 

 示例: 

 假设 words.txt 内容如下： 

 the day is sunny the the
the sunny is is
 

 你的脚本应当输出（以词频降序排列）： 

 the 4
is 3
sunny 2
day 1
 

 说明: 

 
 不要担心词频相同的单词的排序问题，每个单词出现的频率都是唯一的。 
 你可以使用一行 Unix pipes 实现吗？ 
 

 Related Topics Shell 👍 214 👎 0

'
  
#leetcode submit region begin(Prohibit modification and deletion)
# Read from the file words.txt and output the word frequency list to stdout.
file=$(<words.txt)
declare -A map
for i in $file ; do
    if [ [-v map[i]] ]; then
        map[i] = map[i] + 1
    else
        map[i] = 1
    fi
done

#leetcode submit region end(Prohibit modification and deletion)
