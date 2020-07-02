package site.javaee.tk_mapper.mapper;

import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.javaee.tk_mapper.pojo.Employee;
import site.javaee.tk_mapper.pojo.Employee2;
import site.javaee.tk_mapper.service.EmployeeService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Tao
 * @create 2020/6/30 20:05
 */
@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    EmployeeMapper2 employeeMapper2;

    @Autowired
    EmployeeService employeeService;





    /*查询*/
    //查一
    @Test
    void testSelectOne() {
        Employee2 employeeQueryCondition = new Employee2(null, "bob", 5560.11, null);
        Employee2 employeeQueryResult = employeeService.getOne(employeeQueryCondition);
        System.out.println(employeeQueryResult);
    }
    //查多
    @Test
    void testSelect() {
        Employee2 employeeQueryCondition = new Employee2();
        List<Employee2> employeeQueryResult = employeeMapper2.select(employeeQueryCondition);
        System.out.println(employeeQueryResult);
    }
    //查所有
    @Test
    void testSelectAll() {
        List<Employee2> employeeQueryResult = employeeMapper2.selectAll();
        System.out.println(employeeQueryResult);
    }
    //根据主键查
    @Test
    void testSelectByPrimaryKey() {
        Integer empId = 3;
        Employee2 employeeQueryResult = employeeMapper2.selectByPrimaryKey(empId);
        System.out.println(employeeQueryResult);
    }
    //是否存在
    @Test
    void testExistsWithPrimaryKey() {
        Integer empId = 3;
        boolean employeeQueryResult = employeeMapper2.existsWithPrimaryKey(empId);
        System.out.println(employeeQueryResult);
    }
    //计数
    @Test
    void testSelectCount() {
        int result = employeeMapper2.selectCount(null);
        System.out.println(result);
    }


    /*增加*/
    @Test
    void testInsert() {
        Employee2 employee = new Employee2(null, "tagi", 8942.24, 28);
        int insertLine = employeeMapper2.insert(employee);
        //默认返回插入的数量，
        System.out.println(insertLine);
        //也可以返回自增的主键
        int empId = employee.getEmpId();
        System.out.println(empId);
    }
    //实体类中null属性不插入，简化sql语句
    @Test
    void testInsertSelective() {
        Employee2 employee = new Employee2(null, "yago", null, 33);
        int insertLine = employeeMapper2.insertSelective(employee);
        System.out.println(insertLine);
    }




    /*更新*/
    @Test
    void testUpdateByPrimaryKey() {
    }
    //实体类中null属性不更新
    @Test
    void testUpdateByPrimaryKeySelective() {
        Employee2 employee = new Employee2(9, "yoga", 1195.78       , null);
        int result = employeeMapper2.updateByPrimaryKeySelective(employee);
        System.out.println(result);
    }




    /*删除*/
    @Test
    void testDelete() {
        //如果传入的实体类是null，会把表清空
    }
    //根据主键删除
    @Test
    void testDeleteByPrimaryKey() {
        Integer empId = 9;
        int result = employeeMapper2.deleteByPrimaryKey(empId);
        System.out.println(result);
    }





    //复杂条件的查询
    @Test
    void testSelectByExample() {
        Example example = new Example(Employee2.class);
        //排序
        example.orderBy("empSalary").asc().orderBy("empAge").desc();

        //去重
        example.setDistinct(true);

        //选择字段
        example.selectProperties("empName","empSalary");

        //where 条件
        Example.Criteria criteria = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();
        criteria.andGreaterThan("empSalary", 3000)
                .andLessThan("empAge", 25);
        criteria2.andGreaterThan("empSalary",5000)
                .andLessThan("empAge", 30);
        example.or(criteria2);

        List<Employee2> list = employeeMapper2.selectByExample(example);
        System.out.println(list);
    }









    @Test
    void testDeleteByExample() {
    }



    @Test
    void testSelectCountByExample() {
    }

    @Test
    void testSelectOneByExample() {
    }

    @Test
    void testUpdateByExample() {
    }

    @Test
    void testUpdateByExampleSelective() {
    }

    @Test
    void testSelectByExampleAndRowBounds() {
    }


    //分页
    @Test
    void testSelectByRowBounds() {
        int pageNo=1;
        int pageSize=5;
        int index = (pageNo-1)*pageSize;
        RowBounds rowBounds = new RowBounds(index,pageSize);

        List<Employee2> list = employeeMapper2.selectByRowBounds(new Employee2(), rowBounds);
        System.out.println(list);
    }
}