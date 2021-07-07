package com.xinlei.log4j2demo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.xinlei")
public class Log4j2demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Log4j2demo2Application.class, args);
    }

}
