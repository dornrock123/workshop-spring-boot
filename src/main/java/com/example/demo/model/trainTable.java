package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class trainTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stuid")
	public Integer stuid;
	
	@Column(name = "stucd")
	public String code;
	@Column(name = "stunname")
	public String name;
	@Column(name = "stufname")
	public String fname;
	@Column(name = "stulname")
	public String lname;


public void setId(Integer id) {
        this.stuid = id;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getId() {
        return this.stuid;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getFname() {
        return this.fname;
    }
    
    public String getLname() {
        return this.lname;
    }
    
}