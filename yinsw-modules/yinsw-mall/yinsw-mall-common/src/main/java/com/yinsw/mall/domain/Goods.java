package com.yinsw.mall.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yinsw.common.core.annotation.Excel;
import com.yinsw.common.core.web.domain.BaseEntity;

/**
 * 商品对象 tb_goods
 *
 * @author yinsw
 * @date 2022-06-19
 */
public class Goods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long goodsId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String goodsImg;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal goodsPrice;

    /** 商品库存 */
    @Excel(name = "商品库存")
    private Long goodsStock;

    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName()
    {
        return goodsName;
    }
    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public String getGoodsImg()
    {
        return goodsImg;
    }
    public void setGoodsPrice(BigDecimal goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsPrice()
    {
        return goodsPrice;
    }
    public void setGoodsStock(Long goodsStock)
    {
        this.goodsStock = goodsStock;
    }

    public Long getGoodsStock()
    {
        return goodsStock;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("goodsImg", getGoodsImg())
            .append("goodsPrice", getGoodsPrice())
            .append("goodsStock", getGoodsStock())
            .toString();
    }
}
