package com.potato.web.shiro;

import com.potato.entity.SUser;
import com.potato.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AuthRealm extends AuthorizingRealm{
	
	@Autowired
	UserService userService;
    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        //获取登录用户名
        String userId = utoken.getUsername();
        //获取登录用户对象
        SUser user = null;
        if(userId!=null) {
        	user = userService.getSUserByUserId(userId);
        }
        //对象为空，新建一个用户对象
        if(user==null) {
        	user = new SUser();
        }
        //执行用户验证规则
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        //SUser user=(SUser) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
//        Set<Role> roles = user.getRoles();
//        if(roles!=null) {
//        	if(roles.size()>0) {
//                 for(Role role : roles) {
//                     Set<Menu> menus = role.getModules();
//                     if(menus.size()>0) {
//                         for(Menu module : menus) {
//                             permissions.add(module.getMname());
//                         }
//                     }
//                 }
//             }
//        }
        permissions.add("/task/list");
        permissions.add("/task/list:add");
        permissions.add("/task/list:edit");
        permissions.add("/task/list:del");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        info.addRole("user");
        return info;
    }

}
