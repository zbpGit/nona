package com.nona.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.article.config</b>
 * <br><b>ClassName:Swagger2Conf</b>
 * <br><b>Date:2022/2/3 20:15</b>
 */
@Configuration
@EnableSwagger2
public class Swagger2Conf {

    @Bean
    public Docket getUserDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("订单管理")//api标题
                .description("订单管理相关接口描述")//api描述
                .version("1.0.0")//版本号
                .contact("sabre")//本API负责人的联系信息
                .build();
        return new Docket(DocumentationType.SWAGGER_2)//文档类型（swagger2）
                .apiInfo(apiInfo)//设置包含在json ResourceListing响应中的api元信息
                .select()//启动用于api选择的构建器
                .apis(RequestHandlerSelectors.basePackage("com.nona.order.web"))//扫描接口的包
                .paths(PathSelectors.any())//路径过滤器（扫描所有路径）
                .build();
    }

}
