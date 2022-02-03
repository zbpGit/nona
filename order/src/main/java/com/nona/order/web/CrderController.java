package com.nona.order.web;

import com.nona.order.entity.UserOrder;
import com.nona.order.service.UserOrderService;
import com.nona.order.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.article.web</b>
 * <br><b>ClassName:ArticleController</b>
 * <br><b>Date:2022/1/8 17:06</b>
 */
@RestController
@RequestMapping(value = "/crder")
public class CrderController {

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping(value = "/getList")
    public ResponseFactory<List<UserOrder>> getList() {
        return ResponseFactory.responseSuccess(userOrderService.getUserOrderList());
    }

    @PostMapping(value = "/batchAddUserOrder")
    public ResponseFactory<Integer> batchAddUserOrder(@RequestBody List<UserOrder> userOrders) {
        return ResponseFactory.responseSuccess(userOrderService.batchAddUserOrder(userOrders));
    }

}
