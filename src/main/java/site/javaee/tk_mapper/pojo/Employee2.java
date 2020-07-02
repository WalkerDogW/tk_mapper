package site.javaee.tk_mapper.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * 通用Mapper
 *
 * @author Tao
 * @create 2020/7/1 10:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tabple_emp")
public class Employee2 {
    //不标记id的话通用mapper会把所有字段结合成联合主键
    @Id
    //自增主键后返回给实体类
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String empName;
    @Column(name = "emp_salary")
    private Double empSalary;
    private Integer empAge;
    //非数据库字段
    //@Transient
    //private String  outer;
}
