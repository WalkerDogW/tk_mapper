package site.javaee.tk_mapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.javaee.tk_mapper.mapper.EmployeeMapper2;
import site.javaee.tk_mapper.pojo.Employee2;

/**
 * 通用Mapper
 *
 * @author Tao
 * @create 2020/7/1 11:46
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper2 employeeMapper;

    public Employee2 getOne(Employee2 employeeQueryCondition) {
        return employeeMapper.selectOne(employeeQueryCondition);
    }

}
