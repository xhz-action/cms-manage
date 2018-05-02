package hz.cms.service;

import hz.cms.model.SysMenu;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 菜单服务接口
 */
public interface SysMenuService {

    public List<SysMenu> saveSysMenuList(List<SysMenu> list);

    List<SysMenu> findAll();

    List<SysMenu> findTopSysMenu();
}
