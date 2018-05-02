package hz.cms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 用户
 */
@Entity
@Table(name = "cms_sys_user")
public class SysUser {

    @Id
    @GenericGenerator(name = "PKUUID",strategy = "uuid")
    @GeneratedValue(generator = "PKUUID")
    @Column(length = 36)
    private String id;

    @Column
    private String name;

    @Column
    private String password;

    @Column(length = 3)
    private String sex;

    @Column
    private Date birthDate;

    @Column
    private Boolean deleteState;

    public Boolean getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Boolean deleteState) {
        this.deleteState = deleteState;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id",foreignKey =@ForeignKey(name = "fk_organization_id") )
    private Organization organization;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role_link",
            joinColumns ={@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},
            foreignKey = @ForeignKey(name = "fk_ulr_user_id"),
            inverseForeignKey = @ForeignKey(name = "fk_ulr_role_id")
    )
    private List<SysRole> roleList = new ArrayList<SysRole>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
