package com.barcode.server.config;

import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * PackageName : com.example.ssssksss_blog.config
 * FileName : MethodSecurity
 * Author : 이 수 경
 * Date : 2022-04-24
 * Description :
 */

//@Configuration
//@EnableGlobalMethodSecurity(
//        securedEnabled = true,
//        jsr250Enabled = true,
//        prePostEnabled = true
//)
public class MethodSecurity extends GlobalMethodSecurityConfiguration {
//    @Override
//    protected AccessDecisionManager accessDecisionManager() {
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
//        AffirmativeBased accessDecisionManager = (AffirmativeBased) super.accessDecisionManager();
//        accessDecisionManager.getDecisionVoters().add(new RoleHierarchyVoter(roleHierarchy));
//        return accessDecisionManager;
//    }
}
