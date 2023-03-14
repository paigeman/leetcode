/**
Employee 表：

 
 
 
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id 是这个表的主键。
表的每一行包含员工的工资信息。
 
 
 

 

 编写一个 SQL 查询，获取并返回 Employee 表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 null 。 

 查询结果如下例所示。 

 

 示例 1： 

 
输入：
Employee 表：
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
输出：
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
 

 示例 2： 

 
输入：
Employee 表：
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+
输出：
+---------------------+
| SecondHighestSalary |
+---------------------+
| null                |
+---------------------+
 


 Related Topics 数据库 👍 1277 👎 0

*/
  
#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below
select tmp.salary as SecondHighestSalary
from employee e
left join (
    select id, salary
    from employee
    order by salary asc
    limit 1,1
) tmp
on e.id =  tmp.id
-- order by e.salary asc
-- limit 1,1
#leetcode submit region end(Prohibit modification and deletion)
