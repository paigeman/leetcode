: '
给定一个文件 file.txt，转置它的内容。 

 你可以假设每行列数相同，并且每个字段由 ' ' 分隔。 

 

 示例： 

 假设 file.txt 文件内容如下： 

 
name age
alice 21
ryan 30
 

 应当输出： 

 
name alice ryan
age 21 30
 

 Related Topics Shell 👍 72 👎 0

'
  
#leetcode submit region begin(Prohibit modification and deletion)
# Read from the file file.txt and print its transposed content to stdout.
head -n 1 file.txt | wc -w
#leetcode submit region end(Prohibit modification and deletion)
