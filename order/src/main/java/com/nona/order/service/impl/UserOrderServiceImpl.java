package com.nona.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nona.order.dao.UserOrderDao;
import com.nona.order.entity.UserOrder;
import com.nona.order.service.UserOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.order.service.impl</b>
 * <br><b>ClassName:UserOrderServiceImpl</b>
 * <br><b>Date:2022/2/3 21:03</b>
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserOrderServiceImpl extends ServiceImpl<UserOrderDao, UserOrder> implements UserOrderService {

    @Override
    public List<UserOrder> getUserOrderList() {
        return this.list();
    }

    @Override
    public Integer batchAddUserOrder(List<UserOrder> userOrders) {
        if (CollectionUtils.isEmpty(userOrders)) {
            return 0;
        }
        this.saveBatch(userOrders);
        return userOrders.size();
    }
}
