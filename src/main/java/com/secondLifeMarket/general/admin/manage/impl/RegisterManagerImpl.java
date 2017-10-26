package com.secondLifeMarket.general.admin.manage.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondLifeMarket.general.admin.dao.RegisterManageDao;
import com.secondLifeMarket.general.admin.manage.RegisterManager;
import com.secondLifeMarket.general.admin.model.User;
@Service("registerManager")
public class RegisterManagerImpl implements RegisterManager{

	@Autowired
	private RegisterManageDao registerManageDao;
	
	@Override
	public int addUser(User user) {
		return registerManageDao.insert(user);
	}

}
