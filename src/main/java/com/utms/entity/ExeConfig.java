package com.utms.entity;
// Generated 3 Jun, 2015 12:49:41 PM by Hibernate Tools 4.0.0


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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ExeConfig generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ExeConfig"
    ,catalog="utms_latest"
)
public class ExeConfig  implements java.io.Serializable {


     private Integer id;
     private Project project;
     private String runId;
     private String url;
     private String selectedCases;
     private Set<RefOperatingSystem> refOperatingSystems = new HashSet<RefOperatingSystem>(0);
     private Set<RefBrowser> refBrowsers = new HashSet<RefBrowser>(0);

    public ExeConfig() {
    }

    public ExeConfig(Project project, String runId, String url, String selectedCases, Set<RefOperatingSystem> refOperatingSystems, Set<RefBrowser> refBrowsers) {
       this.project = project;
       this.runId = runId;
       this.url = url;
       this.selectedCases = selectedCases;
       this.refOperatingSystems = refOperatingSystems;
       this.refBrowsers = refBrowsers;
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

    
    @Column(name="runId", length=45)
    public String getRunId() {
        return this.runId;
    }
    
    public void setRunId(String runId) {
        this.runId = runId;
    }

    
    @Column(name="url", length=45)
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    
    @Column(name="selectedCases", length=45)
    public String getSelectedCases() {
        return this.selectedCases;
    }
    
    public void setSelectedCases(String selectedCases) {
        this.selectedCases = selectedCases;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="ExeConfigRefOS", catalog="utms_latest", joinColumns = { 
        @JoinColumn(name="exeConfig_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="refOperatingSystem_id", nullable=false, updatable=false) })
    public Set<RefOperatingSystem> getRefOperatingSystems() {
        return this.refOperatingSystems;
    }
    
    public void setRefOperatingSystems(Set<RefOperatingSystem> refOperatingSystems) {
        this.refOperatingSystems = refOperatingSystems;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="ExeConfigRefBrowser", catalog="utms_latest", joinColumns = { 
        @JoinColumn(name="exeConfig_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="refBrowser_id", nullable=false, updatable=false) })
    public Set<RefBrowser> getRefBrowsers() {
        return this.refBrowsers;
    }
    
    public void setRefBrowsers(Set<RefBrowser> refBrowsers) {
        this.refBrowsers = refBrowsers;
    }




}

