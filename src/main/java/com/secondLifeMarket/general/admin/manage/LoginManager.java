package com.secondLifeMarket.general.admin.manage;

import com.secondLifeMarket.general.admin.model.User;


public interface LoginManager {
	
	public int findUserByUserNameAndPass(String userName,String Passwd);
    
	public User findUser(String userName,String Passwd);
	
	public int updateUser(User user);
	
}
