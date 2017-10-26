package com.secondLifeMarket.general.admin.manage.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.secondLifeMarket.general.admin.contents.UserAuthoritySubject;
import com.secondLifeMarket.general.admin.dao.LoginManageDao;
import com.secondLifeMarket.general.admin.manage.LoginManager;
import com.secondLifeMarket.general.admin.model.User;
@Service("loginManager")
public class LoginManagerImpl implements LoginManager{
	
	@Autowired
	private LoginManageDao loginManageDao;
	
	public int findUserByUserNameAndPass(String userName, String passWd) {
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWd)) return 0;
		User user = loginManageDao.searchUser(userName, passWd);
		if(user!=null){
			UserAuthoritySubject.setAccountSubject(user);
			return 1;
		}
		return 0;
	}

	@Override
	public User findUser(String userName, String Passwd) {
		
		return loginManageDao.searchUser(userName, Passwd);
	}

	@Override
	public int updateUser(User user) {
		
		
		return 0;
	}

}
