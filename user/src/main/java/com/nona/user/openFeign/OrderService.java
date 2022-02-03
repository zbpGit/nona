package com.nona.user.openFeign;

import com.nona.user.config.FeignConfig;
import com.nona.user.config.sentinel.factory.OrderSentielFallbackFactory;
import com.nona.user.util.ResponseFactory;
import com.nona.user.vo.UserOrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.user.openFeign</b>
 * <br><b>ClassName:ArticleService</b>
 * <br><b>Date:2022/1/10 17:46</b>
 */
@FeignClient(value = "order-service", path = "/crder", fallbackFactory = OrderSentielFallbackFactory.class, configuration = FeignConfig.class)
public interface OrderService {

    @GetMapping(value = "/getList")
    ResponseFactory<List<UserOrderVo>> getList();

    @PostMapping(value = "/batchAddUserOrder")
    ResponseFactory<Integer> batchAddUserOrder(@RequestBody List<UserOrderVo> userOrders);

}
