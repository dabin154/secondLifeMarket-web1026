package com.secondLifeMarket.general.admin.manage;

import java.util.List;

import com.secondLifeMarket.general.admin.model.DicInfo;

public interface DicManager {
  
	public List<DicInfo> findDicValueByName(String name);
	
}
