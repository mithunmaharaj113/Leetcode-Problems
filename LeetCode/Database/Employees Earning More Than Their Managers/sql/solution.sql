select e.name as Employee
from employee e join
employee a
on e.managerId=a.id
where e.salary>a.salary;




