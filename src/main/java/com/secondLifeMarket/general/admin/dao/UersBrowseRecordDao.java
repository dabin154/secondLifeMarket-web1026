package com.secondLifeMarket.general.admin.dao;

import java.util.List;

import com.secondLifeMarket.general.admin.model.UserBrowseRecordModel;
import com.secondLifeMarket.general.admin.webapp.controller.personal.searcher.UserBrowseRecordSearcher;

public interface UersBrowseRecordDao {
	
	public int addUserBrowseRecod(UserBrowseRecordModel userBrowseRecord);
	
	public List<UserBrowseRecordModel> findBrowseList(UserBrowseRecordSearcher searcher);
	
}
