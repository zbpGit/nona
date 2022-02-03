package com.nona.user.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.user.config</b>
 * <br><b>ClassName:FeignConfig</b>
 * <br><b>Date:2022/1/11 11:17</b>
 */
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
