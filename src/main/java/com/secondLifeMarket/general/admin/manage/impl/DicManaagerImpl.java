package com.secondLifeMarket.general.admin.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondLifeMarket.general.admin.dao.DicDao;
import com.secondLifeMarket.general.admin.manage.DicManager;
import com.secondLifeMarket.general.admin.model.DicInfo;

@Service("DicManager")
public class DicManaagerImpl implements DicManager{
	@Autowired 
	private DicDao dicDao;
	@Override
	public List<DicInfo> findDicValueByName(String name) {
		
		return dicDao.queryDicValueByName(name);
	}

}
