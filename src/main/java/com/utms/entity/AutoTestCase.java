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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * AutoTestCase generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="AutoTestCase"
    ,catalog="utms_latestV2"
)
public class AutoTestCase  implements java.io.Serializable {


     private Integer id;
     private TestCase testCase;
     private Module module;
     private String name;
     private Set<AllAutoSteps> allAutoStepsesForAutoTestcaseId = new HashSet<AllAutoSteps>(0);
     private Set<TestCaseResults> testCaseResultses = new HashSet<TestCaseResults>(0);
     private Set<ExeConfig> exeConfigs = new HashSet<ExeConfig>(0);
     private Set<AllAutoSteps> allAutoStepsesForLinkedAutoTestcaseId = new HashSet<AllAutoSteps>(0);

    public AutoTestCase() {
    }

    public AutoTestCase(TestCase testCase, Module module, String name, Set<AllAutoSteps> allAutoStepsesForAutoTestcaseId, Set<TestCaseResults> testCaseResultses, Set<ExeConfig> exeConfigs, Set<AllAutoSteps> allAutoStepsesForLinkedAutoTestcaseId) {
       this.testCase = testCase;
       this.module = module;
       this.name = name;
       this.allAutoStepsesForAutoTestcaseId = allAutoStepsesForAutoTestcaseId;
       this.testCaseResultses = testCaseResultses;
       this.exeConfigs = exeConfigs;
       this.allAutoStepsesForLinkedAutoTestcaseId = allAutoStepsesForLinkedAutoTestcaseId;
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
    @JoinColumn(name="testcase_id")
    public TestCase getTestCase() {
        return this.testCase;
    }
    
    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_id")
    public Module getModule() {
        return this.module;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="autoTestCaseByAutoTestcaseId")
@OrderBy("id ASC")
    public Set<AllAutoSteps> getAllAutoStepsesForAutoTestcaseId() {
        return this.allAutoStepsesForAutoTestcaseId;
    }
    
    public void setAllAutoStepsesForAutoTestcaseId(Set<AllAutoSteps> allAutoStepsesForAutoTestcaseId) {
        this.allAutoStepsesForAutoTestcaseId = allAutoStepsesForAutoTestcaseId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="autoTestCase")
    public Set<TestCaseResults> getTestCaseResultses() {
        return this.testCaseResultses;
    }
    
    public void setTestCaseResultses(Set<TestCaseResults> testCaseResultses) {
        this.testCaseResultses = testCaseResultses;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="ExeConfigAutoTestCase", catalog="utms_latestV2", joinColumns = { 
        @JoinColumn(name="autoTestCase_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="exeConfig_id", nullable=false, updatable=false) })
    public Set<ExeConfig> getExeConfigs() {
        return this.exeConfigs;
    }
    
    public void setExeConfigs(Set<ExeConfig> exeConfigs) {
        this.exeConfigs = exeConfigs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="autoTestCaseByLinkedAutoTestcaseId")
    public Set<AllAutoSteps> getAllAutoStepsesForLinkedAutoTestcaseId() {
        return this.allAutoStepsesForLinkedAutoTestcaseId;
    }
    
    public void setAllAutoStepsesForLinkedAutoTestcaseId(Set<AllAutoSteps> allAutoStepsesForLinkedAutoTestcaseId) {
        this.allAutoStepsesForLinkedAutoTestcaseId = allAutoStepsesForLinkedAutoTestcaseId;
    }

}


