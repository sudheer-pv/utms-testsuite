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
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * AutoTestStep generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="AutoTestStep"
    ,catalog="utms_latestV2"
)
public class AutoTestStep  implements java.io.Serializable {


     private Integer id;
     private Object object;
     private TestStep testStep;
     private RefKeyword refKeyword;
     private String testData;
     private Set<AllAutoSteps> allAutoStepses = new HashSet<AllAutoSteps>(0);

    public AutoTestStep() {
    }

    public AutoTestStep(Object object, TestStep testStep, RefKeyword refKeyword, String testData, Set<AllAutoSteps> allAutoStepses) {
       this.object = object;
       this.testStep = testStep;
       this.refKeyword = refKeyword;
       this.testData = testData;
       this.allAutoStepses = allAutoStepses;
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
    @JoinColumn(name="field_id")
    public Object getObject() {
        return this.object;
    }
    
    public void setObject(Object object) {
        this.object = object;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="teststep_id")
    public TestStep getTestStep() {
        return this.testStep;
    }
    
    public void setTestStep(TestStep testStep) {
        this.testStep = testStep;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="refKeyword_id")
    public RefKeyword getRefKeyword() {
        return this.refKeyword;
    }
    
    public void setRefKeyword(RefKeyword refKeyword) {
        this.refKeyword = refKeyword;
    }

    
    @Column(name="testData", length=45)
    public String getTestData() {
        return this.testData;
    }
    
    public void setTestData(String testData) {
        this.testData = testData;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="autoTestStep")
@OrderBy("id ASC")
    public Set<AllAutoSteps> getAllAutoStepses() {
        return this.allAutoStepses;
    }
    
    public void setAllAutoStepses(Set<AllAutoSteps> allAutoStepses) {
        this.allAutoStepses = allAutoStepses;
    }




}


