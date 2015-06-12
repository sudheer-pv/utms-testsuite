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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RefOsRefBrowser generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="RefOsRefBrowser"
    ,catalog="utms_latestV2"
)
public class RefOsRefBrowser  implements java.io.Serializable {


     private Integer id;
     private RefOperatingSystem refOperatingSystem;
     private RefBrowser refBrowser;
     private Set<ExeConfigRefOsRefBrowser> exeConfigRefOsRefBrowsers = new HashSet<ExeConfigRefOsRefBrowser>(0);

    public RefOsRefBrowser() {
    }

    public RefOsRefBrowser(RefOperatingSystem refOperatingSystem, RefBrowser refBrowser, Set<ExeConfigRefOsRefBrowser> exeConfigRefOsRefBrowsers) {
       this.refOperatingSystem = refOperatingSystem;
       this.refBrowser = refBrowser;
       this.exeConfigRefOsRefBrowsers = exeConfigRefOsRefBrowsers;
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
    @JoinColumn(name="refOs_id")
    public RefOperatingSystem getRefOperatingSystem() {
        return this.refOperatingSystem;
    }
    
    public void setRefOperatingSystem(RefOperatingSystem refOperatingSystem) {
        this.refOperatingSystem = refOperatingSystem;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="refBrowser_id")
    public RefBrowser getRefBrowser() {
        return this.refBrowser;
    }
    
    public void setRefBrowser(RefBrowser refBrowser) {
        this.refBrowser = refBrowser;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="refOsRefBrowser")
    public Set<ExeConfigRefOsRefBrowser> getExeConfigRefOsRefBrowsers() {
        return this.exeConfigRefOsRefBrowsers;
    }
    
    public void setExeConfigRefOsRefBrowsers(Set<ExeConfigRefOsRefBrowser> exeConfigRefOsRefBrowsers) {
        this.exeConfigRefOsRefBrowsers = exeConfigRefOsRefBrowsers;
    }

	@Override
	public String toString() {
		return "RefOsRefBrowser [id=" + id + ", refOperatingSystem="
				+ refOperatingSystem + ", refBrowser=" + refBrowser
				+ ", exeConfigRefOsRefBrowsers=" + exeConfigRefOsRefBrowsers
				+ "]";
	}
    
    



}


