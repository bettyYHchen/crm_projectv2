package com.busyqa.crm.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Role")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List< CrmUser > crmUsers;

    public long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<CrmUser> getCrmUsers() {
        return crmUsers;
    }

    public void setCrmUsers(List<CrmUser> crmUsers) {
        this.crmUsers = crmUsers;
    }
}
