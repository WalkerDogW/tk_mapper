package site.javaee.tk_mapper.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mybatis
 *
 * @author Tao
 * @create 2020/7/1 10:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;
    private Integer empAge;
}
