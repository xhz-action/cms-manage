package hz.cms.dao;

import hz.cms.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xhz on 2017/11/20.
 * 角色DAO
 */
public interface SysRoleDAO extends JpaRepository<SysRole,String>{
}
