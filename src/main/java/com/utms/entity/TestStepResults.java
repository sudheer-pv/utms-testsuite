package com.utms.entity;
// Generated 6 Jun, 2015 5:49:38 PM by Hibernate Tools 4.0.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TestStepResults generated by hbm2java
 */
@Entity
@Table(name="TestStepResults"
    ,catalog="utms_latestV1"
)
public class TestStepResults  implements java.io.Serializable {


     private Integer id;
     private TestCaseResults testCaseResults;
     private String result;
     private String errorReason;
     private Date startDateTime;
     private Date endDateTime;
     private String comments;

    public TestStepResults() {
    }

    public TestStepResults(TestCaseResults testCaseResults, String result, String errorReason, Date startDateTime, Date endDateTime, String comments) {
       this.testCaseResults = testCaseResults;
       this.result = result;
       this.errorReason = errorReason;
       this.startDateTime = startDateTime;
       this.endDateTime = endDateTime;
       this.comments = comments;
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
    @JoinColumn(name="testCaseResult_id")
    public TestCaseResults getTestCaseResults() {
        return this.testCaseResults;
    }
    
    public void setTestCaseResults(TestCaseResults testCaseResults) {
        this.testCaseResults = testCaseResults;
    }

    
    @Column(name="result", length=100)
    public String getResult() {
        return this.result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }

    
    @Column(name="errorReason", length=100)
    public String getErrorReason() {
        return this.errorReason;
    }
    
    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="startDateTime", length=10)
    public Date getStartDateTime() {
        return this.startDateTime;
    }
    
    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="endDateTime", length=10)
    public Date getEndDateTime() {
        return this.endDateTime;
    }
    
    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    
    @Column(name="comments", length=100)
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }




}

