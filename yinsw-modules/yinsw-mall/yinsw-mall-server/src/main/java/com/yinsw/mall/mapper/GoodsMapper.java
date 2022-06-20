package com.yinsw.mall.mapper;

import java.util.List;
import com.yinsw.mall.domain.Goods;

/**
 * 商品Mapper接口
 *
 * @author yinsw
 * @date 2022-06-19
 */
public interface GoodsMapper
{
    /**
     * 查询商品
     *
     * @param goodsId 商品主键
     * @return 商品
     */
    public Goods selectGoodsByGoodsId(Long goodsId);

    /**
     * 查询商品列表
     *
     * @param goods 商品
     * @return 商品集合
     */
    public List<Goods> selectGoodsList(Goods goods);

    /**
     * 新增商品
     *
     * @param goods 商品
     * @return 结果
     */
    public int insertGoods(Goods goods);

    /**
     * 修改商品
     *
     * @param goods 商品
     * @return 结果
     */
    public int updateGoods(Goods goods);

    /**
     * 删除商品
     *
     * @param goodsId 商品主键
     * @return 结果
     */
    public int deleteGoodsByGoodsId(Long goodsId);

    /**
     * 批量删除商品
     *
     * @param goodsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsByGoodsIds(Long[] goodsIds);

    List<Goods> goodsList();
}
