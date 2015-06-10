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
 * RefUrl generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="RefUrl"
    ,catalog="utms_latestV2"
)
public class RefUrl  implements java.io.Serializable {


     private Integer id;
     private Project project;
     private String url;
     private Set<ExeConfig> exeConfigs = new HashSet<ExeConfig>(0);

    public RefUrl() {
    }

    public RefUrl(Project project, String url, Set<ExeConfig> exeConfigs) {
       this.project = project;
       this.url = url;
       this.exeConfigs = exeConfigs;
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
    @JoinColumn(name="project_id")
    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }

    
    @Column(name="url", length=45)
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="refUrl")
    public Set<ExeConfig> getExeConfigs() {
        return this.exeConfigs;
    }
    
    public void setExeConfigs(Set<ExeConfig> exeConfigs) {
        this.exeConfigs = exeConfigs;
    }




}


