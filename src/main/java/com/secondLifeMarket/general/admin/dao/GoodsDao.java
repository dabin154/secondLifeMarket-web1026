package com.secondLifeMarket.general.admin.dao;

import java.util.List;

import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.webapp.controller.goods.searcher.GoodsSearcher;

public interface GoodsDao {
	
	public int goodsAdd(GoodsInfo goodsInfo);
	
	public List<GoodsInfo> searcherGoodsInfos(GoodsSearcher goodsSearcher);
	
	public GoodsInfo getGoodsInfoById(String id);
	
	public int deleteGoods(String id);

}
