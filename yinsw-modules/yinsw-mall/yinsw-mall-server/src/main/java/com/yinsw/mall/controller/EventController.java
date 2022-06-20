package com.yinsw.mall.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yinsw.common.log.annotation.Log;
import com.yinsw.common.log.enums.BusinessType;
import com.yinsw.common.security.annotation.RequiresPermissions;
import com.yinsw.mall.domain.Event;
import com.yinsw.mall.service.IEventService;
import com.yinsw.common.core.web.controller.BaseController;
import com.yinsw.common.core.web.domain.AjaxResult;
import com.yinsw.common.core.utils.poi.ExcelUtil;
import com.yinsw.common.core.web.page.TableDataInfo;

/**
 * 秒杀活动Controller
 * 
 * @author yinsw
 * @date 2022-06-19
 */
@RestController
@RequestMapping("/event")
public class EventController extends BaseController
{
    @Autowired
    private IEventService eventService;

    /**
     * 查询秒杀活动列表
     */
    @RequiresPermissions("mall:event:list")
    @GetMapping("/list")
    public TableDataInfo list(Event event)
    {
        startPage();
        List<Event> list = eventService.selectEventList(event);
        return getDataTable(list);
    }

    /**
     * 导出秒杀活动列表
     */
    @RequiresPermissions("mall:event:export")
    @Log(title = "秒杀活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Event event)
    {
        List<Event> list = eventService.selectEventList(event);
        ExcelUtil<Event> util = new ExcelUtil<Event>(Event.class);
        util.exportExcel(response, list, "秒杀活动数据");
    }

    /**
     * 获取秒杀活动详细信息
     */
    @RequiresPermissions("mall:event:query")
    @GetMapping(value = "/{eventId}")
    public AjaxResult getInfo(@PathVariable("eventId") Long eventId)
    {
        return AjaxResult.success(eventService.selectEventByEventId(eventId));
    }

    /**
     * 新增秒杀活动
     */
    @RequiresPermissions("mall:event:add")
    @Log(title = "秒杀活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Event event)
    {
        return toAjax(eventService.insertEvent(event));
    }

    /**
     * 修改秒杀活动
     */
    @RequiresPermissions("mall:event:edit")
    @Log(title = "秒杀活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Event event)
    {
        return toAjax(eventService.updateEvent(event));
    }

    /**
     * 删除秒杀活动
     */
    @RequiresPermissions("mall:event:remove")
    @Log(title = "秒杀活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{eventIds}")
    public AjaxResult remove(@PathVariable Long[] eventIds)
    {
        return toAjax(eventService.deleteEventByEventIds(eventIds));
    }
}
