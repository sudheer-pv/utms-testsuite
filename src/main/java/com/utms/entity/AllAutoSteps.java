package com.utms.entity;
// Generated 9 Jun, 2015 3:30:57 PM by Hibernate Tools 4.0.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AllAutoSteps generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="AllAutoSteps"
    ,catalog="utms_latestV2"
)
public class AllAutoSteps  implements java.io.Serializable {


     private Integer id;
     private AutoTestCase autoTestCaseByLinkedAutoTestcaseId;
     private AutoTestCase autoTestCaseByAutoTestcaseId;
     private AutoTestStep autoTestStep;
     private Boolean isTestStep;

    public AllAutoSteps() {
    }

    public AllAutoSteps(AutoTestCase autoTestCaseByLinkedAutoTestcaseId, AutoTestCase autoTestCaseByAutoTestcaseId, AutoTestStep autoTestStep, Boolean isTestStep) {
       this.autoTestCaseByLinkedAutoTestcaseId = autoTestCaseByLinkedAutoTestcaseId;
       this.autoTestCaseByAutoTestcaseId = autoTestCaseByAutoTestcaseId;
       this.autoTestStep = autoTestStep;
       this.isTestStep = isTestStep;
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
    @JoinColumn(name="linkedAutoTestcase_id")
    public AutoTestCase getAutoTestCaseByLinkedAutoTestcaseId() {
        return this.autoTestCaseByLinkedAutoTestcaseId;
    }
    
    public void setAutoTestCaseByLinkedAutoTestcaseId(AutoTestCase autoTestCaseByLinkedAutoTestcaseId) {
        this.autoTestCaseByLinkedAutoTestcaseId = autoTestCaseByLinkedAutoTestcaseId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="autoTestcase_id")
    public AutoTestCase getAutoTestCaseByAutoTestcaseId() {
        return this.autoTestCaseByAutoTestcaseId;
    }
    
    public void setAutoTestCaseByAutoTestcaseId(AutoTestCase autoTestCaseByAutoTestcaseId) {
        this.autoTestCaseByAutoTestcaseId = autoTestCaseByAutoTestcaseId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="autoTeststep_id")
    public AutoTestStep getAutoTestStep() {
        return this.autoTestStep;
    }
    
    public void setAutoTestStep(AutoTestStep autoTestStep) {
        this.autoTestStep = autoTestStep;
    }

    
    @Column(name="isTestStep")
    public Boolean getIsTestStep() {
        return this.isTestStep;
    }
    
    public void setIsTestStep(Boolean isTestStep) {
        this.isTestStep = isTestStep;
    }

	
}


