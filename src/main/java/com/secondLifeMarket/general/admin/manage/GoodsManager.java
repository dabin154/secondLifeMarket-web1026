package com.secondLifeMarket.general.admin.manage;

import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.goods.searcher.GoodsSearcher;

public interface GoodsManager {
	
	public Page<GoodsInfo> seacherGoodsList(GoodsSearcher goodsSearcher);
	
	public int goodsAdd(GoodsInfo goodsInfo);
	
	public GoodsInfo getGoodsDetailById(String id);
	
	public int deleteGoods(String id);

}
