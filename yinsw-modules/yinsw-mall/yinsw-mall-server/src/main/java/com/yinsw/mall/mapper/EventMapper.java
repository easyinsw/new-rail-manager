package com.yinsw.mall.mapper;

import java.util.List;
import java.util.Set;

import com.yinsw.mall.domain.Event;
import com.yinsw.mall.domain.EventInfoVo;
import com.yinsw.mall.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 秒杀活动Mapper接口
 *
 * @author yinsw
 * @date 2022-06-19
 */
@Mapper
public interface EventMapper
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
     * 删除秒杀活动
     *
     * @param eventId 秒杀活动主键
     * @return 结果
     */
    public int deleteEventByEventId(Long eventId);

    /**
     * 批量删除秒杀活动
     *
     * @param eventIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEventByEventIds(Long[] eventIds);

    void insertEvent2(@Param("event") Event event, @Param("gList") Set<EventInfoVo> gList);

    void deleteMiddleByEventId(Long eventId);

    void deleteMiddleByEventIds(Long[] eventIds);
}
