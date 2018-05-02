package hz.cms.controller;

import hz.cms.model.Organization;
import hz.cms.model.SysMenu;
import hz.cms.service.OrganizationService;
import hz.cms.service.SysMenuService;
import hz.cms.service.SysRoleService;
import hz.cms.service.SysUserService;
import hz.cms.vo.OrganizationVO;
import hz.cms.vo.SysMenuVO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xhz on 2017/11/17.
 */
@Controller
@RequestMapping("/cms")
public class IndexController {

    @Autowired
    MemoryConstrainedCacheManager cacheManager;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private ThreadDemo threadDemo;


    @RequestMapping("/index")
    @RequiresPermissions("test")
    public String index(Map model){
        List<Organization> organizationList = organizationService.findTopOrganization();
        List<OrganizationVO> orgTree = new ArrayList<OrganizationVO>();
        getOrganziationTree(organizationList, orgTree,null);
        List<SysMenu> sysMenuList = sysMenuService.findTopSysMenu();
        List<SysMenuVO> menuTree = new ArrayList<SysMenuVO>();
        getMenuTree(sysMenuList,menuTree,null);
        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder()
                .setSubject("Joe")
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        model.put("a","aaaaaaa");
        System.out.println(Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getHeader());
        System.out.println(key.getFormat());
        int arr[][] =new int[3][3];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            Cache<Object, Object> cache = null;
            cache = cacheManager.getCache("share.spring.session.config.ShiroDbRealm.authorizationCache");
            cache.clear();
            Cache<Object, Object> loginCache = cacheManager.getCache("shiro-activeSessionCache");
            cache.clear();
        }
        threadDemo.ex();
        return "login";
    }

    private void getOrganziationTree(List<Organization> organizations, List<OrganizationVO> organizationVOs, String parentId) {
        for (Organization org : organizations) {
            String par = org.getParent()==null?null:org.getParent().getId();
            if (parentId != null && parentId.equals(par)||par==null) {
                OrganizationVO orgVo = new OrganizationVO();
                orgVo.setId(org.getId());
                orgVo.setName(org.getName());
                orgVo.setParentId(par);
                organizationVOs.add(orgVo);
            }
            if (org.getChilds() != null && org.getChilds().size() > 0) {
                getOrganziationTree(org.getChilds(), organizationVOs, org.getId());
            }
        }
    }

    private void getMenuTree(List<SysMenu> menuList, List<SysMenuVO> menuVOs, String parentId){
        for(SysMenu menu : menuList){
            String parentMenuId = menu.getParent()==null?null:menu.getParent().getId();
            if(parentMenuId==null||(parentId!=null&&parentId.equals(parentMenuId))){
                SysMenuVO menuVO = new SysMenuVO();
                menuVO.setId(menu.getId());
                menuVO.setName(menu.getName());
                menuVO.setUrl(menu.getMenuUrl());
                menuVO.setParentId(parentMenuId);
                menuVOs.add(menuVO);
            }
            if(menu.getMenuList().size()>0){
                getMenuTree(menu.getMenuList(),menuVOs,menu.getId());
            }
        }
    }
}
