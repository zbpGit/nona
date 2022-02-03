package com.nona.user;

import com.nona.config.ribbon.ArticleRibbonConfig;
import com.nona.config.ribbon.OrderRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona</b>
 * <br><b>ClassName:UserApplication</b>
 * <br><b>Date:2022/1/8 14:59</b>
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClients(value = {@RibbonClient(name = "order-service", configuration = OrderRibbonConfig.class), @RibbonClient(name = "article-service", configuration = ArticleRibbonConfig.class)})
@EnableFeignClients
public class UserApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(UserApplication.class, args);
//        while (true) {
//            //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
//            String property = run.getEnvironment().getProperty("server.port");
//            System.err.println("server.port:" + property);
//            TimeUnit.SECONDS.sleep(1);
//        }
    }

}
