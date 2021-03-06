package com.utms.entity;
// Generated 3 Jun, 2015 12:49:41 PM by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Project generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Project")
public class Project  implements java.io.Serializable {


     private Integer id;
     private long refDomainId;
     private long companyId;
     private String name;
     private String code;
     private String description;
     private String website;
     private Date startDate;
     private Date endDate;
     private Set<TestData> testDatas = new HashSet<TestData>(0);
     private Set<ExeConfig> exeConfigs = new HashSet<ExeConfig>(0);
     private Set<User> users = new HashSet<User>(0);
     private Set<Role> roles = new HashSet<Role>(0);
     private Set<Module> modules = new HashSet<Module>(0);
     private Set<RefKeyword> refKeywords = new HashSet<RefKeyword>(0);

    public Project() {
    }

    public Project(long refDomainId, long companyId, String name, String code, String description, String website, Date startDate, Date endDate, Set<TestData> testDatas, Set<ExeConfig> exeConfigs, Set<User> users, Set<Role> roles, Set<Module> modules, Set<RefKeyword> refKeywords) {
       this.refDomainId = refDomainId;
       this.companyId = companyId;
       this.name = name;
       this.code = code;
       this.description = description;
       this.website = website;
       this.startDate = startDate;
       this.endDate = endDate;
       this.testDatas = testDatas;
       this.exeConfigs = exeConfigs;
       this.users = users;
       this.roles = roles;
       this.modules = modules;
       this.refKeywords = refKeywords;
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
    @JoinColumn(name="domain_id")*/
    public long getRefDomain() {
        return this.refDomainId;
    }
    
    public void setRefDomain(long refDomainId) {
        this.refDomainId = refDomainId;
    }

/*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="company_id")*/
    public long getCompany() {
        return this.companyId;
    }
    
    public void setCompany(long companyId) {
        this.companyId = companyId;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="code", length=45)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    
    @Column(name="description", length=250)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="website", length=45)
    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="startDate", length=10)
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="endDate", length=10)
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="project")
    public Set<TestData> getTestDatas() {
        return this.testDatas;
    }
    
    public void setTestDatas(Set<TestData> testDatas) {
        this.testDatas = testDatas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="project")
    public Set<ExeConfig> getExeConfigs() {
        return this.exeConfigs;
    }
    
    public void setExeConfigs(Set<ExeConfig> exeConfigs) {
        this.exeConfigs = exeConfigs;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="ProjectUser", catalog="utms_latest", joinColumns = { 
        @JoinColumn(name="project_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) })
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="project")
    public Set<Role> getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="project")
    public Set<Module> getModules() {
        return this.modules;
    }
    
    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="project")
    public Set<RefKeyword> getRefKeywords() {
        return this.refKeywords;
    }
    
    public void setRefKeywords(Set<RefKeyword> refKeywords) {
        this.refKeywords = refKeywords;
    }




}


