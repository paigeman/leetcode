: '
给定一个文本文件 file.txt，请只打印这个文件中的第十行。 

 示例: 

 假设 file.txt 有如下内容： 

 Line 1
Line 2
Line 3
Line 4
Line 5
Line 6
Line 7
Line 8
Line 9
Line 10
 

 你的脚本应当显示第十行： 

 Line 10
 

 说明: 1. 如果文件少于十行，你应当输出什么？ 2. 至少有三种不同的解法，请尝试尽可能多的方法来解题。 

 Related Topics Shell 👍 124 👎 0

'
  
#leetcode submit region begin(Prohibit modification and deletion)
# Read from the file file.txt and output the tenth line to stdout.
counter=1
while read line; do
    if [ counter = 10 ]; then
        echo line
    fi
    counter=$(($counter + 1))
done < file.txt
#leetcode submit region end(Prohibit modification and deletion)
