package com.secondLifeMarket.general.admin.manage;

import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.personal.searcher.PersonSearcher;

public interface PersonManager {
	
	public Page<GoodsInfo> seacherGoodsList(PersonSearcher personSearcher);
	
	
}
