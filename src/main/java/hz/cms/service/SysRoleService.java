package hz.cms.service;

import hz.cms.model.SysRole;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 角色服务接口
 */
public interface SysRoleService {

    SysRole save(SysRole sysRole);

    List<SysRole> saveList(List<SysRole> list);

    List<SysRole> findAll();
}
