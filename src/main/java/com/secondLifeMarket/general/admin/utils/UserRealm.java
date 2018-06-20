package com.secondLifeMarket.general.admin.utils;

import com.secondLifeMarket.general.admin.manage.impl.UserServiceImpl;
import com.secondLifeMarket.general.admin.model.Permission;
import com.secondLifeMarket.general.admin.model.Role;
import com.secondLifeMarket.general.admin.model.User;
import com.secondLifeMarket.general.admin.model.UserRoleInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Realm
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 16:00 2018/5/8
 * @Modified By ：
 */
public class UserRealm extends AuthorizingRealm {
    // 用户对应的角色信息与权限信息都保存在数据库中，通过UserService获取数据

    @Resource
    private UserServiceImpl userService;

    /**
     * 提供用户信息返回权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Set<UserRoleInfo> roles = userService.findRolesByUserName(username);
        Set<String> roleNames = new HashSet<String>();
        for (UserRoleInfo role : roles) {
            roleNames.add(role.getRoleName());
        }
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleNames);
        // 根据用户名查询当前用户权限
        Set<Permission> permissions = userService.findPermissions(username);
        Set<String> permissionNames = new HashSet<String>();
        for (Permission permission : permissions) {
            permissionNames.add(permission.getPermission());
        }
        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(permissionNames);
        return authorizationInfo;
    }

    /**
     * 提供账户信息返回认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.findByUsername(username);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }
        if ("0".equals(user.getLocked())) {
            // 用户被管理员锁定抛出异常
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
                user.getPassWd(), getName());
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username)); // 加盐值
        return authenticationInfo;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("412592", "jack");
        System.out.println(md5Hash.toString());
        System.out.println(md5Hash);
    }
}
