package com.secondLifeMarket.general.admin.manage.impl;

import com.secondLifeMarket.general.admin.manage.UserService;
import com.secondLifeMarket.general.admin.model.Permission;
import com.secondLifeMarket.general.admin.model.Role;
import com.secondLifeMarket.general.admin.model.User;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 14:45 2018/6/15
 * @Modified By ：
 */
@Service
public class UserServiceImpl implements UserService {

    public Set<Role> findRolesByUserName(String userName){

        return null;
    }

    public Set<Permission> findPermissions(String userName){

        return null;
    }

    public User findByUsername(String userName){

        return null;
    }
}
