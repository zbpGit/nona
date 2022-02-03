package com.nona.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.order</b>
 * <br><b>ClassName:CrderApplication</b>
 * <br><b>Date:2022/1/8 18:03</b>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrderApplication.class, args);
    }

}
