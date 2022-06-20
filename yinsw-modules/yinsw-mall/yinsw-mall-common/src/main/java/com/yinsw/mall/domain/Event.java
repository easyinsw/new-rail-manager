package com.yinsw.mall.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yinsw.common.core.annotation.Excel;
import com.yinsw.common.core.web.domain.BaseEntity;

/**
 * 秒杀活动对象 tb_event
 *
 * @author yinsw
 * @date 2022-06-19
 */
@Data
public class Event extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动表id */
    private Long eventId;

    /** 活动名称 */
    @Excel(name = "活动名称")
    private String eventName;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 活动描述 */
    @Excel(name = "活动描述")
    private String description;

    /** 是否开启 */
    @Excel(name = "是否开启")
    private Long status;

    /** 活动图片 */
    @Excel(name = "活动图片")
    private String eventImg;

    private Long goodsId;

    private Long limitNum;

    private BigDecimal eventPrice;

    private Long middleId;

    private String goodsName;

    private String goodsImg;

    private BigDecimal goodsPrice;

    private Long goodsStock;

    private Set<EventInfoVo> list;
}
