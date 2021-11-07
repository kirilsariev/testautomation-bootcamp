package com.musala.unitdemo.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test_person_default_constructor() {
		Person person = new Person();

		person.setFirstName("Mary");
		assertEquals("Mary", person.getFirstName());

		person.setMiddleName("Petrova");
		assertEquals("Petrova", person.getMiddleName());

		person.setLastName("Ivanova");
		assertEquals("Ivanova", person.getLastName());
	}

}
