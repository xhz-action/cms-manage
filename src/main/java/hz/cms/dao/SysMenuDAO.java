package hz.cms.dao;

import hz.cms.model.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 菜单DAO
 */
public interface SysMenuDAO extends JpaRepository<SysMenu,String>{

    public List<SysMenu> findByParentIsNull();
}
