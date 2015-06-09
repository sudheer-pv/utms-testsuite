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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RefCountry generated by hbm2java
 */
@Entity
@Table(name="RefCountry"
    ,catalog="utms_latestV2"
)
public class RefCountry  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<RefState> refStates = new HashSet<RefState>(0);

    public RefCountry() {
    }

    public RefCountry(String name, Set<RefState> refStates) {
       this.name = name;
       this.refStates = refStates;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="refCountry")
    public Set<RefState> getRefStates() {
        return this.refStates;
    }
    
    public void setRefStates(Set<RefState> refStates) {
        this.refStates = refStates;
    }




}


