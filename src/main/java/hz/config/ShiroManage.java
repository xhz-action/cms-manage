package hz.config;

import hz.cms.shirosource.ShiroDBRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

/**
 * Created by xhz on 2017/11/18.
 * shiro配置信息
 */

public class ShiroManage {

    /**
     * 保证实现了Shiro内部lifecycle函数的bean执行
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    @ConditionalOnMissingBean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 实现自动代理，将切面应用到相应的切点中
     * @return
     */
    @Bean(name = "DefaultAdvisorAutoProxyCreator")
    @ConditionalOnMissingBean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启shiro注释
     * @return
     */
    @Bean(name = "authorizationAttributeSourceAdvisor")
    @ConditionalOnMissingBean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "shiroDBRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public ShiroDBRealm shiroDBRealm(CacheManager defaultCacheManager){
        ShiroDBRealm shiroDBRealm = new ShiroDBRealm();
        shiroDBRealm.setCacheManager(defaultCacheManager);
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("SHA-1");
//        hashedCredentialsMatcher.setHashIterations(1024);
//        shiroDBRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return shiroDBRealm;
    }

    @Bean(name = "defaultCacheManager")
    @ConditionalOnMissingBean
    public CacheManager defaultCacheManager(){
        return new MemoryConstrainedCacheManager();
    }

    /**
     * shiro安全管理器
     * @param shiroDBRealm
     * @return
     */
    @Bean(name = "securityManager")
    @DependsOn({"defaultCacheManager","shiroDBRealm"})
    public DefaultSecurityManager securityManager(ShiroDBRealm shiroDBRealm,CacheManager defaultCacheManager){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroDBRealm);
        securityManager.setCacheManager(defaultCacheManager);
        return securityManager;
    }

}
