package io.github.jast90.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by jast90 on 2021/3/15
 */
@SpringBootApplication(scanBasePackages = "io.github.jast90")
@EnableDiscoveryClient
@MapperScan("io.github.jast90.*.mapper")
public class ResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

}
