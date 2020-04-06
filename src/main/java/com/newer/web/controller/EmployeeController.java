package com.newer.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.domain.Employee;
import com.newer.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    @RequestMapping("find")
    public List<Employee> findAll() {
        return this.empService.findAll();
    }

    //嵌套结果
    @RequestMapping("find2/{id}")
    public Employee findEmp$Dept1(@PathVariable Integer id) {
        return this.empService.findEmp$Dept1(id);
    }

    //嵌套查询
    @RequestMapping("find3/{id}")
    public Employee findEmp$Dept2(@PathVariable Integer id) {
        return this.empService.findEmp$Dept2(id);
    }

    //模拟事务管理
    //添加员工，并为其新建一个部门
    @RequestMapping("save")
    public String saveEmp(Employee emp) {
        this.empService.saveEmp(emp);
        return "sucess";
    }

}
