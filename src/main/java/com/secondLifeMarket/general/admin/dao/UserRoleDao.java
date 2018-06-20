package com.secondLifeMarket.general.admin.dao;

import com.secondLifeMarket.general.admin.model.UserRoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 18:50 2018/6/19
 * @Modified By ：
 */
public interface UserRoleDao {


    public List<UserRoleInfo> getUserRolesByUserName(@Param("userName") String userName);

    public int addUserRole(UserRoleInfo info);


}
