package com.secondLifeMarket.general.admin.dao;

import org.apache.ibatis.annotations.Param;

import com.secondLifeMarket.general.admin.model.User;

public interface LoginManageDao {
	
	public User searchUser(@Param("userName") String userName,
							@Param("passWd") String passWd);
	
	public int updateUser(User user);

	public User selectUser(@Param("userName") String userName);



}
