package com.nona.config.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.rests.ribbon</b>
 * <br><b>ClassName:OrderRibbonConfig</b>
 * <br><b>Date:2022/1/8 18:08</b>
 */
@Configuration
public class ArticleRibbonConfig {

    @Bean
    public IRule articleRibbon() {
        return new RoundRobinRule();//轮询算法
        //return new RandomRule();//随机算法
        //return new RetryRule();//首先轮询，轮询发现错误的会再次重试，几次之后会自动跳过错误的请求
        //return new MyRandomRule();
    }

}
