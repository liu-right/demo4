package com.newer.service;

import java.util.List;

import com.newer.domain.Employee;

public interface EmployeeService {
    public List<Employee> findAll();

    //嵌套结果
    public Employee findEmp$Dept1(Integer id);

    //嵌套查询
    public Employee findEmp$Dept2(Integer id);

    //模拟事务管理
    //添加员工，并为其新建一个部门
    public void saveEmp(Employee emp);
}
