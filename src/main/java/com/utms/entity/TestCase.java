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
 * TestCase generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="TestCase")
public class TestCase  implements java.io.Serializable {


     private Integer id;
     private RefTestType refTestType;
     private Module module;
     private RefTestPriority refTestPriority;
     private String name;
     private String tcId;
     private String requirement;
     private String createdBy;
     private String expectedResult;
     private String preCondition;
     private Set<TestStep> testSteps = new HashSet<TestStep>(0);
     private Set<AutoTestCase> autoTestCases = new HashSet<AutoTestCase>(0);
     private Set<AllSteps> allStepsesForLinkedtestcaseId = new HashSet<AllSteps>(0);
     private Set<AllSteps> allStepsesForTestcaseId = new HashSet<AllSteps>(0);

    public TestCase() {
    }

    public TestCase(RefTestType refTestType, Module module, RefTestPriority refTestPriority, String name, String tcId, String requirement, String createdBy, String expectedResult, String preCondition, Set<TestStep> testSteps, Set<AutoTestCase> autoTestCases, Set<AllSteps> allStepsesForLinkedtestcaseId, Set<AllSteps> allStepsesForTestcaseId) {
       this.refTestType = refTestType;
       this.module = module;
       this.refTestPriority = refTestPriority;
       this.name = name;
       this.tcId = tcId;
       this.requirement = requirement;
       this.createdBy = createdBy;
       this.expectedResult = expectedResult;
       this.preCondition = preCondition;
       this.testSteps = testSteps;
       this.autoTestCases = autoTestCases;
       this.allStepsesForLinkedtestcaseId = allStepsesForLinkedtestcaseId;
       this.allStepsesForTestcaseId = allStepsesForTestcaseId;
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
    @JoinColumn(name="refTestType_id")
    public RefTestType getRefTestType() {
        return this.refTestType;
    }
    
    public void setRefTestType(RefTestType refTestType) {
        this.refTestType = refTestType;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_id")
    public Module getModule() {
        return this.module;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="refTestPriority_id")
    public RefTestPriority getRefTestPriority() {
        return this.refTestPriority;
    }
    
    public void setRefTestPriority(RefTestPriority refTestPriority) {
        this.refTestPriority = refTestPriority;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="tc_id", length=45)
    public String getTcId() {
        return this.tcId;
    }
    
    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    
    @Column(name="requirement", length=45)
    public String getRequirement() {
        return this.requirement;
    }
    
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    
    @Column(name="createdBy", length=45)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    
    @Column(name="expectedResult", length=45)
    public String getExpectedResult() {
        return this.expectedResult;
    }
    
    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    
    @Column(name="preCondition", length=10)
    public String getPreCondition() {
        return this.preCondition;
    }
    
    public void setPreCondition(String preCondition) {
        this.preCondition = preCondition;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="testCase")
    public Set<TestStep> getTestSteps() {
        return this.testSteps;
    }
    
    public void setTestSteps(Set<TestStep> testSteps) {
        this.testSteps = testSteps;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="testCase")
    public Set<AutoTestCase> getAutoTestCases() {
        return this.autoTestCases;
    }
    
    public void setAutoTestCases(Set<AutoTestCase> autoTestCases) {
        this.autoTestCases = autoTestCases;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="testCaseByLinkedtestcaseId")
    public Set<AllSteps> getAllStepsesForLinkedtestcaseId() {
        return this.allStepsesForLinkedtestcaseId;
    }
    
    public void setAllStepsesForLinkedtestcaseId(Set<AllSteps> allStepsesForLinkedtestcaseId) {
        this.allStepsesForLinkedtestcaseId = allStepsesForLinkedtestcaseId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="testCaseByTestcaseId")
    public Set<AllSteps> getAllStepsesForTestcaseId() {
        return this.allStepsesForTestcaseId;
    }
    
    public void setAllStepsesForTestcaseId(Set<AllSteps> allStepsesForTestcaseId) {
        this.allStepsesForTestcaseId = allStepsesForTestcaseId;
    }




}


