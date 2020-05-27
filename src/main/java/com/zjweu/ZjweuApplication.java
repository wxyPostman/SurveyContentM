package com.zjweu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zjweu.dao")
public class ZjweuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjweuApplication.class, args);
    }

}
