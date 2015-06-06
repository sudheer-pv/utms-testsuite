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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * RefOperatingSystem generated by hbm2java
 */
@Entity
@Table(name="RefOperatingSystem"
    ,catalog="utms_latestV1"
)
public class RefOperatingSystem  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<ExeConfig> exeConfigs = new HashSet<ExeConfig>(0);

    public RefOperatingSystem() {
    }

    public RefOperatingSystem(String name, Set<ExeConfig> exeConfigs) {
       this.name = name;
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

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="ExeConfigRefOS", catalog="utms_latestV1", joinColumns = { 
        @JoinColumn(name="refOperatingSystem_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="exeConfig_id", nullable=false, updatable=false) })
    public Set<ExeConfig> getExeConfigs() {
        return this.exeConfigs;
    }
    
    public void setExeConfigs(Set<ExeConfig> exeConfigs) {
        this.exeConfigs = exeConfigs;
    }




}


