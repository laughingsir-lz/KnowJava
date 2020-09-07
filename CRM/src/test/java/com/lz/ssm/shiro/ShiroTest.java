package com.lz.ssm.shiro;

import com.lz.ssm.util.PasswordUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.UUID;

/**
 * @author zzz
 * @date 2020/8/26  10:10
 */
public class ShiroTest {
    @Test
    public void testLogin(){
        //安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 加载配置   （数据源）
      IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        //CrmRealm crmRealm = new CrmRealm();
        securityManager.setRealm(iniRealm);
        // 注入管理器
        SecurityUtils.setSecurityManager(securityManager);

        // 实现认证
        // 获取主体对象 subject （访问系统的用户） （在shiro中 无论登录与否 都能获得主体对象）
        // 判断是否登录  需要利用subject的一个状态
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isAuthenticated());
        UsernamePasswordToken token = new UsernamePasswordToken("lisi","666");
        subject.login(token);
        System.out.println(subject.isAuthenticated());

        System.out.println("是否有角色role1:"+subject.hasRole("role1"));
        //没有返回值 没有角色就报错
        subject.checkRole("role2");
//判断用户是否有某个权限
        //
        System.out.println(subject.isPermitted("user:delete"));
        System.out.println(subject.isPermitted("user:update"));


        subject.logout();
        System.out.println(subject.isAuthenticated());
    }
    @Test
    public void Md5(){
        Md5Hash md5Hash = new Md5Hash("1","0002d5",2);
        System.out.println(UUID.randomUUID().toString().substring(0, 6));
        System.out.println(md5Hash);
    }
    @Test
    public void testMd5(){
        System.out.println(PasswordUtils.md5Pwd("1","赵总"));
    }
}
