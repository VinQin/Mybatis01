package edu.stu.mybatis.dao;

import edu.stu.mybatis.bean.Employee;

public interface EmployeeMapper {

    Employee getEmployeeById(Integer id);
}
