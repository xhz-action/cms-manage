package hz.cms.dao;

import hz.cms.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xhz on 2017/11/20.
 * 用户DAO
 */
public interface SysUserDAO extends JpaRepository<SysUser,String>{
}
