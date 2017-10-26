package com.secondLifeMarket.general.admin.dao;

import java.util.List;

import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.webapp.controller.personal.searcher.PersonSearcher;

public interface PersonDao {
	
	public List<GoodsInfo> findPersonalGoodsInfos(PersonSearcher personSearcher);

}
