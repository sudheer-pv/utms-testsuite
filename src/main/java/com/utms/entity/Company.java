package com.utms.entity;
// Generated 6 Jun, 2015 5:49:38 PM by Hibernate Tools 4.0.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name="Company"
    ,catalog="utms_latestV1"
)
public class Company  implements java.io.Serializable {


     private Integer id;
     private RefState refState;
     private String name;
     private String legalName;
     private String website;
     private String city;
     private String street;
     private Integer zip;
     private String logo;
     private Set<Project> projects = new HashSet<Project>(0);
     private Set<User> users = new HashSet<User>(0);

    public Company() {
    }

    public Company(RefState refState, String name, String legalName, String website, String city, String street, Integer zip, String logo, Set<Project> projects, Set<User> users) {
       this.refState = refState;
       this.name = name;
       this.legalName = legalName;
       this.website = website;
       this.city = city;
       this.street = street;
       this.zip = zip;
       this.logo = logo;
       this.projects = projects;
       this.users = users;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="refState_id")
    public RefState getRefState() {
        return this.refState;
    }
    
    public void setRefState(RefState refState) {
        this.refState = refState;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="legal_name", length=45)
    public String getLegalName() {
        return this.legalName;
    }
    
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    
    @Column(name="website", length=45)
    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }

    
    @Column(name="city", length=45)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="street", length=45)
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    
    @Column(name="zip")
    public Integer getZip() {
        return this.zip;
    }
    
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    
    @Column(name="logo", length=45)
    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="company")
    public Set<Project> getProjects() {
        return this.projects;
    }
    
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="company")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}


