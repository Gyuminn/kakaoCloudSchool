package com.kakao.reviewapp0116.service;

import com.kakao.reviewapp0116.domain.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public Employee createEmployee(String empId, String fname, String sname) {
        Employee emp = Employee.builder()
                .empId(empId)
                .firstName(fname)
                .secondName(sname)
                .build();
        return emp;
    }
}
