package com.secondLifeMarket.general.admin.manage.impl;

import com.secondLifeMarket.general.admin.dao.LoginManageDao;
import com.secondLifeMarket.general.admin.dao.UserRoleDao;
import com.secondLifeMarket.general.admin.manage.UserService;
import com.secondLifeMarket.general.admin.model.Permission;
import com.secondLifeMarket.general.admin.model.Role;
import com.secondLifeMarket.general.admin.model.User;
import com.secondLifeMarket.general.admin.model.UserRoleInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 14:45 2018/6/15
 * @Modified By ：
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private LoginManageDao loginManageDao;
    @Resource
    private UserRoleDao userRoleDao;



    public Set<UserRoleInfo> findRolesByUserName(String userName){
        List<UserRoleInfo> listRoles = userRoleDao.getUserRolesByUserName(userName);
        Set<UserRoleInfo> setRole = new HashSet<UserRoleInfo>(listRoles);
        return setRole;
    }

    public Set<Permission> findPermissions(String userName){

        return null;
    }

    public User findByUsername(String userName){

        return loginManageDao.selectUser(userName);
    }
}
