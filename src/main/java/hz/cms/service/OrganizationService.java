package hz.cms.service;

import hz.cms.model.Organization;

import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 组织机构服务接口
 */
public interface OrganizationService {

    public List<Organization> saveOrganizationList(List<Organization> list);

    List<Organization> findAll();

    List<Organization> findTopOrganization();
}
