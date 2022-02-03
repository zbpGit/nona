package com.nona.user.web.feign;

import com.nona.user.openFeign.ArticleService;
import com.nona.user.openFeign.OrderService;
import com.nona.user.util.ResponseFactory;
import com.nona.user.vo.ArticleVo;
import com.nona.user.vo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.user.web.feign</b>
 * <br><b>ClassName:FeignController</b>
 * <br><b>Date:2022/1/10 18:23</b>
 */
@RestController
@RequestMapping(value = "/feign")
public class FeignController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/test")

    public String test() {
        ResponseFactory<List<ArticleVo>> articleList = articleService.getList();
        ResponseFactory<List<UserOrderVo>> userOrderList = orderService.getList();
        return "Article:[" + articleList.getData() + "]Order:[" + userOrderList.getData() + "]";
    }
}
