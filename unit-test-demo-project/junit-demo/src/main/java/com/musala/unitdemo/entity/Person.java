package com.musala.unitdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {

	private String companyName;

	private String firstName;
	private String lastName;
	private String middleName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;

}
