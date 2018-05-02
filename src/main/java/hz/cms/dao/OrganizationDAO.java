package hz.cms.dao;

import hz.cms.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 组织机构DAO
 */
public interface OrganizationDAO extends JpaRepository<Organization,String>{

    List<Organization> findByParentIsNull();
}
