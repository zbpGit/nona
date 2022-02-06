package com.nona.user.service.impl;

import com.nona.user.openFeign.ArticleService;
import com.nona.user.openFeign.OrderService;
import com.nona.user.service.UserService;
import com.nona.user.util.ResponseFactory;
import com.nona.user.vo.ArticleVo;
import com.nona.user.vo.UserOrderVo;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.user.service</b>
 * <br><b>ClassName:UserServiceImpl</b>
 * <br><b>Date:2022/2/6 16:40</b>
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private OrderService orderService;

    @GlobalTransactional
    @Override
    public void addUserOrder() {
        ResponseFactory<List<ArticleVo>> articleServiceList = articleService.buckleOne();
        List<ArticleVo> articleVoList = articleServiceList.getData();
        List<UserOrderVo> userOrders = new ArrayList<>();
        for (ArticleVo articleVo : articleVoList) {
            UserOrderVo userOrderVo = new UserOrderVo();
            userOrderVo.setUserId("nona");
            userOrderVo.setArticleId(articleVo.getId());
            userOrders.add(userOrderVo);
        }
        orderService.batchAddUserOrder(userOrders);
    }
}
