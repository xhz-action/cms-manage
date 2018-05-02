package hz.cms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 菜单
 */
@Entity
@Table(name = "cms_sys_menu")
public class SysMenu {

    @Id
    @GenericGenerator(name = "PKUUID",strategy = "uuid")
    @GeneratedValue(generator = "PKUUID")
    @Column(length = 36)
    private String id;

    @Column
    private String name;

    @Column
    private String menuUrl;

    @Column
    private Boolean deleteState;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id",foreignKey = @ForeignKey(name = "fk_menu_id"))
    private SysMenu parent;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "parent")
    private List<SysMenu> menuList = new ArrayList<SysMenu>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "role_menu_link",
            joinColumns = {@JoinColumn(name = "menu_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},
            foreignKey = @ForeignKey(name = "fk_rlm_menu_id"),
            inverseForeignKey = @ForeignKey(name = "fk_rlm_role_id")
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

    public SysMenu getParent() {
        return parent;
    }

    public void setParent(SysMenu parent) {
        this.parent = parent;
    }

    public List<SysMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Boolean getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Boolean deleteState) {
        this.deleteState = deleteState;
    }
}
