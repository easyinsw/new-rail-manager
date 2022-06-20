package com.yinsw.mall.service;

import java.util.List;
import com.yinsw.mall.domain.Event;

/**
 * 秒杀活动Service接口
 * 
 * @author yinsw
 * @date 2022-06-19
 */
public interface IEventService 
{
    /**
     * 查询秒杀活动
     * 
     * @param eventId 秒杀活动主键
     * @return 秒杀活动
     */
    public Event selectEventByEventId(Long eventId);

    /**
     * 查询秒杀活动列表
     * 
     * @param event 秒杀活动
     * @return 秒杀活动集合
     */
    public List<Event> selectEventList(Event event);

    /**
     * 新增秒杀活动
     * 
     * @param event 秒杀活动
     * @return 结果
     */
    public int insertEvent(Event event);

    /**
     * 修改秒杀活动
     * 
     * @param event 秒杀活动
     * @return 结果
     */
    public int updateEvent(Event event);

    /**
     * 批量删除秒杀活动
     * 
     * @param eventIds 需要删除的秒杀活动主键集合
     * @return 结果
     */
    public int deleteEventByEventIds(Long[] eventIds);

    /**
     * 删除秒杀活动信息
     * 
     * @param eventId 秒杀活动主键
     * @return 结果
     */
    public int deleteEventByEventId(Long eventId);
}
