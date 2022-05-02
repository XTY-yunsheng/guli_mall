package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author yunsheng
 * @email yunsheng@gmail.com
 * @date 2022-04-21 11:21:21
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
