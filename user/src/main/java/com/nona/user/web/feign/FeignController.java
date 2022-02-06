package com.nona.user.web.feign;

import com.nona.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private UserService userService;

    @GetMapping(value = "/addUserOrder")
    public String addUserOrder() {
        userService.addUserOrder();
        return "OK";
    }
}
