package com.archforce.demo.ddd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Zak
 */

@SpringBootApplication(scanBasePackages = {"com.archforce.demo.ddd", "com.alibaba.cola"})
@MapperScan("com.archforce.demo.ddd.tunnel.database")
public class DddDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddDemoApplication.class, args);
    }

}
