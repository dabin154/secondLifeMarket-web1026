package com.secondLifeMarket.general.admin.model;

import java.util.List;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 18:52 2018/6/19
 * @Modified By ：
 */
public class UserRoleInfo {

    private Long id;

    private String userName;

    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
