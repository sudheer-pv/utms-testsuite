package com.utms.entity;
// Generated 6 Jun, 2015 5:49:38 PM by Hibernate Tools 4.0.0


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
 * AllSteps generated by hbm2java
 */
@Entity
@Table(name="AllSteps"
    ,catalog="utms_latestV1"
)
public class AllSteps  implements java.io.Serializable {


     private Integer id;
     private TestCase testCaseByTestcaseId;
     private TestStep testStep;
     private TestCase testCaseByLinkedtestcaseId;
     private Boolean isTestStep;

    public AllSteps() {
    }

    public AllSteps(TestCase testCaseByTestcaseId, TestStep testStep, TestCase testCaseByLinkedtestcaseId, Boolean isTestStep) {
       this.testCaseByTestcaseId = testCaseByTestcaseId;
       this.testStep = testStep;
       this.testCaseByLinkedtestcaseId = testCaseByLinkedtestcaseId;
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
    @JoinColumn(name="testcase_id")
    public TestCase getTestCaseByTestcaseId() {
        return this.testCaseByTestcaseId;
    }
    
    public void setTestCaseByTestcaseId(TestCase testCaseByTestcaseId) {
        this.testCaseByTestcaseId = testCaseByTestcaseId;
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
    @JoinColumn(name="linkedtestcase_id")
    public TestCase getTestCaseByLinkedtestcaseId() {
        return this.testCaseByLinkedtestcaseId;
    }
    
    public void setTestCaseByLinkedtestcaseId(TestCase testCaseByLinkedtestcaseId) {
        this.testCaseByLinkedtestcaseId = testCaseByLinkedtestcaseId;
    }

    
    @Column(name="isTestStep")
    public Boolean getIsTestStep() {
        return this.isTestStep;
    }
    
    public void setIsTestStep(Boolean isTestStep) {
        this.isTestStep = isTestStep;
    }




}


