package com.yinsw.mall.remote;

import com.yinsw.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author printguy
 * @version 1.0.0
 * @className RemoteMallGoods.java
 * @description TODO
 * @createTime 2022年06月19日 14:27:00
 */
@FeignClient(value = ServiceNameConstants.MALL_SERVICE, path = "/goods")
public interface RemoteMallGoods {
}
