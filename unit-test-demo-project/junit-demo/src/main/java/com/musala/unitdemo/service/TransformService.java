package com.musala.unitdemo.service;

import org.springframework.stereotype.Component;

import com.musala.unitdemo.entity.Person;

@Component
public class TransformService {

	public User toUserDomain(final Person person) {
		User user = new User();
		user.setCompanyName(person.getCompanyName());
		user.setFirstName(person.getFirstName());
		user.setLastName(person.getLastName());
		user.setUserId(person.getPersonId());
		return user;
	}

	public Person toUserEntity(final User user) {
		Person person = new Person();
		person.setCompanyName(user.getCompanyName());
		person.setFirstName(user.getFirstName());
		person.setLastName(user.getLastName());
		if (user.getUserId() != null) {
			person.setPersonId(user.getUserId());
		}
		return person;
	}
}
