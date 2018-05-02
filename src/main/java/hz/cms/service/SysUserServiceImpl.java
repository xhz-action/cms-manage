package hz.cms.service;

import hz.cms.dao.SysUserDAO;
import hz.cms.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserDAO sysUserDAO;

    @Override
    public SysUser save(SysUser sysUser) {
        return sysUserDAO.save(sysUser);
    }

    @Override
    public List<SysUser> saveList(List<SysUser> list) {
        return sysUserDAO.save(list);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserDAO.findAll();
    }
}
