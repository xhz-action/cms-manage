package hz.cms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 角色
 */
@Entity
@Table(name = "cms_sys_role")
public class SysRole {

    @Id
    @GenericGenerator(name = "PKUUID",strategy = "uuid")
    @GeneratedValue(generator = "PKUUID")
    @Column(length = 36)
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Boolean deleteState;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role_link",
            joinColumns ={@JoinColumn(name = "role_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            foreignKey = @ForeignKey(name = "fk_ulr_role_id"),
            inverseForeignKey = @ForeignKey(name = "fk_ulr_user_id")
    )
    private List<SysUser> userList = new ArrayList<SysUser>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "role_menu_link",
            joinColumns ={@JoinColumn(name = "role_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id",referencedColumnName = "id")},
            foreignKey = @ForeignKey(name = "fk_rlm_role_id"),
            inverseForeignKey = @ForeignKey(name = "fk_rlm_menu_id")
    )
    private List<SysMenu> menuList = new ArrayList<SysMenu>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }

    public List<SysMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }

    public Boolean getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Boolean deleteState) {
        this.deleteState = deleteState;
    }
}
