package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


//Here use lombok jar 
//@Data or
@SuppressWarnings("serial")
@Setter
@Getter

public class Event implements Serializable {
	
	private int id;
	
	private String name;
	
	private Date doe;
	
	private int pax;
	
	private String location;
	

}