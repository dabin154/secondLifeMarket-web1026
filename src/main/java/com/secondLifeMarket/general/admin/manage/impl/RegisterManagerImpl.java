package com.secondLifeMarket.general.admin.manage.impl;

import com.secondLifeMarket.general.admin.dao.UserRoleDao;
import com.secondLifeMarket.general.admin.model.UserRoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondLifeMarket.general.admin.dao.RegisterManageDao;
import com.secondLifeMarket.general.admin.manage.RegisterManager;
import com.secondLifeMarket.general.admin.model.User;

import javax.annotation.Resource;

@Service("registerManager")
public class RegisterManagerImpl implements RegisterManager{

	@Autowired
	private RegisterManageDao registerManageDao;

	@Resource
	private UserRoleDao userRoleDao;
	
	@Override
	public int addUser(User user) {
		registerManageDao.insert(user);
		UserRoleInfo info = new UserRoleInfo();
		info.setRoleName("buyer");
		info.setUserName(user.getUserName());
		userRoleDao.addUserRole(info);
		return 0;
	}

}
