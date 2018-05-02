package hz.cms.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhz on 2017/11/20.
 * 组织机构
 */
@Entity
@Table(name = "cms_organization")
public class Organization {

    @Id
    @GenericGenerator(name = "PKUUID",strategy = "uuid")
    @GeneratedValue(generator = "PKUUID")
    @Column(length = 36)
    private String id;

    /**
     * 名称
     */
    @Column
    private String name;

    @Column
    private Boolean deleteState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id",foreignKey = @ForeignKey(name = "fk_organization_parent"))
    private Organization parent;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "parent")
    private List<Organization> childs = new ArrayList<Organization>();

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

    public Organization getParent() {
        return parent;
    }

    public void setParent(Organization parent) {
        this.parent = parent;
    }

    public List<Organization> getChilds() {
        return childs;
    }

    public void setChilds(List<Organization> childs) {
        this.childs = childs;
    }

    public Boolean getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Boolean deleteState) {
        this.deleteState = deleteState;
    }
}
