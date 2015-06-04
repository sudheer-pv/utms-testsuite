package com.utms.entity;
// Generated 3 Jun, 2015 12:49:41 PM by Hibernate Tools 4.0.0


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="User"
    ,catalog="utms_latest"
)
public class User  implements java.io.Serializable {


     private Integer id;
     private long companyId;
     private String firstName;
     private String middleName;
     private String lastName;
     private String email;
     private String password;
     private String displayName;
     private Boolean isCompanyAdmin;
     private String status;
     private Set<Role> roles = new HashSet<Role>(0);
     private Set<Project> projects = new HashSet<Project>(0);

    public User() {
    }

    public User(long companyId, String firstName, String middleName, String lastName, String email, String password, String displayName, Boolean isCompanyAdmin, String status, Set<Role> roles, Set<Project> projects) {
       this.companyId = companyId;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.email = email;
       this.password = password;
       this.displayName = displayName;
       this.isCompanyAdmin = isCompanyAdmin;
       this.status = status;
       this.roles = roles;
       this.projects = projects;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

/*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="company_id")*/
    public long getCompany() {
        return this.companyId;
    }
    
    public void setCompany(long companyId) {
        this.companyId = companyId;
    }

    
    @Column(name="firstName", length=45)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="middleName", length=45)
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    
    @Column(name="lastName", length=45)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="password", length=150)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="displayName", length=45)
    public String getDisplayName() {
        return this.displayName;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    
    @Column(name="isCompanyAdmin")
    public Boolean getIsCompanyAdmin() {
        return this.isCompanyAdmin;
    }
    
    public void setIsCompanyAdmin(Boolean isCompanyAdmin) {
        this.isCompanyAdmin = isCompanyAdmin;
    }

    
    @Column(name="status", length=10)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="UserRole", catalog="utms_latest", joinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="role_id", nullable=false, updatable=false) })
    public Set<Role> getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="ProjectUser", catalog="utms_latest", joinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="project_id", nullable=false, updatable=false) })
    public Set<Project> getProjects() {
        return this.projects;
    }
    
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }




}

