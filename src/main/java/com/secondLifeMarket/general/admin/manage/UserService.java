package com.secondLifeMarket.general.admin.manage;

import com.secondLifeMarket.general.admin.model.Permission;
import com.secondLifeMarket.general.admin.model.Role;
import com.secondLifeMarket.general.admin.model.User;
import com.secondLifeMarket.general.admin.model.UserRoleInfo;

import java.util.Set;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 14:45 2018/6/15
 * @Modified By ：
 */
public interface UserService {

    Set<UserRoleInfo> findRolesByUserName(String userName);

    Set<Permission> findPermissions(String userName);

    User findByUsername(String userName);
}
