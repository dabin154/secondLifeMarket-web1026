package com.secondLifeMarket.general.admin.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondLifeMarket.general.admin.dao.GoodsDao;
import com.secondLifeMarket.general.admin.manage.GoodsManager;
import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.goods.searcher.GoodsSearcher;
@Service("goodsManager")
public class GoodsManagerImpl implements GoodsManager{
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public int goodsAdd(GoodsInfo goodsInfo) {
	return	goodsDao.goodsAdd(goodsInfo);
		
	}

	@Override
	public Page<GoodsInfo> seacherGoodsList(GoodsSearcher goodsSearcher) {
		List<GoodsInfo> listGoods = goodsDao.searcherGoodsInfos(goodsSearcher);
		goodsSearcher.setResult(listGoods);
		return goodsSearcher;
	}

	@Override
	public GoodsInfo getGoodsDetailById(String id) {
		return goodsDao.getGoodsInfoById(id);
	}

	@Override
	public int deleteGoods(String id) {
		return goodsDao.deleteGoods(id);
	}

}
