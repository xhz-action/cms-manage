package hz.cms.service;

import hz.cms.model.SysUser;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 用户服务接口
 */
public interface SysUserService {

    SysUser save(SysUser sysUser);

    List<SysUser> saveList(List<SysUser> list);

    List<SysUser> findAll();
}
