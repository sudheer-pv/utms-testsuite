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
 * RefState generated by hbm2java
 */
@Entity
@Table(name="RefState"
    ,catalog="utms_latestV1"
)
public class RefState  implements java.io.Serializable {


     private Integer id;
     private RefCountry refCountry;
     private String name;
     private Set<Company> companies = new HashSet<Company>(0);

    public RefState() {
    }

    public RefState(RefCountry refCountry, String name, Set<Company> companies) {
       this.refCountry = refCountry;
       this.name = name;
       this.companies = companies;
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
    @JoinColumn(name="refCountry_id")
    public RefCountry getRefCountry() {
        return this.refCountry;
    }
    
    public void setRefCountry(RefCountry refCountry) {
        this.refCountry = refCountry;
    }

    
    @Column(name="name", length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="refState")
    public Set<Company> getCompanies() {
        return this.companies;
    }
    
    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }




}

