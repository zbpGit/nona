package com.nona.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nona.order.entity.UserOrder;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.order.service</b>
 * <br><b>ClassName:UserOrderService</b>
 * <br><b>Date:2022/2/3 21:02</b>
 */
public interface UserOrderService extends IService<UserOrder> {

    List<UserOrder> getUserOrderList();

    Integer batchAddUserOrder(List<UserOrder> userOrders);

}
