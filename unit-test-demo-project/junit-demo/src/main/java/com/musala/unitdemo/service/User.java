package com.musala.unitdemo.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String companyName;

	private String firstName;

	private String lastName;

	private Integer userId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			return other.userId == null;
		} else return userId.equals(other.userId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

}
