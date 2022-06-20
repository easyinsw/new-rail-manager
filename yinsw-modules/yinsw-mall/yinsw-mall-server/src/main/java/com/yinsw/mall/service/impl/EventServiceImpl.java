package com.yinsw.mall.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yinsw.mall.domain.EventInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yinsw.mall.mapper.EventMapper;
import com.yinsw.mall.domain.Event;
import com.yinsw.mall.service.IEventService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 秒杀活动Service业务层处理
 *
 * @author yinsw
 * @date 2022-06-19
 */
@Service
public class EventServiceImpl implements IEventService
{
    @Autowired
    private EventMapper eventMapper;

    /**
     * 查询秒杀活动
     *
     * @param eventId 秒杀活动主键
     * @return 秒杀活动
     */
    @Override
    public Event selectEventByEventId(Long eventId)
    {
        Event event = eventMapper.selectEventByEventId(eventId);
        return event;
    }

    /**
     * 查询秒杀活动列表
     *
     * @param event 秒杀活动
     * @return 秒杀活动
     */
    @Override
    public List<Event> selectEventList(Event event)
    {
        return eventMapper.selectEventList(event);
    }

    /**
     * 新增秒杀活动
     *
     * @param event 秒杀活动
     * @return 结果
     */
    @Override
    @Transactional
    public int insertEvent(Event event)
    {
        int i = eventMapper.insertEvent(event);
        eventMapper.insertEvent2(event,event.getList());
        return i;
    }

    /**
     * 修改秒杀活动
     *
     * @param event 秒杀活动
     * @return 结果
     */
    @Override
    public int updateEvent(Event event)
    {
        return eventMapper.updateEvent(event);
    }

    /**
     * 批量删除秒杀活动
     *
     * @param eventIds 需要删除的秒杀活动主键
     * @return 结果
     */
    @Override
    public int deleteEventByEventIds(Long[] eventIds)
    {
        eventMapper.deleteMiddleByEventIds(eventIds);
        return eventMapper.deleteEventByEventIds(eventIds);
    }

    /**
     * 删除秒杀活动信息
     *
     * @param eventId 秒杀活动主键
     * @return 结果
     */
    @Override
    public int deleteEventByEventId(Long eventId)
    {
        eventMapper.deleteMiddleByEventId(eventId);
        return eventMapper.deleteEventByEventId(eventId);
    }
}
