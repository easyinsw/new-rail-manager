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
import com.yinsw.mall.domain.Goods;
import com.yinsw.mall.service.IGoodsService;
import com.yinsw.common.core.web.controller.BaseController;
import com.yinsw.common.core.web.domain.AjaxResult;
import com.yinsw.common.core.utils.poi.ExcelUtil;
import com.yinsw.common.core.web.page.TableDataInfo;

/**
 * 商品Controller
 *
 * @author yinsw
 * @date 2022-06-19
 */
@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController
{
    @Autowired
    private IGoodsService goodsService;


    @GetMapping("/goodsList")
    public List<Goods> goodsList() {
        List<Goods> goods = goodsService.goodsList();
        return goods;
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("mall:goods:list")
    @GetMapping("/list")
    public TableDataInfo list(Goods goods)
    {
        startPage();
        List<Goods> list = goodsService.selectGoodsList(goods);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("mall:goods:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Goods goods)
    {
        List<Goods> list = goodsService.selectGoodsList(goods);
        ExcelUtil<Goods> util = new ExcelUtil<Goods>(Goods.class);
        util.exportExcel(response, list, "商品数据");
    }

    /**
     * 获取商品详细信息
     */
    @RequiresPermissions("mall:goods:query")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return AjaxResult.success(goodsService.selectGoodsByGoodsId(goodsId));
    }

    /**
     * 新增商品
     */
    @RequiresPermissions("mall:goods:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Goods goods)
    {
        return toAjax(goodsService.insertGoods(goods));
    }

    /**
     * 修改商品
     */
    @RequiresPermissions("mall:goods:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Goods goods)
    {
        return toAjax(goodsService.updateGoods(goods));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("mall:goods:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(goodsService.deleteGoodsByGoodsIds(goodsIds));
    }
}
