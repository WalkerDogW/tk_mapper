package site.javaee.tk_mapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "site.javaee.tk_mapper.mapper")
@SpringBootApplication
public class TkMapperApplication {
    public static void main(String[] args) {
        SpringApplication.run(TkMapperApplication.class, args);
    }

}
