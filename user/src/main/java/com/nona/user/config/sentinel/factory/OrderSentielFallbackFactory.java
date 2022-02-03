package com.nona.user.config.sentinel.factory;

import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.nona.user.openFeign.OrderService;
import com.nona.user.util.ResponseFactory;
import com.nona.user.vo.UserOrderVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.config.sentinel</b>
 * <br><b>ClassName:OrderSentielFallbackFactory</b>
 * <br><b>Date:2022/1/20 11:48</b>
 */
@Component
public class OrderSentielFallbackFactory implements FallbackFactory<OrderService> {

    @Override
    public OrderService create(Throwable e) {
        return new OrderService() {
            @Override
            public ResponseFactory<List<UserOrderVo>> getList() {
                String message = null;
                if (e instanceof FlowException) {
                    message = "Order服务调用时触发了流控";
                } else if (e instanceof ParamFlowException) {
                    message = "Order服务调用时触发了参数流控";
                } else if (e instanceof AuthorityException) {
                    message = "Order服务调用时触发了授权规则";
                } else if (e instanceof SystemBlockException) {
                    message = "Order服务调用时触发了系统规则";
                } else {
                    message = "Order服务调用时触发了降级规则";
                }
                return ResponseFactory.responseSuccess(message);
            }

            @Override
            public ResponseFactory<Integer> batchAddUserOrder(List<UserOrderVo> userOrders) {
                String message = null;
                if (e instanceof FlowException) {
                    message = "Order服务调用时触发了流控";
                } else if (e instanceof ParamFlowException) {
                    message = "Order服务调用时触发了参数流控";
                } else if (e instanceof AuthorityException) {
                    message = "Order服务调用时触发了授权规则";
                } else if (e instanceof SystemBlockException) {
                    message = "Order服务调用时触发了系统规则";
                } else {
                    message = "Order服务调用时触发了降级规则";
                }
                return ResponseFactory.responseSuccess(message);
            }
        };
    }
}
