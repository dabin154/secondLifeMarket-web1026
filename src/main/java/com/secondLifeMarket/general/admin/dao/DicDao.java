package com.secondLifeMarket.general.admin.dao;

import java.util.List;

import com.secondLifeMarket.general.admin.model.DicInfo;

public interface DicDao {
	
	public List<DicInfo> queryDicValueByName(String name);

}
