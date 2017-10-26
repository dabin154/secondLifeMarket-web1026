package com.secondLifeMarket.general.admin.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondLifeMarket.general.admin.dao.PersonDao;
import com.secondLifeMarket.general.admin.manage.PersonManager;
import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.personal.searcher.PersonSearcher;

@Service("PersonManager")
public class PersonManagerImpl implements PersonManager{
	@Autowired
	private PersonDao personDao;
	@Override
	public Page<GoodsInfo> seacherGoodsList(PersonSearcher personSearcher) {
		List<GoodsInfo> listInfos = personDao.findPersonalGoodsInfos(personSearcher);
		personSearcher.setResult(listInfos);
		return personSearcher;
	}

}
