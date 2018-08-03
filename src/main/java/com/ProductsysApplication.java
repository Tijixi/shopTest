package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = { "com.example"})
public class ProductsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsysApplication.class, args);
    }
}
