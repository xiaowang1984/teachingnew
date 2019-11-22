package com.neuedu;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by wangyu on 2019/8/14.
 */
@SpringBootApplication
@MapperScan("com.neuedu.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
