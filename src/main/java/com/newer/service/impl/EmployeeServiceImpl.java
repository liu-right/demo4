package com.newer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newer.dao.DepartmentMapper;
import com.newer.dao.EmployeeMapper;
import com.newer.domain.Department;
import com.newer.domain.Employee;
import com.newer.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper empMapper;
    @Autowired
    private DepartmentMapper deptMapper;

    @Override
    public List<Employee> findAll() {
        return this.empMapper.selectAll();
    }

    @Override
    public Employee findEmp$Dept1(Integer id) {
        // TODO Auto-generated method stub

        return this.empMapper.findEmp$Dept1(id);
    }

    @Override
    public Employee findEmp$Dept2(Integer id) {
        // TODO Auto-generated method stub
        return this.empMapper.findEmp$Dept2(id);
    }

    //模拟事务管理
    //添加员工，并为其新建一个部门
    //在类或者方法上加上注解@Transactional
    @Transactional
    @Override
    public void saveEmp(Employee emp) {
        //添加部门，返回部门id
        this.deptMapper.insert(emp.getDept());

        //将部门回点的id，赋值给emp的deptId属性
        emp.setDeptId(emp.getDept().getDeptId());
        //添加员工
        this.empMapper.insert(emp);
    }

}
