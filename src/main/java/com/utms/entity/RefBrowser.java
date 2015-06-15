package com.utms.entity;
// Generated 9 Jun, 2015 3:30:57 PM by Hibernate Tools 4.0.0


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RefBrowser generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="RefBrowser"
    ,catalog="utms_latestV2"
)
public class RefBrowser  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String imgUrl;
     private Set<RefOsRefBrowser> refOsRefBrowsers = new HashSet<RefOsRefBrowser>(0);

    public RefBrowser() {
    }

    public RefBrowser(String name, String imgUrl, Set<RefOsRefBrowser> refOsRefBrowsers) {
       this.name = name;
       this.imgUrl = imgUrl;
       this.refOsRefBrowsers = refOsRefBrowsers;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="img_url", length=45)
    public String getImgUrl() {
        return this.imgUrl;
    }
    
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="refBrowser")
    public Set<RefOsRefBrowser> getRefOsRefBrowsers() {
        return this.refOsRefBrowsers;
    }
    
    public void setRefOsRefBrowsers(Set<RefOsRefBrowser> refOsRefBrowsers) {
        this.refOsRefBrowsers = refOsRefBrowsers;
    }




}


