package hz.cms.service;

import hz.cms.dao.SysMenuDAO;
import hz.cms.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 */
@Service
@Transactional
public class SysMenuServiceImpl implements SysMenuService{

    @Autowired
    private SysMenuDAO sysMenuDAO;

    @Override
    public List<SysMenu> saveSysMenuList(List<SysMenu> list) {
        return sysMenuDAO.save(list);
    }

    @Override
    public List<SysMenu> findAll() {
        return sysMenuDAO.findAll();
    }

    @Override
    public List<SysMenu> findTopSysMenu() {
        return sysMenuDAO.findByParentIsNull();
    }
}
