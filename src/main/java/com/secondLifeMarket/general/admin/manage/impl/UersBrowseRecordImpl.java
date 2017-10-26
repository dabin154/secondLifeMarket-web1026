package com.secondLifeMarket.general.admin.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondLifeMarket.general.admin.dao.UersBrowseRecordDao;
import com.secondLifeMarket.general.admin.manage.UersBrowseRecordManager;
import com.secondLifeMarket.general.admin.model.UserBrowseRecordModel;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.personal.searcher.UserBrowseRecordSearcher;
@Service("uersBrowseRecordManager")
public class UersBrowseRecordImpl implements UersBrowseRecordManager{
	@Autowired
	private UersBrowseRecordDao uersBrowseRecordDao;
	
	@Override
	public int addUserBrowseRecod(UserBrowseRecordModel userBrowseRecord) {
		
		return uersBrowseRecordDao.addUserBrowseRecod(userBrowseRecord);
	}

	@Override
	public Page<UserBrowseRecordModel> searcherUserBrowseRecords(UserBrowseRecordSearcher searcher) {
		
		List<UserBrowseRecordModel> listRecordModels = uersBrowseRecordDao.findBrowseList(searcher);
		searcher.setResult(listRecordModels);
		return searcher;
	}

}
