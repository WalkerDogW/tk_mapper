package site.javaee.tk_mapper.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import site.javaee.tk_mapper.pojo.Employee;

import java.util.List;


/**
 * Mybatis
 *
 * @author Tao
 * @create 2020/7/1 10:40
 */
@Repository
@Mapper
public interface EmployeeMapper {
    @Select("Select * from tabple_emp")
    List<Employee> getEmployeeList();
}
