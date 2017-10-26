package com.secondLifeMarket.general.admin.manage;

import com.secondLifeMarket.general.admin.model.UserBrowseRecordModel;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.personal.searcher.UserBrowseRecordSearcher;

public interface UersBrowseRecordManager {

	public int addUserBrowseRecod(UserBrowseRecordModel userBrowseRecord);
	
	Page<UserBrowseRecordModel> searcherUserBrowseRecords(UserBrowseRecordSearcher searcher);
	
}
