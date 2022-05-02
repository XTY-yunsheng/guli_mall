package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author yunsheng
 * @email yunsheng@gmail.com
 * @date 2022-04-10 17:00:46
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
