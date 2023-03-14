/**
表：Employee 

 
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| salary      | int     |
| managerId   | int     |
+-------------+---------+
Id是该表的主键。
该表的每一行都表示雇员的ID、姓名、工资和经理的ID。
 

 

 编写一个SQL查询来查找收入比经理高的员工。 

 以 任意顺序 返回结果表。 

 查询结果格式如下所示。 

 

 示例 1: 

 
输入: 
Employee 表:
+----+-------+--------+-----------+
| id | name  | salary | managerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | Null      |
| 4  | Max   | 90000  | Null      |
+----+-------+--------+-----------+
输出: 
+----------+
| Employee |
+----------+
| Joe      |
+----------+
解释: Joe 是唯一挣得比经理多的雇员。 

 Related Topics 数据库 👍 585 👎 0

*/
  
#leetcode submit region begin(Prohibit modification and deletion)
# Write your MySQL query statement below
select e1.name as Employee
from Employee e1
left join Employee e2
on e1.managerId = e2.id
where e1.salary > e2.salary
#leetcode submit region end(Prohibit modification and deletion)
