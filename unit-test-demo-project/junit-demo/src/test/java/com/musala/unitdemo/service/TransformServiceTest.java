package com.musala.unitdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.musala.unitdemo.entity.Person;

public class TransformServiceTest {

	private TransformService testClass = new TransformService() ;

	@Test
	public void test_toDomain() {
		Person person = new Person();
		person.setCompanyName("test company");
		person.setFirstName("Mary");
		person.setLastName("Ivanova");
		person.setMiddleName("Petrova");
		person.setPersonId(1);
		User user = testClass.toUserDomain(person);

		assertNotNull(user);
		assertEquals("test company", user.getCompanyName());
		assertEquals("Mary", user.getFirstName());
		assertEquals("Ivanova", user.getLastName());
		assertEquals(1, user.getUserId().intValue());
	}

	// Homework
	@Test
	public void test_toEntity() {
	}

}
