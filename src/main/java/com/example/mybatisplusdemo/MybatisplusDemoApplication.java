package com.example.mybatisplusdemo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qinzh
 */
@SpringBootApplication
@MapperScan("com.example.mybatisplusdemo.mapper")
@NacosPropertySource(dataId = "mybatisPlus-Demo",autoRefreshed = true)
public class MybatisplusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusDemoApplication.class, args);
        System.out.println("============MybatisplusDemoApplication============启动成功");
    }

}
