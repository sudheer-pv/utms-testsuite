package com.utms.entity
;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="person")
public class Person  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="name")
    private String name;
	
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id : "+id+"  :: Name: "+name;
	}

    
    protected Person() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}




}

