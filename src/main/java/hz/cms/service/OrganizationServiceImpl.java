package hz.cms.service;

import hz.cms.dao.OrganizationDAO;
import hz.cms.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 */
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private OrganizationDAO organizationDAO;

    @Override
    public List<Organization> saveOrganizationList(List<Organization> list) {
        return organizationDAO.save(list);
    }

    @Override
    public List<Organization> findAll() {
        return organizationDAO.findAll();
    }

    @Override
    public List<Organization> findTopOrganization() {
        return organizationDAO.findByParentIsNull();
    }
}
