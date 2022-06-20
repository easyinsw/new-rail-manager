package com.yinsw.mall.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author printguy
 * @version 1.0.0
 * @className EventInfoVo.java
 * @description TODO
 * @createTime 2022年06月20日 09:29:00
 */
@Data
public class EventInfoVo {

    private Long goodsId;

    private String goodsName;

    private Long limitNum;

    private BigDecimal eventPrice;

    private Long goodsStock;

    private BigDecimal goodsPrice;

    private String goodsImg;
}
