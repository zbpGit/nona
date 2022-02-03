package com.nona.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nona.order.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.order.dao</b>
 * <br><b>ClassName:UserOrderDao</b>
 * <br><b>Date:2022/2/3 21:02</b>
 */
@Mapper
public interface UserOrderDao extends BaseMapper<UserOrder> {
}
