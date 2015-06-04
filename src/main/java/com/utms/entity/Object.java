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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Object generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Object"
    ,catalog="utms_latest"
)
public class Object  implements java.io.Serializable {


     private Integer id;
     private ObjectRepo objectRepo;
     private RefObjectType refObjectType;
     private String name;
     private String locator;
     private Set<AutoTestStep> autoTestSteps = new HashSet<AutoTestStep>(0);

    public Object() {
    }

    public Object(ObjectRepo objectRepo, RefObjectType refObjectType, String name, String locator, Set<AutoTestStep> autoTestSteps) {
       this.objectRepo = objectRepo;
       this.refObjectType = refObjectType;
       this.name = name;
       this.locator = locator;
       this.autoTestSteps = autoTestSteps;
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
    @JoinColumn(name="objectRepo_id")
    public ObjectRepo getObjectRepo() {
        return this.objectRepo;
    }
    
    public void setObjectRepo(ObjectRepo objectRepo) {
        this.objectRepo = objectRepo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="refObjectType_id")
    public RefObjectType getRefObjectType() {
        return this.refObjectType;
    }
    
    public void setRefObjectType(RefObjectType refObjectType) {
        this.refObjectType = refObjectType;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="locator", length=45)
    public String getLocator() {
        return this.locator;
    }
    
    public void setLocator(String locator) {
        this.locator = locator;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="object")
    public Set<AutoTestStep> getAutoTestSteps() {
        return this.autoTestSteps;
    }
    
    public void setAutoTestSteps(Set<AutoTestStep> autoTestSteps) {
        this.autoTestSteps = autoTestSteps;
    }




}

