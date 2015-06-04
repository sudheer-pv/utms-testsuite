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
 * AutoTestCase generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="AutoTestCase"
    ,catalog="utms_latest"
)
public class AutoTestCase  implements java.io.Serializable {


     private Integer id;
     private TestCase testCase;
     private long moduleId;
     private String name;
     private Set<AutoTestStep> autoTestSteps = new HashSet<AutoTestStep>(0);

    public AutoTestCase() {
    }

    public AutoTestCase(TestCase testCase, long moduleId, String name, Set<AutoTestStep> autoTestSteps) {
       this.testCase = testCase;
       this.moduleId = moduleId;
       this.name = name;
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
    @JoinColumn(name="testcase_id")
    public TestCase getTestCase() {
        return this.testCase;
    }
    
    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

/*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_id")*/
    public long getModule() {
        return this.moduleId;
    }
    
    public void setModule(long moduleId) {
        this.moduleId = moduleId;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="autoTestCase")
    public Set<AutoTestStep> getAutoTestSteps() {
        return this.autoTestSteps;
    }
    
    public void setAutoTestSteps(Set<AutoTestStep> autoTestSteps) {
        this.autoTestSteps = autoTestSteps;
    }




}

