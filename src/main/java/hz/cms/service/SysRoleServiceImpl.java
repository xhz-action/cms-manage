package hz.cms.service;

import hz.cms.dao.SysRoleDAO;
import hz.cms.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 */
@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleDAO sysRoleDAO;

    @Override
    public SysRole save(SysRole sysRole) {
        return sysRoleDAO.save(sysRole);
    }

    @Override
    public List<SysRole> saveList(List<SysRole> list) {
        return sysRoleDAO.save(list);
    }

    @Override
    public List<SysRole> findAll() {
        return sysRoleDAO.findAll();
    }
}
