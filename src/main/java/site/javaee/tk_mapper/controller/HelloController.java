package site.javaee.tk_mapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.javaee.tk_mapper.mapper.EmployeeMapper;
import site.javaee.tk_mapper.mapper.EmployeeMapper2;
import site.javaee.tk_mapper.pojo.Employee;
import site.javaee.tk_mapper.pojo.Employee2;

import java.util.List;

/**
 * @author Tao
 * @create 2020/6/30 16:55
 */
@Controller
public class HelloController {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeMapper2 employeeMapper2;

    @ResponseBody
    @RequestMapping("/hello")
    public String helloThymeleaf(){
        List<Employee> list =  employeeMapper.getEmployeeList();
        Employee2 employeeQueryCondition = new Employee2(null, "bob", 5560.11, null);
        Employee2 employeeQueryResult = employeeMapper2.selectOne(employeeQueryCondition);
        return employeeQueryResult.toString();
        //return list.toString();
    }
}
