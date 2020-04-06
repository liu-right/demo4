package com.newer.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.domain.Department;
import com.newer.domain.Employee;

import tk.mybatis.mapper.common.Mapper;

public interface EmployeeMapper extends Mapper<Employee> {
    //嵌套结果：连接查询
    @Select("select * from t_emp a,t_dept b where a.dept_id=b.dept_id and a.emp_id=#{id} ")
    @Results({
            @Result(column = "emp_id", property = "empId"),
            @Result(column = "emp_name", property = "empName"),
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "dept_id", property = "dept.deptId"),
            @Result(column = "dept_name", property = "dept.deptName")
    })
    public Employee findEmp$Dept1(Integer id);

    //嵌套查询：另外发送sql语句去查询其关联对象，存在1+N问题
    @Select("select * from t_emp  where emp_id=#{id} ")
    @Results({
            @Result(column = "emp_id", property = "empId"),
            @Result(column = "emp_name", property = "empName"),
            @Result(column = "dept_id", property = "deptId"),
            @Result(property = "dept", column = "dept_id",
                    one = @One(select = "com.newer.dao.DepartmentMapper.selectByPrimaryKey"),
                    javaType = Department.class)
    })
    public Employee findEmp$Dept2(Integer id);

}
